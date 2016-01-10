package com.javarush.test.lvl15.lect1;

/**
 * Created by Neboola on 30.11.2015.
 */
public class Tiger extends Cat {

    public Tiger getMyParent() {
        return (Tiger) this.parent;
    }


}
