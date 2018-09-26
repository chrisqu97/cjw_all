package com.cjw;

import com.cjw.utils.AESUtils;
import org.junit.Test;

public class AESTest extends TestBase {
    @Test
    public void fun(){
        String encrypt = AESUtils.encrypt("1&FaMjT1vp0Yr/kzeOWX1lWA==?1537079194272");
        System.out.println(encrypt);
        String decrypt = AESUtils.decrypt("VTERSv7f1ANeWlG5/iViO2QEvNQlVt4P2TTvuQNL+7xf0f9sgs/xtSnZ24yZCjSL");
        System.out.println(decrypt);
    }
}
