package com.javarush.test.level17.lesson10.home03.mySolution;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by OmniTool on 19.01.2016.
 *
 * 3. Аптека

 Реализуй интерфейс Runnable в классах Apteka и Person.
 Все нити должны работать пока не isStopped
 Логика для Apteka: drugsController должен сделать закупку случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 300 мс
 Логика для Person: drugsController должен сделать продажу случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 100 мс
 Расставь synchronized там, где это необходимо
 */
public class MySolution { //слепая реализация

    private static boolean isStoped = false;

    private static DrugsController drugsController = new DrugsController();

    public static void main(String[] args) {


            Thread apteka = new Thread(new Apteka());
            Thread person = new Thread(new Person());
            apteka.start();
            person.start();
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(apteka.isAlive());
            System.out.println(person.isAlive());
        }


    private static void stop() {
        isStoped = true;
    }

    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    public static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<Drug>(drugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static class Apteka implements Runnable {

        @Override
        public void run() {
            while (!isStoped) {
                drugsController.buy(getRandomDrug(), getRandomCount());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Person implements Runnable {

        @Override
        public void run() {
            while (!isStoped) {
                drugsController.sell(getRandomDrug(), getRandomCount());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
