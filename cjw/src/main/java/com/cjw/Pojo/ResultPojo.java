package com.cjw.pojo;

import lombok.Data;

@Data
public class ResultPojo {
    private Boolean success = false;
    private String message;
    private Object data;
}
