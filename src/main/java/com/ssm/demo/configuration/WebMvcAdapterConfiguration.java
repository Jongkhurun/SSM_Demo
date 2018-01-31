package com.ssm.demo.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 适配器
 * @author 懒♂癌
 * @date 2017-09-30 19:27
 */
@Configuration
public class WebMvcAdapterConfiguration extends WebMvcConfigurerAdapter {
    /**
     * 扩展消息转换器链表--JSON
     * @param converters
     * @author 懒♂癌
     * @date 2018-01-09 16:50
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        System.out.println("--------------扩展消息转换器链表-------------------");

        /**定义一个转换消息的对象*/
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        /**初始化转换器配置，添加fastjson的配置信息 比如 ：是否要格式化返回的json数据*/
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        //设置UTF-8 编码格式
        fastJsonConfig.setCharset(Charset.forName("utf-8"));
        //结果是否格式化,默认为false
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //List字段如果为null,输出为[],而非null
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullListAsEmpty);
        /**在转换器中添加配置信息*/
        fastConverter.setFastJsonConfig(fastJsonConfig);

        /**将转换器添加到converters中*/
        converters.add(fastConverter);
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

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("configureDefaultServletHandling");
        configurer.enable();
    }

    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
}
