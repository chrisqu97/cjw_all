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
    SPECIALTY(0),
    /**
     * 本科
     */
    UNDER_GRADUATE(1),
    /**
     * 研究生
     */
    POST_GRADUATE(2),
    /**
     * 硕士
     */
    MASTER(3),
    /**
     * 博士
     */
    DOCTOR(4),
    /**
     * 博士后
     */
    POST_DOCTOR(5),
    /**
     * 其他
     */
    OTHER(6);

    private Integer code;

    EducationEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
