package com.cjw.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PositionSearchPojo {
    private Integer pageNum;
    private Integer pageSize;
    private List<PositionPojo> positionPojos;
}
