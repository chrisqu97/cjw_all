package com.cjw.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MessageSearchPojo {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Integer totalCount;
    private List<MessagePojo> messagePojos;
    private Integer userId;
    private Integer accepterId;
    private Integer positionId;
}
