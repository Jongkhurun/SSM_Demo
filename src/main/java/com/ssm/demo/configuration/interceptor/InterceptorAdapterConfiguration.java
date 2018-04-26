package com.ssm.demo.configuration.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器适配器
 */
public class InterceptorAdapterConfiguration extends HandlerInterceptorAdapter {
    /**
     * 处理前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("HandlerInterceptorAdapter******************************preHandle******************************");
        return true;
    }

    /**
     * 处理后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptorAdapter******************************postHandle******************************");
        //super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 完成后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("HandlerInterceptorAdapter******************************afterCompletion******************************");
        //super.afterCompletion(request, response, handler, ex);
    }
}
