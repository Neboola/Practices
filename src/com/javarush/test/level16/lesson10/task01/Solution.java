package com.javarush.test.level16.lesson10.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by Neboola on 08.01.2016.
 1. Считаем секунды

 1. Напиши реализацию метода run в нити Stopwatch (секундомер).
 2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
 3. Выведи количество секунд в консоль.

 */
public class Solution {

    private static volatile String str;

    public static void main(String[] args) throws IOException {



        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        ReaderThread readerThread = new ReaderThread();
        readerThread.start();


    }

    public static class ReaderThread extends Thread {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Stopwatch extends Thread {

        private Date start;

        public Stopwatch() {
            start = new Date();

        }

        @Override
        public void run() {
            while (true) {
                if (str != null) {
                    System.out.println("time = " + (new Date().getTime() - start.getTime()) / 1000);
                    return;
                }
            }
        }
    }
}
