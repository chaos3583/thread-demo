package com.chaos.jvm;

/**
 * @program: thread-demo
 * * @description:被动引用示例1：通过子类引用父类的静态字段不会导致父类初始化
 * * @author: liaopeng
 * * @create: 2020-08-14 15:16
 **/
public class SubClass  extends SupperClass{
    static {
        System.out.println("subClass init");
    }
}

class SupperClass{
    static {
        System.out.println("supperClass init");
    }
    public static int value =123;

}
