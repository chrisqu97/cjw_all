package com.cjw.exception;

import lombok.Data;

@Data
public class PermissionException extends Exception {
    private String message;

    public PermissionException(String message) {
        this.setMessage(message);
    }
}
