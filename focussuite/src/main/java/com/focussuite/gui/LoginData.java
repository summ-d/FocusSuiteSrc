package com.focussuite.gui;

import java.util.ArrayList;

public class LoginData{
    public static byte ADMIN = 0;
    public static byte TEACHER = 1;
    public static byte PARENT = 2;
    public static byte STUDENT = 3;

    private String un;
    private String pw;

    private byte accntType;

    private ArrayList<LoginData> connectedAccts;

    public LoginData(){
        connectedAccts = new ArrayList<LoginData>();
    }
    
    public void setUsername(String un){
        this.un = un;
    }

    public void setPassword(String pw){
        this.pw = pw;
    }

    public String getUsername(){
        return this.un;
    }

    public String getPassword(){
        return this.pw;
    }

    public void addConnectedAcct(LoginData d){
        connectedAccts.add(d);
    }

    public void setAccountType(byte accntType){
        this.accntType = accntType;
    }

    public byte getAccountType(){
        return this.accntType;
    }

    
}
