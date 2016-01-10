package com.javarush.test.lvl15.lect1;

/**
 * Created by Neboola on 30.11.2015.
 */
public class Cat {

    public Cat parent;
    public Cat getMyParent() {
        return this.parent;
    }
    public void setMyParent(Cat cat) {
        this.parent = cat;
    }
}
