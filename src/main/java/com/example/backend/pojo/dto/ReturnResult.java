package com.example.backend.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 返回信息的包装类
 *
 * @author 黄磊
 * @since 2020/4/29
 */
@Data
public class ReturnResult {
    public static ReturnResult getSuccessReturn(String message) {
        return new ReturnResult(HttpStatus.OK, message, null, null);
    }

    public static ReturnResult getSuccessReturn(Object data) {
        return new ReturnResult(HttpStatus.OK, null, data, null);
    }

    public static ReturnResult getSuccessReturn(String message, Object data) {
        return new ReturnResult(HttpStatus.OK, message, data, null);
    }

    public static ReturnResult getSuccessReturn(Integer status,String message, Object data) {
        return new ReturnResult(status, message, data, null);
    }

    public static ReturnResult getSuccessReturn(HttpStatus status,String message, Object data) {
        return new ReturnResult(status, message, data, null);
    }

    /**
     * 获取错误的返回
     *
     * @param message 返回的错误信息（用户错误提示、错误排查时的提示）
     * @return 装有错误信息的ReturnResult
     */
    public static ReturnResult getFailureReturn(String message) {
        return new ReturnResult(HttpStatus.BAD_REQUEST, message, null, null);
    }

    public static ReturnResult getFailureReturn(String message, String errorMessage) {
        return new ReturnResult(HttpStatus.BAD_REQUEST, message, null, errorMessage);
    }

    public static ReturnResult getFailureReturn(Integer status, String message) {
        return new ReturnResult(status, message, null, null);
    }

    public static ReturnResult getFailureReturn(Integer status, String message, String errorMessage) {
        return new ReturnResult(status, message, null, errorMessage);
    }

    public static ReturnResult getFailureReturn(HttpStatus status, String message) {
        return new ReturnResult(status, message, null, null);
    }

    public static ReturnResult getFailureReturn(HttpStatus status, String message, String errorMessage) {
        return new ReturnResult(status, message, null, errorMessage);
    }

    /**
     * 用于包装参数校验出错时的错误信息
     *
     * @param bindingResult 校验结果
     * @return 装有错误信息的ReturnResult
     */
    public static ReturnResult getFailureReturn(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        bindingResult.getAllErrors().forEach(o -> {
            FieldError error = (FieldError) o;
            if (error.isBindingFailure()) {
                stringBuilder.append(String.format("无法将%s作为%s的值", error.getRejectedValue(), error.getField())).append("\n");
            } else {
                stringBuilder.append(error.getField()).append(" : ").append(error.getDefaultMessage()).append("\n");
            }
        });
        return new ReturnResult(HttpStatus.BAD_REQUEST, stringBuilder.toString(), null, null);
    }

    /**
     * 状态码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer status;
    /**
     * 返回给用户的提示信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    /**
     * 返回数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    /**
     * 返回的错误排查时的提示（主要是给前端、纠错人员看的信息）
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;

    protected ReturnResult() {
    }

    public ReturnResult(HttpStatus status, String message, Object data, String errorMessage) {
        this(status.value(), message, data, errorMessage);
    }


    public ReturnResult(Integer status, String message, Object data, String errorMessage) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.errorMessage = errorMessage;
    }
}
