package com.javarush.test.level16.lesson11.Joins;

/**
 * Created by Neboola on 12.01.2016.
 */
class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }
    public void run() {
        try {
            sleep(duration);
        } catch(InterruptedException e) {
            System.out.println(getName() + " is interrupted. " +
                    "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");

    }
}
