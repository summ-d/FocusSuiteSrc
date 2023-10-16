package com.focussuite.api;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;




public class JsonMaker<Obj> {
    private Obj obj;
    private ArrayList<Method> methods;
    private ArrayList<Field> fields;
    private ArrayList<Token> tokens;

    public JsonMaker(Obj obj){
        this.obj = obj;
        fields = this.getFields();
        methods = this.getMethods();
    }

    private ArrayList<Method> getMethods(){
        ArrayList<Method> met = new ArrayList<Method>();
        Method[] temp = obj.getClass().getDeclaredMethods();
        Arrays.stream(temp).forEach(t->{
            met.add(t);
        });
        return met;
    }

    private ArrayList<Field> getFields(){
        ArrayList<Field> fds = new ArrayList<Field>();
        Field[] temp = obj.getClass().getDeclaredFields();
        Arrays.stream(temp).forEach(f -> {
            fds.add(f);
        });
        return fds;
    }

    public void parse(){
        tokens = new ArrayList<Token>();
        fields.forEach(f->{});
    }

}
