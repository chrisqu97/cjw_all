package com.cjw.pojo;

import lombok.Data;

import java.util.List;

/**
 * 工作地点
 */
@Data
public class PlacePojo {
    /**
     * [省，市，区]
     */
    private List<String> value;
}
