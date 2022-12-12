package com.example.backend.global;

import com.example.backend.pojo.dto.ReturnResult;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @author zhoutianlan
 * @since 2022/09/24
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    /**
     * JSR303 校验异常
     */
    @ExceptionHandler(value = {BindException.class})
    public ReturnResult handleMethodArgumentTypeMismatchException(BindException e) {
        return ReturnResult.getFailureReturn(e.getBindingResult());
    }

    /**
     * Jackson参数绑定异常
     */
    @ExceptionHandler(InvalidFormatException.class)
    public ReturnResult parameterTypeException(InvalidFormatException e) {
        return ReturnResult.getFailureReturn("参数[" + e.getValue() + "]错误", e.getMessage());
    }

    /**
     * Jackson参数绑定异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ReturnResult handleBeansException(MethodArgumentTypeMismatchException e) {
        return ReturnResult.getFailureReturn("参数[ " + e.getName() + " ]错误", e.getMessage());
    }

    /**
     * 用户登录异常
     */
//    @ExceptionHandler(NotLoginException.class)
//    public ReturnResult handleNotLoginException(NotLoginException e) {
//        return ReturnResult.getFailureReturn("您未登录，请先进行登录");
//    }
}
