package com.xwolf.eop.test.core;

import com.xwolf.eop.util.RSAUtil;
import org.junit.Test;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-19 10:36
 * @since V1.0.0
 */
public class TestRSA {
     @Test
    public void test() throws Exception{
        // TODO Auto-generated method stub
        HashMap<String, Object> map = RSAUtil.getKeys();
        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");

        //模
        String modulus = publicKey.getModulus().toString();
        //公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        //私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        //明文
        String ming = "哎呀我去";
        //使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = RSAUtil.getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = RSAUtil.getPrivateKey(modulus, private_exponent);
        //加密后的密文
        String mi = RSAUtil.encryptByPublicKey(ming, pubKey);
        System.out.println("密文："+mi);
        //解密后的明文
       String dming = RSAUtil.decryptByPrivateKey(mi, priKey);
        System.out.println("解密："+dming);
    }
}
