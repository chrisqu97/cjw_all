package com.cjw.Pojo;

import lombok.Data;

/**
 * 入参补充参数
 * 用于校验权限
 */
@Data
public class BasePojo {
    private Integer userId;
    private String openId;
}
