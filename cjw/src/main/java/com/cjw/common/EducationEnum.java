package com.cjw.common;

/**
 * 学历
 *
 * @author qucl
 */
public enum EducationEnum {
    /**
     * 专科
     */
    SPECIALTY(0, "专科"),
    /**
     * 本科
     */
    UNDER_GRADUATE(1, "本科"),
    /**
     * 研究生
     */
    POST_GRADUATE(2, "研究生"),
    /**
     * 硕士
     */
    MASTER(3, "硕士"),
    /**
     * 博士
     */
    DOCTOR(4, "博士"),
    /**
     * 博士后
     */
    POST_DOCTOR(5, "博士后"),
    /**
     * 其他
     */
    OTHER(6, "其他");

    private Integer code;
    private String value;

    EducationEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }
}
