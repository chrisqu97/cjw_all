package com.cjw.pojo;

import lombok.Data;

@Data
public class LoginPojo {
    private String code;
    private String encryptedData;
    private String iv;
}
