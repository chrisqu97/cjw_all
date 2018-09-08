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

    public String CreateApiUrl(String code){
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

    public static void main(String[] args) {
        String s="cq2g4hwn3reXLtac5bF1JA==";
        String e="8agdn+Un4B97GOJhcR1T/ToQhXCsOExumDx2ERuKSum59Sjz86KT/wLol4Cku5pDUCjmpXe6omzYH80gOSwjJKBM5DtCtxZhAbIqJNhq9u8LwRwbIITekuQZl0ATtI23jwD6eS9GzKoZqi1dNBE028ybgL35unVTIKeickRRziTzejLhgTxxodMS4/nL0FsZy1jGlXmyuFQpooCv1lawYGon4viP5h/QAt4Vuul7CYYyH5SzJHmw9TzODJamKzjMAi31F0xvtVITUrUeTvHV9A6xXhJCnKWoQZ4dIUVtPSV5MOhvSEhBrCJDGqZwWSiYUaAPGU+LHf+Wz+YeHtXHLVxxtItH5Ww9sx445Zl5Sa9YyFshryGMkzzpJy6QVg2Zimuu28dLukQWgyUZUclCs9yxXBIk5+F0jPxV1IYw+9Q9uvH1qH95QGcH7Wghezqw3PWpJ0m0A/6lxfMESdaiWhlYw22sTa/g1+OjjTJH2Vc=";
        String iv="jOyGnalK9mQCcDEJVlYTlA==";
        WxUtiles wxUtiles=new WxUtiles();
        try{
            System.out.println(wxUtiles.decodeBase64(e,s,iv));
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
