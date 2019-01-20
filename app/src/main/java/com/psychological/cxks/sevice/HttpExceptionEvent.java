package com.psychological.cxks.sevice;

public class HttpExceptionEvent {
    public HttpExceptionEvent(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code;
    public String msg;
}
