package com.cjw;

import com.cjw.utils.AESUtils;
import org.junit.Test;

public class AESTest extends TestBase {
    @Test
    public void fun(){
        String decrypt = AESUtils.encrypt("1&FaMjT1vp0Yr/kzeOWX1lWA==?1537079194272");
        System.out.println(decrypt);
    }
}
