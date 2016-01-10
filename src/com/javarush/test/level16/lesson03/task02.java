package com.javarush.test.level16.lesson03;

/**
 * Created by Neboola on 08.01.2016.
 */
public class task02 {

    public static void main(String[] args) {
        Thread childThread = new TestThread();
        childThread.start();
    }

    public static class TestThread extends Thread {
        private static int var = 0;
        static {
            System.out.println("it's static block inside TestThread");
            System.out.println(var);
            var += 5;
            System.out.println(var);
        }
        public void run() {
            System.out.println("it's run method");

        }
    }
}


