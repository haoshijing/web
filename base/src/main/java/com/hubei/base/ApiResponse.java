package com.hubei.base;


import com.hubei.base.constants.RetCode;
import lombok.Data;

/**
 * apiBase
 *
 * @param <T>
 */
@Data
public class ApiResponse<T> {
    private int code;
    private String msg;
    private T data;

    public ApiResponse() {
        this.code = RetCode.OK;
        this.msg = "";
        this.data = null;
    }

    public ApiResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public ApiResponse(T data) {
        this.code = RetCode.OK;
        this.msg = "";
        this.data = data;
    }

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public static ApiResponse responseError(Exception e) {
        return new ApiResponse(RetCode.ERROR, e.getMessage(), null);
    }

}
