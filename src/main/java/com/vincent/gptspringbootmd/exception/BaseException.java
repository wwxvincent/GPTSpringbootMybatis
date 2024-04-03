package com.vincent.gptspringbootmd.exception;

import com.vincent.gptspringbootmd.enums.IResponseEnum;

public abstract class BaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;


    public BaseException(int code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(IResponseEnum exEnum){
        super(exEnum.getMessage());
        this.code = exEnum.getCode();
        this.msg = exEnum.getMessage();
    }

    public BaseException(int code,String msg,Throwable cause){
        super(msg,cause);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(IResponseEnum exEnum,Throwable cause){
        super(exEnum.getMessage(),cause);
        this.code = exEnum.getCode();
        this.msg = exEnum.getMessage();
    }

    public BaseException(int code,String msg,Throwable cause,
                         boolean enableSuppression,
                         boolean writableStackTrace){
        super(msg,cause,enableSuppression,writableStackTrace);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(IResponseEnum exEnum,Throwable cause,
                         boolean enableSuppression,
                         boolean writableStackTrace){
        super(exEnum.getMessage(),cause,enableSuppression,writableStackTrace);
        this.code = exEnum.getCode();
        this.msg = exEnum.getMessage();
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
