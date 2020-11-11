package com.chaos.thread;

/**
 * @program: thread-demo
 * * @description: 多线程顺序执行,实现方式1：join方法执行
 * * @author: liaopeng
 * * @create: 2020-11-02 17:15
 **/
public class SortingExecuteDemo1 {


    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("打开冰箱");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("把大象放进冰箱");
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("关上冰箱");
            }
        });
        threadA.start();
        threadA.join();//表示主线程等threadA执行完再继续
        threadB.start();
        threadB.join();//表示主线程等threadB执行完再继续
        threadC.start();
    }
}
