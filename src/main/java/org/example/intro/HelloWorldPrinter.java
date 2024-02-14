package org.example.intro;

public class HelloWorldPrinter implements Runnable{
    @Override
    public void run() {
        System.out.println("Running helloWorldPrinter in thread "+Thread.currentThread().getName());
    }
}
