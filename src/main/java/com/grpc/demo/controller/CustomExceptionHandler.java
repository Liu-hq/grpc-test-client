package com.grpc.demo.controller;

import com.grpc.demo.utils.ReturnMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * Description: 自定义异常 (监控所有 RestController 所发生的异常信息)
 * Author: wzl
 * Version: 1.0
 * Create Date Time: 2018/9/20 10:21.
 *
 * @see
 */
@ControllerAdvice
@RestController
public class CustomExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> handleException(Exception e) {
        Map<String, Object> retMap = ReturnMessage.jsonData(false, e.getMessage());
        return retMap;
    }
}
