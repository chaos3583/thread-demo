package com.chaos.thread;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @program: thread-demo
 * * @description: 多线程顺序执行,实现方式2：CountDownLatch的wait方法和countDown方法
 * * @author: liaopeng
 * * @create: 2020-11-02 17:29
 **/
public class SortingExecuteDemo2 {

    //定义两个数量为1的同步计数器。
    private static CountDownLatch countDownLatch1 = new CountDownLatch(1);
    private static  CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("打开冰箱");
                countDownLatch1.countDown();//第一步执行完成，执行完计数器1减一
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                countDownLatch1.await();//第二步，等待第一步的计数器1的计数为0
                System.out.println("把大象放进冰箱");
                countDownLatch2.countDown();//第二步执行完成，第二步的计数器2减一
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                countDownLatch2.await();//第三步，等待第二步的计数器2减一
                System.out.println("关上冰箱");
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
