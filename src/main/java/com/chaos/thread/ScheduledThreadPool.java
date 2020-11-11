package com.chaos.thread;

import ch.qos.logback.core.util.TimeUtil;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: thread-demo
 * * @description:通过ScheduledExecutorService线程池实现定时任务
 * * @author: liaopeng
 * * @create: 2020-08-12 15:14
 **/
public class ScheduledThreadPool {
    public static void main(String[] args) throws ParseException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = "20200817162230";
        long nowTime = new Date().getTime();
        long targetTime = sf.parse(dateStr).getTime();

        //循环执行，每隔10秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("嘿嘿嘿");
            }
        },0,10,TimeUnit.SECONDS);//0标识启动等待时间，0表示立即执行

        //指定在未来某个时间点执行
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行了");
            }
        },targetTime-nowTime, TimeUnit.MILLISECONDS);
    }
}
