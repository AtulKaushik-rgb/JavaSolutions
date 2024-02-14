package org.example.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("client for synchronization");
        //define tasks
        Count count = new Count(0);
        Lock lock = new ReentrantLock();

        Adder add = new Adder(count, lock);
        Substractor sub = new Substractor(count, lock);

        Thread t1 = new Thread(add);
        Thread t2 = new Thread(sub);
        t1.start();
        t2.start();

        //it runs with ex service
//        ExecutorService ex = Executors.newCachedThreadPool();
//        ex.submit(add);
//        ex.submit(sub);
        t1.join();
        t2.join();

        System.out.println(count.value);
    }
}
