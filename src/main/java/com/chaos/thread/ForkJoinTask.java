package com.chaos.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @program: thread-demo
 * * @description:
 * * @author: liaopeng
 * * @create: 2020-08-04 09:42
 **/
public class ForkJoinTask extends RecursiveTask<Long> {

    private long start;
    private long end;


    public ForkJoinTask(long start, long end) {
        this.end=end;
        this.start=start;
    }

    @Override
    protected Long compute() {
        if (end-start<100){
            long sum =0;
            for (long i = start; i <= end; i++) {
                sum +=i;
            }
            return sum;
        }
        long mid = (end + start)/2;

        ForkJoinTask forkJoinTask1 = new ForkJoinTask( start, mid);
        ForkJoinTask forkJoinTask2 = new ForkJoinTask(mid+1, end);
        invokeAll(forkJoinTask1, forkJoinTask2);
        return forkJoinTask1.join()+ forkJoinTask2.join();
    }

    public static long joinStatistic(long start,long end) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        long sum = 0;

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask forkJoinTask = new ForkJoinTask(start,end);
        sum = forkJoinPool.invoke(forkJoinTask);

        long endTime = System.currentTimeMillis();
        System.out.println("join循环统计时间："+(endTime-startTime));
        System.out.println("join循环统计结果："+sum);
        return sum;
    }

    public static long forStatistic(long start,long end){
        long startTime = System.currentTimeMillis();
        long sum = 0;
        for (long i = start; i <= end; i++) {
            sum +=i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("for循环统计时间："+(endTime-startTime));
        System.out.println("for循环统计结果："+sum);
        return sum;
    }

    public static long streamStatistic(long start,long end){
        long startTime = System.currentTimeMillis();
        long sum = 0;
        sum = LongStream.rangeClosed(start, end).reduce(0, (x, y) -> x + y);
        long endTime = System.currentTimeMillis();
        System.out.println("stream循环统计时间："+(endTime-startTime));
        System.out.println("stream循环统计结果："+sum);
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long end = 100000000L;
        System.out.println("求和统计："+end);
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("计算机核数："+i);
        forStatistic(0L,end);
        joinStatistic(0L,end);
        streamStatistic(0L,end);
    }


}
