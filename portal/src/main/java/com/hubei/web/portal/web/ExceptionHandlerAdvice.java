package com.hubei.web.portal.web;


import com.hubei.base.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haoshijing
 * @version 2018年01月10日 10:16
 **/
@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {
    @ResponseBody
    @ExceptionHandler
    public ApiResponse processException(Exception e){
        log.error("{}",e);
        ApiResponse apiResponse = ApiResponse.responseError(e);
        return apiResponse;
    }

}

