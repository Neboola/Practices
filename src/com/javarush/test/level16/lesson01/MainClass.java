package com.javarush.test.level16.lesson01;

/**
 * Created by Neboola on 08.01.2016.
 */
public class MainClass {

    public static void main(String [] args){
        System.out.println("Multithreading");

        Printer printer = new Printer();
        Thread childThread = new Thread(printer);
        childThread.start();

        for (int i = 0; i < 100000; i++) {
            System.out.println("Main works...");
        }
        System.out.println("Main completed");
    }

    static class Printer implements Runnable{
        public void run(){
            System.out.println("Printer started");
            for (int i = 0; i < 100000; i++) {
                System.out.println("Printer works...");
            }
            System.out.println("Printer completed");

        }
    }

}




