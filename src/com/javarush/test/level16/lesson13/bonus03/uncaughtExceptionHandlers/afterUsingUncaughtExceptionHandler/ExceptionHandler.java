package com.javarush.test.level16.lesson13.bonus03.uncaughtExceptionHandlers.afterUsingUncaughtExceptionHandler;

/**
 * Created by OmniTool on 18.01.2016.
 */
class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.printf("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n", t.getState());
        new Thread(new Task()).start();
    }
}
