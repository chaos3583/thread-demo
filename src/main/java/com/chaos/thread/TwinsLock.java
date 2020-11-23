package com.chaos.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *利用同步器实现自定义的锁，功效是只允许两个线程同时获取锁
 */
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);

    public TwinsLock() throws IllegalAccessException {
    }

    private static final class Sync extends AbstractQueuedSynchronizer{
        public Sync(int count) throws IllegalAccessException {
            if (count<=0){
                throw new IllegalAccessException("count must larger than 0");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            while (true){
                int state = getState();
                int newCount=state-arg;
                if (newCount<0 || compareAndSetState(state,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true){
                int state = getState();
                int newCount = state+arg;
                if (compareAndSetState(state,newCount)){
                    return true;
                }
            }
        }
    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) throws InterruptedException, IllegalAccessException {
        TwinsLock lock = new TwinsLock();
        class Worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName());
                    }catch (Exception e){

                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i=0;i<10;i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for (int i=0;i<10;i++){
            Thread.sleep(2000);
            System.out.println();
        }
    }
}
