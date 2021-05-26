package com.mvvm.lib.config;


public class MessageEvent {
    public int type;
    public Object src;

    public MessageEvent() {
    }

    public MessageEvent(int type) {
        this.type = type;
    }

    public MessageEvent(int type, Object src) {
        this.type = type;
        this.src = src;
    }

    public static final int MSG_TEST = 0;
}
