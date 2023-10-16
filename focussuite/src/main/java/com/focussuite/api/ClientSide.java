package com.focussuite.api;

import java.io.File;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.focussuite.Logger;

public class ClientSide extends Socket {
    private DataOutputStream out;
    private DataInputStream in;

    public static final byte TEST = 0;
    public static final byte PROD = 1;

    public ClientSide(String addr, int port) throws IOException, UnknownHostException{
        super(addr, port);
    }


    public void send(File f){
        try{
            in = new DataInputStream(new FileInputStream(f));
            out = new DataOutputStream(this.getOutputStream());
            out.writeUTF(in.readUTF());
        } catch (Exception e){
            Logger.log(e);
        }
    }

    public File recieve(byte loc){
        String fileName = ((loc == TEST) ? "test/" : "prod/" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + "objects.json").replace(' ', '-').replace('.', '-');
        File f = new File(fileName);
        try{
            in = new DataInputStream(this.getInputStream());
            out = new DataOutputStream(new FileOutputStream(f));
            out.writeUTF(in.readUTF());
        } catch( Exception e){
            Logger.log(e);
        }
        return f;
    }

}
