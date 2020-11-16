package com.chaos.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecuterDemo {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(1);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(2);
    }
}
