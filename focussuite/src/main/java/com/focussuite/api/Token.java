package com.focussuite.api;

public class Token {
    private String token;
    private byte type;

    public static final byte NUMBER = 0;
    public static final byte OBJECT = 1;
    public static final byte BOOLEAN = 2;
    public static final byte STRING = 3;
    public static final byte ARRAY = 4;

    public Token(String token, Byte type){
        this.token = token;
        this.type = type;
    }

    public Token(){
        this(null, null);
    }

    public String getToken(){
        return this.token;
    }

    public byte getTokenType(){
        return this.type;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setTokenType(byte type){
        this.type = type;
    }
}
