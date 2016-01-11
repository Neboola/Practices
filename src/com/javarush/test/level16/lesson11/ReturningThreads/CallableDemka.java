package com.javarush.test.level16.lesson11.ReturningThreads;

import java.util.ArrayList;
import java.util.concurrent.*;
/**
 * Created by Neboola on 11.01.2016.
 */
public class CallableDemka {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =
                new ArrayList<Future<String>>();
        for(int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for(Future<String> fs : results)
            try {
                // Вызов get() блокируется до завершения;:
                System.out.println(fs.get());
            } catch(InterruptedException e) {
                System.out.println(e);
                return;
            } catch(ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
    }
}
