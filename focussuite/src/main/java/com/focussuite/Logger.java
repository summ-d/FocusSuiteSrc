package com.focussuite;

import java.util.ArrayList;

public final class Logger {
    private static ArrayList<Exception> exe;

    private Logger(){
        exe = new ArrayList<Exception>();
    }

    public static void log(Exception e){
        exe.add(e);
    }

    public static void print(){
        exe.forEach(e -> {
            System.out.println(e.toString());
        });
    }
}
