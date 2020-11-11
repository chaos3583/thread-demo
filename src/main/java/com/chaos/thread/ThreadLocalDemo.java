package com.chaos.thread;


import com.chaos.TestDomain;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: thread-demo
 * * @description:
 * * @author: liaopeng
 * * @create: 2020-08-04 14:57
 **/
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        String value =new String("abc");
        threadLocal.set(value);
        System.gc();
        System.out.println(threadLocal.get());
    }

    /**
     * 测试以对象实例作为key时，Map的回收情况
     */
    public static void test1(){
        TestDomain t1 = new TestDomain();
        TestDomain t2 = new TestDomain();
        Map<TestDomain,Object> map = new HashMap<>();
        map.put(t1,"1");
        map.put(t2,"2");

        t1=null;
        System.gc();
        System.out.println("第一步："+map);

        t2=null;
        System.gc();
        System.out.println("第二步："+map);

        map.clear();
        System.gc();
        System.out.println("第三步："+map);


    }

}

