package main.configuration;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 * @author 懒♂癌
 * @date 2018-01-08 16:32
 */
@Configuration
public class FilterConfiguration implements Filter {
    /**
     * 过滤器初始化
     * @param filterConfig
     * @throws ServletException
     * @author 懒♂癌
     * @date 2018-01-09 16:46
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    /**
     * 过滤器操作
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @author 懒♂癌
     * @date 2018-01-09 16:46
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器操作");
    }

    /**
     * 过滤器销毁
     * @author 懒♂癌
     * @date 2018-01-09 16:47
     */
    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
