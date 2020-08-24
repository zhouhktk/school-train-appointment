package com.st.exception;


/**
 * @author : zhoufeng
 * @date : 2020/8/17
 */
public class StaffException extends RuntimeException {
    private int code;
    private String msg;

    public StaffException(int code, String msg){
        this.code = code;
        this.msg = msg;
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
