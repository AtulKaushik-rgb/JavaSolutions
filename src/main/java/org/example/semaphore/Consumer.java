package org.example.semaphore;

import java.util.Queue;

public class Consumer implements Runnable{
    Queue<Object> store;
    int maxSize;
    String name;

    public Consumer(Queue<Object> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {

    }
}
