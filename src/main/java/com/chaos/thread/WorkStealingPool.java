package com.chaos.thread;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @program: thread-demo
 * * @description:
 * * @author: liaopeng
 * * @create: 2020-08-17 16:58
 **/
public class WorkStealingPool {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        for (int i = 0; i < 4; i++) {
//            FutureTask futureTask = new FutureTask(new R(1000000000L));
            Future<String> submit = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(30);
                    return Thread.currentThread().getName();
                }
            });
            System.out.println(submit.get());
        }
    }


    static class R implements Callable{
        long n;

        public R(long n) {
            this.n = n;
        }
        @Override
        public Object call() throws Exception {
            long sum=0;
            try {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i <=n; i++) {
                    sum =sum+i;
                }
            }catch (Exception e){

            }
            return sum;
        }
    }
}
