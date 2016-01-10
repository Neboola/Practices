package com.javarush.test.level14.lesson6.ChickenFactory;

/**
 * Created by Neboola on 08.12.2015.
 */
public class BelarusianHen extends Hen {

    int getCountOfEggsPerMonth() {
        return 9;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + "Belarus" + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
