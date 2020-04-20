package com.gupao.xing.jian.common.exception;

/**
 * 自定义异常类
 */
public class MyException extends Exception {
    /**
     * 返回编码
     */
    private int code;
    /**
     * 编码对应信息
     */
    private String msg;

    public MyException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public MyException() {
        this(1001, "接口错误");
    }

    public MyException(String msg) {
        this(1001, msg);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
