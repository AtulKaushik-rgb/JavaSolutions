package org.example.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable{

    private Count count;
    Lock lock;

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 0; i<1000; i++) {
            // lock.lock();
                synchronized (count) {
                    count.value += i;
                }
            // lock.unlock();
        }
    }
}
