package com.javarush.test.level16.lesson11.SleepingThread;

/**
 * Created by Neboola on 11.01.2016.
 */
//: concurrency/SleepingTask.java
// Вызов sleep() для приостановки потока.
import com.javarush.test.level16.lesson11.LiftOff;

import java.util.concurrent.*;

public class SleepingTask extends LiftOff {
    public void run() {
        try {
            while(countDown-- > 0) {
                System.out.print(status());
                // Старый стиль.
                // Thread.sleep(l00);
                // Стиль Java SE5/6:
                TimeUnit.MILLISECONDS.sleep(100);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch(InterruptedException e) {
            System.err.println("Interrupted");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
            Thread.sleep(10);
        }

        exec.shutdown();
    }
}
