package org.example.print100;

public class Print100Task implements Runnable {
    private int i;
    public Print100Task(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Printing "+i+" in thread :"+Thread.currentThread().getName());
    }
}
