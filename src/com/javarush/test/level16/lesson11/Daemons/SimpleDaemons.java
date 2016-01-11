package com.javarush.test.level16.lesson11.Daemons;

/**
 * Created by Neboola on 11.01.2016.
 */
//: concurrency/SimpleDaemons.java
// Потоки-демоны не препятствуют завершению работы программы.
import java.util.concurrent.*;


public class SimpleDaemons implements Runnable {
    private static int count;
    private int id;

    public SimpleDaemons() {
        id = count++;
        System.out.println(id + " created");
    }

    public void run() {

        try {
            while(true) {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(Thread.currentThread() + " - " + this + " - " + id);
            }
        } catch(InterruptedException e) {
            System.out.println("sleep() in " + id + "  interrupted");
        }
    }
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Необходимо вызвать перед start()
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(3800);
    }
}
