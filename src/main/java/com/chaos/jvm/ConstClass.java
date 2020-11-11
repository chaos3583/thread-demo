package com.chaos.jvm;

/**
 * @program: thread-demo
 * * @description:
 * * @author: liaopeng
 * * @create: 2020-08-14 15:37
 **/
public class ConstClass {
    static {
        System.out.println("init constClass");
    }
    public static final String HELLO ="HELLO";
}
