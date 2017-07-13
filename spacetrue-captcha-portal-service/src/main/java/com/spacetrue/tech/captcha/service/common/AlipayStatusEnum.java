package com.spacetrue.tech.captcha.service.common;

import com.google.common.base.Strings;

/**
 * Created by Shaw on 2017/7/13.
 */
public enum AlipayStatusEnum {
    WAIT_BUYER_PAY(0),

    TRADE_SUCCESS(1),
    TRADE_FINISHED(2),
    TRADE_CLOSED(9),
    ;
    private int code;
    AlipayStatusEnum(int code){
        this.code = code;
    }

    public int code(){
        return this.code;
    }


    public static int getCodeByName(String name){

        int result = -1;

        if(Strings.isNullOrEmpty(name)){
            return result;
        }

        for(AlipayStatusEnum statusEnum :AlipayStatusEnum.values()){

            if(name.equalsIgnoreCase(statusEnum.name())){
                result =  statusEnum.code();
                break;
            }
        }

        return result;
    }
}
