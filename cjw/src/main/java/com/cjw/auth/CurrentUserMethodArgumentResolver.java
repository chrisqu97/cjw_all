package com.cjw.auth;

import com.cjw.pojo.SessionKeyPojo;
import com.cjw.utils.WxUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private WxUtiles wxUtiles;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(AuthUser.class)
                && methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest request, WebDataBinderFactory webDataBinderFactory) throws Exception {
        try {
            String sessionKey = request.getHeader("session_key");
            SessionKeyPojo sessionKeyPojo = wxUtiles.decodeSessionKey(sessionKey);
            AuthUser user = new AuthUser();
            user.setUserId(sessionKeyPojo.getUserId());
            user.setSessionKey(sessionKeyPojo.getSessionKey());
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
