package com.spacetrue.tech.captcha.web.interceptor;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shaw on 2017/7/11.
 */
public class SiteAuthInterceptor extends HandlerInterceptorAdapter {

    private final static Logger LOG = Logger.getLogger(SiteAuthInterceptor.class);



    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String username =  (String)request.getSession().getAttribute("UserName");
        if(username == null){
            request.getRequestDispatcher("/captcha/toLogin").forward(request, response);
            return false;
        }else
            return true;
    }


}
