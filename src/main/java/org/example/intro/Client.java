package org.example.intro;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Client {
    public static void main(String[] args) {
        System.out.println("main: "+Thread.currentThread().getName());

        Thread t = new Thread(new HelloWorldPrinter());
        Thread t1 = new Thread(()-> System.out.println("Running a thread using anonymous class"+Thread.currentThread().getName()));
        t.start();
        t1.start();
        // ExecutorService ex = Executor.
        System.out.println("ended");
    }
}
