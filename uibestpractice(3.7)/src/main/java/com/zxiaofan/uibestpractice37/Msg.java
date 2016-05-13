package com.zxiaofan.uibestpractice37;

/**
 * Created by yunhai on 2016/5/13.
 */
public class Msg {
    public static final int TYPE_RECEIVED = 0;//这是一条收到的消息
    public static final int TYPE_SEND = 1;//发出的消息
    private String content;
    private int type; //type 表示消息的类型

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
