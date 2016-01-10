package com.javarush.test.level16.lesson10.task03;

/**
 * Created by Neboola on 09.01.2016.
 */
public class MySolution {

    public static void main(String[] args) throws InterruptedException {

        TestThread testThread = new TestThread();
        testThread.start();
        Thread.sleep(5000);
        testThread.interrupt();

    }

    private static class TestThread extends Thread {
        public void run() {
            for (int i = 0; ; i++) {
                System.out.println(i + " ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Stop!");
                    return;
                }
            }
        }
    }
}
