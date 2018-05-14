package com.ssm.demo.configuration.exception;

import com.ssm.demo.utils.RD;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * 全局异常拦截
 */
@ResponseBody
@ControllerAdvice
public class GlobalExceptionConfiguration {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionConfiguration.class);

    /**
     * 400
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public RD handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("handleMissingServletRequestParameterException -- 缺少请求参数", e);
        System.out.println("handleMissingServletRequestParameterException -- 缺少请求参数");
        return RD.exception("缺少请求参数");
    }

    /**
     * 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public RD handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("handleHttpMessageNotReadableException -- 参数解析失败", e);
        System.out.println("handleHttpMessageNotReadableException -- 参数解析失败");
        return RD.exception("参数解析失败");
    }

    /**
     * 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RD handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("handleMethodArgumentNotValidException -- 参数验证失败", e);
        System.out.println("handleMethodArgumentNotValidException -- 参数验证失败");
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return RD.exception(message);
    }

    /**
     * 400
     * 模型参数验证
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public RD handleBindException(BindException e) {
        logger.error("handleBindException -- 参数绑定失败", e);
        System.out.println("handleBindException -- 参数绑定失败");
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return RD.exception(message);
    }

    /**
     * 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public RD handleServiceException(ConstraintViolationException e) {
        logger.error("handleServiceException -- 参数验证失败", e);
        System.out.println("handleBindException -- 参数绑定失败");
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return RD.exception("parameter:" + message);
    }

    /**
     * 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public RD handleValidationException(ValidationException e) {
        logger.error("handleValidationException -- 参数验证失败", e);
        System.out.println("handleBindException -- 参数绑定失败");
        return RD.exception("参数验证失败" + e.getMessage());
    }

    /**
     * 405
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RD handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("handleHttpRequestMethodNotSupportedException -- 不支持当前请求方法", e);
        System.out.println("handleHttpRequestMethodNotSupportedException -- 不支持当前请求方法");
        return RD.exception("不支持当前请求方法");
    }

    /**
     * 415
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public RD handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("handleHttpMediaTypeNotSupportedException -- 不支持当前媒体类型", e);
        System.out.println("handleHttpMediaTypeNotSupportedException -- 不支持当前媒体类型");
        return RD.exception("不支持当前媒体类型");
    }

    /**
     * 500
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ServiceException.class)
    public RD handleServiceException(ServiceException e) {
        logger.error("handleServiceException -- 业务逻辑异常", e);
        System.out.println("handleServiceException -- 业务逻辑异常");
        return RD.exception("业务逻辑异常：" + e.getMessage());
    }

    /**
     * 500
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public RD handleException(Exception e) {
        logger.error("handleException -- 通用异常", e);
        System.out.println("handleException -- 通用异常");
        return RD.exception("通用异常：" + e.getMessage());
    }

    /**
     * 操作数据库出现异常:名称重复，外键关联
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public RD handleException(DataIntegrityViolationException e) {
        logger.error("handleException -- 操作数据库出现异常:", e);
        System.out.println("handleException -- 操作数据库出现异常:");
        return RD.exception("操作数据库出现异常：字段重复、有外键关联等");
    }
}
