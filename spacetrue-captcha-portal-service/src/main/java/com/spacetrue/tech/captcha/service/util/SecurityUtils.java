package com.spacetrue.tech.captcha.service.util;

import com.google.common.base.Strings;
import org.apache.commons.codec.digest.DigestUtils;

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
        return sha256(source);

    }



    public static String MD5(String source){
        return  DigestUtils.md5Hex(source);
    }

    public static String sha256(String source){
        return  DigestUtils.sha256Hex(source);
    }
}
