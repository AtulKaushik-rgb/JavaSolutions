package org.example.semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Client {
    Queue<Object> store = new ConcurrentLinkedDeque<>();
    int size = 6;
    Producer p1 = new Producer(store, size, "p1");
    Producer p2 = new Producer(store, size, "p2");
    Producer p3 = new Producer(store, size, "p3");

    Consumer c1 = new Consumer(store, size, "c1");
    Consumer c2 = new Consumer(store, size, "c2");
    Consumer c3 = new Consumer(store, size, "c3");
    Consumer c4 = new Consumer(store, size, "c4");
    Consumer c5 = new Consumer(store, size, "c5");


}
