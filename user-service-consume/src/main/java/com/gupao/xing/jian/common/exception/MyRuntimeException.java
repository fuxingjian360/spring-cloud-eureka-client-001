package com.gupao.xing.jian.common.exception;

/**
 * 自定义异常类
 */
public class MyRuntimeException extends RuntimeException {
    /**
     * 返回编码
     */
    private int code;
    /**
     * 编码对应信息
     */
    private String msg;

    public MyRuntimeException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyRuntimeException() {
        this(1001, "接口错误");
    }

    public MyRuntimeException(String msg) {
        this(1001, msg);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
