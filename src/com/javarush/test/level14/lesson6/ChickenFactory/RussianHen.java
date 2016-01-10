package com.javarush.test.level14.lesson6.ChickenFactory;

/**
 * Created by Neboola on 08.12.2015.
 */
public class RussianHen extends Hen {

    int getCountOfEggsPerMonth() {
        return 19;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + "Russia" + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
