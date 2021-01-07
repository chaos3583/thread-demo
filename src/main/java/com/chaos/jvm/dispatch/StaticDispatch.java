package com.chaos.jvm.dispatch;

/**
 * @author liaopeng
 * @title: StaticDispatch
 * @projectName myProjects
 * @description: TODO
 * @date 2020/12/184:29 下午
 */
public class StaticDispatch {

    static class Human {}

    static class Man extends Human{}

    static class Woman extends Human{}


    public void sayHello(Human human){
        System.out.println("hello human");
    }

    public static void sayHello(Man man){
        System.out.println("hello man");
    }

    public static void sayHello(Woman woman){
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        StaticDispatch sd = new StaticDispatch();
        Human man = new Man();
        Human woman = new Woman();
        sd.sayHello(man);
        sd.sayHello(woman);
    }
}
