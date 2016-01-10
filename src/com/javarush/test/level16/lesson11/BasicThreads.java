package com.javarush.test.level16.lesson11;

/**
 * Created by Neboola on 10.01.2016.
 */
// Простейший вариант использования класса Thread..
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
