package com.javarush.test.level16.lesson11;

/**
 * Created by Neboola on 10.01.2016.
 */
// Добавление новых потоков.
public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
}
