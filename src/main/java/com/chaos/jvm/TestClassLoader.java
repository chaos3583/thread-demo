package com.chaos.jvm;

/**
 * @program: thread-demo
 * * @description:
 * * @author: liaopeng
 * * @create: 2020-08-14 15:18
 **/
public class TestClassLoader {
    public static void main(String[] args) {

        //被动引用示例1:通过子类引用父类的静态字段不会导致父类初始化
        System.out.println(SubClass.value);

        //被动引用示例2：通过数组引用类，不会触发类的初始化
        SupperClass[] arr = new SupperClass[10];

        /*被动引用示例3：常量在编译阶段会存入调用类的常量池中，
          本质上没有直接引用到调用常量的类，不会触发定义常量的类的初始化
        */
        System.out.println(ConstClass.HELLO);
    }
}
