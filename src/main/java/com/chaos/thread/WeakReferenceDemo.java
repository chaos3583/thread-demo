package com.chaos.thread;

/**
 * @program: thread-demo
 * * @description:
 * * @author: liaopeng
 * * @create: 2020-08-13 14:12
 **/
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 弱引用回收测试
 */
public class WeakReferenceDemo {

    //弱引用
    static WeakReference<String> weakString =null;
    //以弱引用为key创建map
    static Map<WeakReference,Object> map = new HashMap<>();
    public static void main(String[] args) {
        test();

        System.gc();
        //不存在强引用后，gc回收弱引用
        System.out.println(weakString.get());
        //虽然作为key的弱引用回收了，但是map依然存在
        System.out.println(map.get(weakString));
    }

    public static void test(){
        /*
        此处用new String("hello") 而不是 str="hello" 是因为new String("hello")是直接在堆中创建对象，
        方法结束后对象就被回收。而str="hello"操作的是常量池。
        */
        String str = new String("hello");
        //创建指向字符串对象的弱引用
        weakString = new WeakReference<>(str);
        map.put(weakString,"2");
        System.gc();
        //此时仍有指向str的强引用，所以此次gc不会回收弱引用
        System.out.println(weakString);
    }
}

