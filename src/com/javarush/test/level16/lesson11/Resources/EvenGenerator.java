package com.javarush.test.level16.lesson11.Resources;

/**
 * Created by Neboola on 13.01.2016.
 */
// Конфликт потоков.

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public synchronized int next() {
        ++currentEvenValue;  // Опасная точка!
        Thread.yield(); // Ускоряем сбой
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
