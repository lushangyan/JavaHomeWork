package com.dong;

public class ManSayHelloWorld implements ISayHelloWorld{
    @Override
    public String say() {
        System.out.println("Hello world!");
        return "MAN";
    }
}