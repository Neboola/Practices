package com.javarush.test.level14.lesson6.ChickenFactory;

/**
 * Created by Neboola on 08.12.2015.
 */
public class MoldovanHen extends Hen {

    int getCountOfEggsPerMonth() {
        return 39;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + "Moldova" + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
