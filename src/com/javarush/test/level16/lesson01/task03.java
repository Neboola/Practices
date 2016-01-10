package com.javarush.test.level16.lesson01;

import java.util.ArrayList;

/**
 * Created by Neboola on 08.01.2016.
 */
public class task03 {

    private static ArrayList<SpecialThread> list = new ArrayList<SpecialThread>();
    public static int n;

    public static void main(String[] args) {
        list.add(new SpecialThread());
        list.add(new SpecialThread());
        list.add(new SpecialThread());
        list.add(new SpecialThread());
        list.add(new SpecialThread());

        for (int i = 0; i < list.size(); i++) {
            list.get(i).start();
        }
    }

    public static class SpecialThread extends Thread {

        public void run() {
            n++;
            System.out.println("thread #" + n);
        }
    }
}
