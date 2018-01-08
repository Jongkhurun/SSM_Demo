package main.configuration;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * 消息转换器
 * @author 蟑螂
 * @Create 2018-01-08 16:44
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
     */
    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("--------------响应进入到消息转化器-------------------");
        super.writeInternal(obj, outputMessage);
    }
}
