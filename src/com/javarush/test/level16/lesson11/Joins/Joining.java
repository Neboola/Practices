package com.javarush.test.level16.lesson11.Joins;

/**
 * Created by Neboola on 12.01.2016.
 */
public class Joining {
    public static void main(String[] args) throws InterruptedException {
        Sleeper
                sleepy = new Sleeper("Sleepy", 3300),
                grumpy = new Sleeper("Grumpy", 3300);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        Thread.sleep(2000);
        grumpy.interrupt();
    }
}
