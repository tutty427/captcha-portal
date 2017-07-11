package com.spacetrue.tech.captcha.web.vo;

/**
 * Created by Shaw on 2017/7/11.
 */
public abstract class BaseUserCenterVO {

    private String userName;
    private String timeRemain;
    private String streamRemain;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimeRemain() {
        return timeRemain;
    }

    public void setTimeRemain(String timeRemain) {
        this.timeRemain = timeRemain;
    }

    public String getStreamRemain() {
        return streamRemain;
    }

    public void setStreamRemain(String streamRemain) {
        this.streamRemain = streamRemain;
    }
}
