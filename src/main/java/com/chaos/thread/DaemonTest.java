package com.chaos.thread;

import java.util.concurrent.TimeUnit;

/**
 * @program: thread-demo
 * * @description: 测试守护线程
 * * 守护线程在jvm退出前会执行
 * * @author: liaopeng
 * * @create: 2020-10-29 11:16
 **/
public class DaemonTest {
    public static void main(String[] args) throws InterruptedException{

        //注入Hook（钩子）线程，在JVM即将退出时会执行
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("JVM要退出了");
        }));
        //用户线程
        Thread userThread = new Thread(()->{
            int i=0;
          while (i++<10){
              try {
                  TimeUnit.SECONDS.sleep(1);
                  System.out.println("用户线程执行中");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        });

        //守护线程
        Thread daemonThread = new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("守护线程执行中");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置为守护线程
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("执行完成，JVM即将退出");
    }
}
