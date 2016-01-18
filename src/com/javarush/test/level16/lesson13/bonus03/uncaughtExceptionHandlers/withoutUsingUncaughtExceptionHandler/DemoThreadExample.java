package com.javarush.test.level16.lesson13.bonus03.uncaughtExceptionHandlers.withoutUsingUncaughtExceptionHandler;

/**
 * Created by OmniTool on 18.01.2016.
 */
public class DemoThreadExample {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
    }
}
