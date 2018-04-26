package com.ssm.demo.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ssm.demo.configuration.interceptor.InterceptorAdapterConfiguration;
import com.ssm.demo.configuration.interceptor.InterceptorConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 适配器
 * @author 懒♂癌
 * @date 2017-09-30 19:27
 */
@ResponseBody
@Configuration
@SpringBootApplication
public class WebMvcAdapterConfiguration implements WebMvcConfigurer {
    /**
     * 1.配置内容协商
     * @param contentNegotiationConfigurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {
        System.out.println("******************************configureContentNegotiation******************************配置内容协商");
    }

    /**
     * 2.配置消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.out.println("******************************configureMessageConverters******************************配置消息转换器");

//        /**定义一个转换消息的对象*/
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//
//        /**初始化转换器配置，添加fastjson的配置信息 比如 ：是否要格式化返回的json数据*/
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//
//        //设置UTF-8 编码格式
//        fastJsonConfig.setCharset(Charset.forName("utf-8"));
//        //结果是否格式化,默认为false
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        //List字段如果为null,输出为[],而非null
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty);
//        /**在转换器中添加配置信息*/
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//
//        /**将转换器添加到converters中*/
//        converters.add(fastConverter);
    }

    /**
     * 3.扩展消息转换器
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.out.println("******************************extendMessageConverters******************************扩展消息转换器");
        //定义一个FastJson转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //添加fastjson的配置信息 比如 ：是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        //开启格式化
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //设置字符编码
        fastJsonConfig.setCharset(Charset.forName("utf-8"));
        //List字段如果为null,输出为[],而非null
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty);
        fastConverter.setFastJsonConfig(fastJsonConfig);

        List<MediaType> jsonMediaTypes = new ArrayList<>();
        jsonMediaTypes.add(MediaType.APPLICATION_JSON);
        jsonMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(jsonMediaTypes);
        //将FastJson转换器添加到converters中
        converters.add(fastConverter);

        MappingJackson2XmlHttpMessageConverter xmlMessageConverter = new MappingJackson2XmlHttpMessageConverter();
        xmlMessageConverter.setObjectMapper(new XmlMapper());
        xmlMessageConverter.setDefaultCharset(Charset.forName("utf-8"));
        List<MediaType> xmlMediaTypes = new ArrayList<>();
        xmlMediaTypes.add(MediaType.APPLICATION_XML);
        xmlMediaTypes.add(MediaType.TEXT_XML);
        xmlMessageConverter.setSupportedMediaTypes(xmlMediaTypes);

        //将转换器添加到converters中
        converters.add(xmlMessageConverter);
    }

    /**
     * 4.添加格式器
     * @param formatterRegistry
     */
    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        System.out.println("******************************addFormatters******************************添加格式器");
    }

    /**
     * 5.获取验证器
     * @return
     */
    @Override
    public Validator getValidator() {
        System.out.println("******************************getValidator******************************获取验证器");
        return null;
    }

    /**
     * 6.消息代码解析器
     * @return
     */
    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        System.out.println("******************************MessageCodesResolver******************************消息代码解析器");
        return null;
    }

    /**
     * 7.添加参数解析器
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        System.out.println("******************************addArgumentResolvers******************************添加参数解析器");
    }

    /**
     * 8.添加处理程序返回值
     * @param handlers
     */
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        System.out.println("******************************addReturnValueHandlers******************************添加处理程序返回值");
    }

    /**
     * 9.配置异步支持
     * @param asyncSupportConfigurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {
        System.out.println("******************************configureAsyncSupport******************************配置异步支持");
    }

    /**
     * 10.添加拦截器
     * @param interceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        System.out.println("******************************addInterceptors******************************添加拦截器");
        interceptorRegistry.addInterceptor(new InterceptorAdapterConfiguration()).excludePathPatterns("/sys/**");
        interceptorRegistry.addInterceptor(new InterceptorConfiguration()).excludePathPatterns("/sys/**");
    }

    /**
     * 11.配置路径匹配
     * @param pathMatchConfigurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
        System.out.println("******************************configurePathMatch******************************配置路径匹配");
    }

    /**
     * 12.添加跨域映射
     * @param corsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        System.out.println("******************************addCorsMappings******************************添加跨域映射");
    }

    /**
     * 13.添加视图控制器
     * @param viewControllerRegistry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        System.out.println("******************************addViewControllers******************************添加视图控制器");
    }

    /**
     * 14.添加资源处理程序
     * @param resourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        System.out.println("******************************addResourceHandlers******************************添加资源处理程序");
    }

    /**
     * 15.配置默认Servlet处理
     * @param defaultServletHandlerConfigurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {
        System.out.println("******************************configureDefaultServletHandling******************************配置默认Servlet处理");
    }

    /**
     * 16.配置处理程序异常解析器
     * @param resolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        System.out.println("******************************configureHandlerExceptionResolvers******************************配置处理程序异常解析器");
    }

    /**
     * 17.扩展处理程序异常解析器
     * @param resolvers
     */
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        System.out.println("******************************extendHandlerExceptionResolvers******************************扩展处理程序异常解析器");
    }

    /**
     * 18.配置视图解析器
     * @param viewResolverRegistry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        System.out.println("******************************configureViewResolvers******************************配置视图解析器");
    }

    /**
     * 设置web视图模板
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        System.out.println("--------------设置web视图模板-------------------");

        System.out.println("viewResolver");
        FreeMarkerViewResolver v = new FreeMarkerViewResolver();
        v.setPrefix("");
        v.setSuffix(".ftl");
        v.setCache(false);
        v.setContentType("text/html;charset=UTF-8");
        v.setExposeSpringMacroHelpers(true);
        return v;
    }

    /**
     * 设置视图存放目录
     * @return
     */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        System.out.println("--------------设置视图存放目录-------------------");

        System.out.println("freeMarkerConfigurer");
        FreeMarkerConfigurer f = new FreeMarkerConfigurer();

        f.setTemplateLoaderPath("WEB-INF/views/");
        f.setDefaultEncoding("UTF-8");
        return f;
    }
}
