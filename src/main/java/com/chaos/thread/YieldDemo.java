package com.chaos.thread;

/**
 * @program: thread-demo
 * * @description: yield方法
 * * @author: liaopeng
 * * @create: 2020-11-02 16:24
 **/
public class YieldDemo {

    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("线程名："+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyThread A = new MyThread();
        MyThread B = new MyThread();
        A.start();
        B.start();
    }

}
