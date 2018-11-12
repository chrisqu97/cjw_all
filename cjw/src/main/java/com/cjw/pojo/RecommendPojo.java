package com.cjw.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author qucl
 * @date 2018/11/12 17:57
 */
@Data
public class RecommendPojo {
    private List<Integer> positionIds;
    private Integer userId;
    private Integer size;
}
