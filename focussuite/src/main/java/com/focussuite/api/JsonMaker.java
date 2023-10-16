package com.focussuite.api;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;

import com.focussuite.Logger;

import java.lang.reflect.Array;





public class JsonMaker<Obj> {
    private Obj obj;
    private ArrayList<Field> fields;

    public static final byte TEST = 0;
    public static final byte PROD = 1;

    public JsonMaker(Obj obj){
        this.obj = obj;
        fields = this.getFields();
    }


    private ArrayList<Field> getFields(){
        ArrayList<Field> fds = new ArrayList<Field>();
        Field[] temp = obj.getClass().getDeclaredFields();
        Arrays.stream(temp).forEach(f -> {
            fds.add(f);
        });
        return fds;
    }

    public ArrayList<Token> parseIntoTokens(){
        ArrayList<Token> tokens = new ArrayList<Token>();

        fields.forEach(f->{
            Token token = new Token();
            
            if(f.getType().isAssignableFrom(Number.class)){
                token.setTokenType(Token.NUMBER);
            } else if(f.getType().isAssignableFrom(String.class)){
                token.setTokenType(Token.STRING);
            } else if(f.getType().isAssignableFrom(Boolean.class)){
                token.setTokenType(Token.BOOLEAN);
            } else if(f.getType().isAssignableFrom(Array.class) || f.getType().isAssignableFrom(AbstractCollection.class)){
                token.setTokenType(Token.ARRAY);
            } else if(f.getType().isAssignableFrom(Object.class)){
                token.setTokenType(Token.OBJECT);
            }

            token.setToken(f.getName());
            try{
            token.setValue(f.get(obj));
            } catch (IllegalAccessException e){
                Logger.log(e);
            }
            tokens.add(token);
        });

        return tokens;
    }

    public File createJsonFile(byte dir){
        String fileName = ((dir == TEST) ? "test/" : "prod/" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + "objects.json").replace(' ', '-').replace('.', '-');
        File f = new File(fileName);

        return f;
    }

    public void makeJson(File f){

    }
}
