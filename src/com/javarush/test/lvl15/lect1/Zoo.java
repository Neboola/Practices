package com.javarush.test.lvl15.lect1;

/**
 * Created by Neboola on 30.11.2015.
 */
public class Zoo
{

    public static void main(String[] args)
    {
        Cat parent = new Tiger();
        Tiger me = new Tiger();
        me.setMyParent(parent);
        Cat myParent = me.getMyParent();
    }
}
