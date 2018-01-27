package main.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
}
