package com.cjw.auth;

import lombok.Data;

@Data
public class AuthUser {
    private Integer userId;
    private String sessionKey;
}
