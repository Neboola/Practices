package com.javarush.test.level16.lesson11;

/**
 * Created by Neboola on 10.01.2016.
 */
//: concurrency/FixedThreadPool.java
import java.util.concurrent.*;

public class FixedThreadPool {
    public static void main(String[] args) {
        // В аргументе конструктора передается количество потоков:
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
