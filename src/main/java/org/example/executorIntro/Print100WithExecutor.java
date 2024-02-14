package org.example.executorIntro;

public class Print100WithExecutor implements Runnable{
    private int i;
    public Print100WithExecutor(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Printing "+i+" in thread :"+Thread.currentThread().getName());
    }
}
