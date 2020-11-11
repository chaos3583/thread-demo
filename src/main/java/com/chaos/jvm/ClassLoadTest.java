package com.chaos.jvm;

/**
 * @program: thread-demo
 * * @description:
 * * @author: liaopeng
 * * @create: 2020-08-20 11:40
 **/
public class ClassLoadTest {
   /* static {
        i=0;//给变量赋值可以正常编译通过
        System.out.println(i);//这句会提示“非法向前引用”
    }
    public static int i=1;*/


    static class Supper{
        static int A=1;
        static {
            A=2;
        }
    }

    static class Sub extends Supper{
        static int B=A;
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(Sub.B);
        MyClassLoader classLoader = new MyClassLoader();
        Object o = classLoader.loadClass("com.chaos.jvm.ClassLoadTest").newInstance();
        System.out.println(o.getClass());
        System.out.println(o instanceof ClassLoadTest);
    }
}
