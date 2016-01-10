package com.javarush.test.level14.lesson6.ChickenFactory;

/**
 * Created by Neboola on 08.12.2015.
 */
public abstract class Hen {
    abstract int getCountOfEggsPerMonth();
    String getDescription() {
        return "Я курица.";
    }
}
