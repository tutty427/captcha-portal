package com.spacetrue.tech.captcha.service.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import com.google.common.base.Strings;

/**
 * Created by Shaw on 2017/7/9.
 */
public class SecurityUtils {

    private final static String SECURITY_PREFIX = "space";
    private final static String SECURITY_SUFFIX = "true";


    public static String generateAccessId(String account,long createDate){

        if(Strings.isNullOrEmpty(account) || createDate == 0){
            return null;
        }

        String source = new StringBuilder(SECURITY_PREFIX).append(account).append(createDate).append(SECURITY_SUFFIX).toString();
        return base64enc(sha256(source));

    }



    public static String MD5(String source){
        return  DigestUtils.md5Hex(source);
    }

    public static String sha256(String source){
        return  DigestUtils.sha256Hex(source);
    }


    public static String base64enc(String plainText){
        byte[] b = plainText.getBytes();
        Base64 base64 = new Base64();
        b = base64.encode(b);
        String s = new String(b);
        return s;
    }


    public static String base64dec(String encodeStr){
        byte[] b = encodeStr.getBytes();
        Base64 base64 = new Base64();
        b = base64.decode(b);
        String s = new String(b);
        return s;
    }
}
