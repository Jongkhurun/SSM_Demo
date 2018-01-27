package main.configuration;

import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听器
 * @author 懒♂癌
 * @date 2018-01-08 16:30
 */
@Configuration
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
