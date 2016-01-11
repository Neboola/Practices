package com.javarush.test.level16.lesson11.ReturningThreads;

/**
 * Created by Neboola on 11.01.2016.
 */
//: concurrency/CallableDemo.java
import java.util.concurrent.*;
import java.util.*;

class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    public String call() {
        return "result of TaskWithResult " + id;
    }
}
