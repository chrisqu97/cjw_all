package com.cjw.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;

@Component
public class WxUtiles {
    @Value("${wx.api}")
    private String api;

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.secret}")
    private String secret;


    /**
     * 设置header
     * @param response
     * @return
     */
    public static HttpServletResponse setHeader(HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        return response;
    }

    public String getApiUrl(String code){
        return api+"?appid="+appId+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
    }

    public JSONObject decodeBase64(String encryptedData,String sessionKey,String iv)throws Exception{
        byte[] dataByte= Base64.decodeBase64(encryptedData);
        byte[] keyByte=Base64.decodeBase64(sessionKey);
        byte[] ivByte=Base64.decodeBase64(iv);

        try {
            //密钥不足16位则补足
            int base=16;
            if(keyByte.length%base==0) {
                int groups=keyByte.length/base+(keyByte.length%base!=0?1:0);
                byte[] temp=new byte[groups*base];
                Arrays.fill(temp, (byte)0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte=temp;
            }
            //初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher= Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec=new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters paramenters=AlgorithmParameters.getInstance("AES");
            paramenters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, paramenters);
            byte[] resultByte=cipher.doFinal(dataByte);
            if(null!=resultByte&&resultByte.length>0) {
                String result=new String(resultByte, StandardCharsets.UTF_8);
                return JSON.parseObject(result);
            }
        }catch (Exception e) {
            throw new Exception("数据解密失败");
        }
        return null;
        
    }

}
