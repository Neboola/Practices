package com.javarush.test.level16.lesson11.Resources;

/**
 * Created by Neboola on 13.01.2016.
 */
// Объекты Lock из библиотеки concurrent делают возможными
// попытки установить блокировку в течение некоторого времени
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " +
                    captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }
    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- блокировка доступна
        al.timed();   // True -- блокировка доступна
        // Теперь создаем отдельную задачу для установления блокировки:
        new Thread() {
            { setDaemon(true); }
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield(); // Даем возможность 2-й задаче
        al.untimed(); // False -- блокировка захвачена задачей
        al.timed();   // False -- блокировка захвачена задачей
    }
}
