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


    public static int generateAccessId(String account){

        if(Strings.isNullOrEmpty(account) ){
            return 0;
        }
        return hash(account);

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


   /**//**
     * 改进的32位FNV算法1
     * @param data 字符串
     * @return int值
     */
    public static int hash(String data)
    {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for(int i=0;i<data.length();i++)
            hash = (hash ^ data.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        hash = Math.abs(hash);
        return hash;
    }
}
