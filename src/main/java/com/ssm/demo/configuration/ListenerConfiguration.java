package com.ssm.demo.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器
 * @author 懒♂癌
 * @date 2018-01-08 16:30
 */
//@Configuration
@WebListener
public class ListenerConfiguration implements ServletContextListener{
    /**
     * 监听器初始化
     * @param servletContextEvent
     * @author 懒♂癌
     * @date 2018-01-09 16:49
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听器初始化");
    }

    /**
     * 监听器销毁
     * @param servletContextEvent
     * @author 懒♂癌
     * @date 2018-01-09 16:49
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("监听器销毁");
    }
}
