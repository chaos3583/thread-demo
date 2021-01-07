package com.chaos.jvm.dispatch;

import java.io.Serializable;
import java.sql.SQLOutput;

/**
 * @author liaopeng
 * @title: StaticDispatch2
 * @projectName myProjects
 * @description: 执行优先级从高到低
 * @date 2020/12/185:35 下午
 */
public class StaticDispatch2 {

    /**
     *首选参数类型为char的
     * @param arg
     */
//    public void sayHello(char arg){
//        System.out.println("char："+arg);
//    }

    /**
     * char类型的注释掉后调用int
     * 'a'进行类型转换就是数字97
     * @param arg
     */
//    public void sayHello(int arg){
//        System.out.println("int："+arg);
//    }

    /**
     * int类型注释掉后调用long
     * int可以继续向上转换为long类型
     * @param arg
     */
//    public void sayHello(long arg){
//        System.out.println("long："+arg);
//    }

    /**
     * long类型注释掉后调用Character
     * 此时发生一次自动装箱，'a'转为它的封装类型Character
     * @param arg
     */
//    public void sayHello(Character arg){
//        System.out.println("Character："+arg);
//    }

    /**
     * Character类型注释掉后调用Serializable
     * 因为Character实现了Serializable接口，所以转型成了实现的接口类型
     * @param arg
     */
//    public void sayHello(Serializable arg){
//        System.out.println("Serializable："+arg);
//    }

    /**
     * Serializable类型注释掉后调用Object
     *此时char转成父类了，如果有多个父类，会逐级往上找，越往上优先级越低
     * @param arg
     */
//    public void sayHello(Object arg){
//        System.out.println("object："+arg);
//    }

    /**
     * Object类型注释掉后调用变长参数
     * 变长参数优先级最低，此时'a'被当成一个数组元素
     * @param arg
     */
    public void sayHello(char...arg){
        System.out.println("char...："+arg);
    }

    public void sayHello(int...arg){
        System.out.println("int...："+arg);
    }

    public static void main(String[] args) {
        StaticDispatch2 sd = new StaticDispatch2();
        sd.sayHello('a');
    }
}
