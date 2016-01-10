package com.javarush.test.level14.lesson6.ChickenFactory;

/**
 * Created by Neboola on 08.12.2015.
 */
public class UkrainianHen extends Hen {

    int getCountOfEggsPerMonth() {
        return 29;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + "Ukrain" + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
