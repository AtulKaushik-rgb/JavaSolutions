package org.example.executorIntro;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        System.out.println("Main thread");
        ExecutorService ex = Executors.newFixedThreadPool(10);
        for(int i = 1;i <100; i++) {
            ex.execute(()-> System.out.println("printing in new thread:"+Thread.currentThread().getName()));
        }
        ex.shutdown();
    }
}
