package com.javarush.test.level16.lesson11.Resources;

/**
 * Created by Neboola on 13.01.2016.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    // Allow this to be canceled:
    public void cancel() { canceled = true; }
    public boolean isCanceled() { return canceled; }
}
