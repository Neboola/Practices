package com.javarush.test.level16.lesson11.Joins;

/**
 * Created by Neboola on 12.01.2016.
 */
class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run() {
        try {
            sleeper.join();
        } catch(InterruptedException e) {
            System.out.println("Joiner is Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}