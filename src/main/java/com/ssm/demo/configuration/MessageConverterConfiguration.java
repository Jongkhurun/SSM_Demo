package com.ssm.demo.configuration;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * 消息转换器
 * @author 懒♂癌
 * @date 2018-01-08 16:44
 */
@Configuration
public class MessageConverterConfiguration extends FastJsonHttpMessageConverter {
    /**
     * 请求进入到消息转化器
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     * @author 懒♂癌
     * @date 2018-01-09 16:49
     */
    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        //fastJson的版本影响是否可以获取
        System.out.println("--------------请求进入到消息转化器-------------------");
        return super.readInternal(clazz, inputMessage);
    }

    /**
     * 响应进入到消息转化器
     * @param obj
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     * @author 懒♂癌
     * @date 2018-01-09 16:50
     */
    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("--------------响应进入到消息转化器-------------------");
        super.writeInternal(obj, outputMessage);
    }
}
