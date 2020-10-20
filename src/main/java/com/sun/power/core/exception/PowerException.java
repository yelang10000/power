package com.sun.power.core.exception;

import com.sun.power.core.utils.MessageUtils;
import lombok.Data;

/**
 * @Author 贾涛
 * @Date 2020/10/15 13:59
 * @Version 1.0
 */
@Data
public class PowerException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;


    public PowerException(int code) {
        this.code = code;
        this.msg = MessageUtils.getMessage(code);
    }

    public PowerException(int code, String... params) {
        this.code = code;
        this.msg = MessageUtils.getMessage(code, params);
    }

    public PowerException(int code, Throwable e) {
        super(e);
        this.code = code;
        this.msg = MessageUtils.getMessage(code);
    }

    public PowerException(int code, Throwable e, String... params) {
        super(e);
        this.code = code;
        this.msg = MessageUtils.getMessage(code, params);
    }

    public PowerException(String msg) {
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
    }

    public PowerException(String msg, Throwable e) {
        super(msg, e);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
    }

}
