package com.cjw.pojo;

import lombok.Data;

@Data
public class MessagePojo {
    private Integer messageId;
    private String content;
    private Integer userId;
    private Integer accepterId;
    private Integer positionId;
    private Long createTime;
    private Integer ifRead;
}
