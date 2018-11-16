package com.cjw.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PositionSearchPojo {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalCount;
    private Integer totalPage;
    private List<PositionPojo> positionPojos;
    private Integer companyId;
    private String positionName;
    private List<Integer> positionIds;
    private Integer positionType;
}
