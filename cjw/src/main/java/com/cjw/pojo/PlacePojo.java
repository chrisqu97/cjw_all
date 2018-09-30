package com.cjw.pojo;

import lombok.Data;

/**
 * 工作地点(暂时不使用)
 */
@Data
@Deprecated
public class PlacePojo {
    private String country;
    private String province;
    private String city;
    private String area;
}
