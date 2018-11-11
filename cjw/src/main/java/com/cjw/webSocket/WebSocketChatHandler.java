package com.cjw.webSocket;

import com.cjw.async.MessageTask;
import com.cjw.pojo.MessagePojo;
import com.cjw.utils.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WebSocketChatHandler implements WebSocketHandler {
    private static final List<WebSocketSession> users = new ArrayList<>();

    @Autowired
    private MessageTask messageTask;

    private Integer getUserId(WebSocketSession session) {
        List<String> list = session.getHandshakeHeaders().get("userId");
        if (CollectionUtils.isNotEmpty(list)) {
            return Integer.parseInt(list.get(0));
        }
        return null;
    }

    // 用户进入系统监听
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Integer userId = getUserId(session);
        System.out.println("用户" + userId + "开启了websocket");
        users.add(session);

//        sendMessagesToUsers(new TextMessage("这是群发消息"));
    }

    /**
     * 消息处理
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        // 将消息进行转化，因为是消息是json数据，可能里面包含了发送给某个人的信息，所以需要用json相关的工具类处理之后再封装成TextMessage，
        String msg = (String) message.getPayload();
        MessagePojo messagePojo = messageTask.convertToMessagePojo(msg);
        // 给所有用户群发消息
        //sendMessagesToUsers(msg);
        // 给指定用户群发消息
        sendMessageToUser(messagePojo, message);

    }

    /**
     * 错误信息处理
     *
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    /**
     * 关闭连接后删除session信息
     *
     * @param session
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        users.remove(session);
        System.out.println("用户" + getUserId(session) + "关闭了连接");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 群发消息
     *
     * @param message
     */
    public void sendMessagesToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                // isOpen()在线就发送
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 向指定用户发送信息
     *
     * @param messagePojo
     * @param message
     */
    private void sendMessageToUser(MessagePojo messagePojo, WebSocketMessage message) {
        //存储消息
        messageTask.addMessage(messagePojo);
        for (WebSocketSession user : users) {
            Integer currentUserId = getUserId(user);
            if (currentUserId != null && currentUserId.equals(messagePojo.getAccepterId())) {
                try {
                    // isOpen()在线就发送
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    log.error(e.getMessage(),e);
                }
            }
        }
    }

}
