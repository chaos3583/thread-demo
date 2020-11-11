package com.chaos.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: thread-demo
 * * @description: 多线程顺序执行，实现方式3：创建单一化线程池newSingleThreadExecutor()实现
 * * @author: liaopeng
 * * @create: 2020-11-02 17:49
 **/
public class SortingExecuteDemo3 {

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

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

        executorService.submit(threadA);
        executorService.submit(threadB);
        executorService.submit(threadC);
        executorService.shutdown();
    }
}
