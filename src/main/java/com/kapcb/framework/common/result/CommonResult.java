package com.kapcb.framework.common.result;

import com.kapcb.framework.common.constants.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * <a>Title: CommonResult </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CommonResult <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/8 21:06
 */
@Data
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = 2701038566585237782L;

    private int code;

    private String msg;

    private T date;

    private Date timeStamp = Calendar.getInstance().getTime();

    protected CommonResult() {
    }

    protected CommonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.date = data;
    }

    protected CommonResult(IResultCode resultCode) {
        this.code = resultCode.code();
        this.msg = resultCode.msg();
        this.date = null;
    }

    protected CommonResult(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.msg = resultCode.msg();
        this.date = data;
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult<T>(ResultCode.SUCCESS);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS, data);
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.code(), message, data);
    }

    public static <T> CommonResult<T> failed() {
        return new CommonResult<T>(ResultCode.FAILED);
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.code(), message, null);
    }

    public static <T> CommonResult<T> failed(String message, int code) {
        return new CommonResult<T>(code, message, null);
    }

    public static <T> CommonResult<T> failed(IResultCode errorCode) {
        return new CommonResult<T>(errorCode);
    }

    public static <T> CommonResult<T> failed(Throwable throwable) {
        return new CommonResult<T>(ResultCode.FAILED.code(), throwable.getMessage(), null);
    }

    public static <T> CommonResult<T> failed(IResultCode errorCode, Throwable throwable) {
        return new CommonResult<T>(errorCode.code(), throwable.getMessage(), null);
    }

    public static <T> CommonResult<T> failed(IResultCode errorCode, Throwable throwable, T data) {
        return new CommonResult<T>(errorCode.code(), throwable.getMessage(), data);
    }

    public static <T> CommonResult<T> validateFailed() {
        return new CommonResult<T>(ResultCode.VALIDATE_PARAM_FAIL);
    }

    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_PARAM_FAIL.code(), message, null);
    }

    public static <T> CommonResult<T> unauthorized() {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED);
    }

    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED, data);
    }

    public static <T> CommonResult<T> unauthorized(String msg) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.code(), msg, null);
    }

    public static <T> CommonResult<T> forbidden() {
        return new CommonResult<T>(ResultCode.FORBIDDEN);
    }

    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN, data);
    }

    public static <T> CommonResult<T> authenticationFailure() {
        return new CommonResult<T>(ResultCode.LOGIN_FAIL, null);
    }

    public static <T> CommonResult<T> authenticationFailure(T data) {
        return new CommonResult<T>(ResultCode.LOGIN_FAIL, data);
    }

    public static <T> CommonResult<T> authenticationFailure(String message) {
        return new CommonResult<T>(ResultCode.LOGIN_FAIL.code(), message, null);
    }
}
