package org.example.print100;

public class Client {
    public static void main(String[] args) {
        System.out.println("Main thread "+Thread.currentThread().getName());
        Print100Task task;
        Thread t;

        for(int i = 0; i<= 50; i++) {
            t = new Thread(new Print100Task(i));
            t.start();
        }
    }
}
