package com.javarush.test.level16.lesson11.Daemons;

/**
 * Created by Neboola on 11.01.2016.
 */
//: net/mindview/util/DaemonThreadFactory.java

import java.util.concurrent.*;

public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}