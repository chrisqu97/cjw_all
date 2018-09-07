package com.cjw.common;

import lombok.Data;

/**
 * 权限校验异常
 */
@Data
public class PermissionException extends Exception {
    private String message;

    public PermissionException(String message){
        this.setMessage(message);
    }

}
