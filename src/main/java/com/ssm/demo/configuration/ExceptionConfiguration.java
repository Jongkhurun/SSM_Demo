package com.ssm.demo.configuration;

import com.alibaba.fastjson.JSONObject;
import com.ssm.demo.utils.common.RD;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


/**
 * 异常拦截
 *
 * @author 懒♂癌
 * @date 2018-01-27 15:22
 */
@ControllerAdvice
public class ExceptionConfiguration extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("--------------进入异常拦截器-------------------");

        ex.printStackTrace();
        List<ObjectError> list = ex.getAllErrors();

        if (list.size() > 0) {
            return handleExceptionInternal(ex, RD.error(list.get(0).getDefaultMessage()), headers, status, request);
        }

        return handleExceptionInternal(ex, RD.error(ex.getMessage()), headers, status, request);
    }
}
