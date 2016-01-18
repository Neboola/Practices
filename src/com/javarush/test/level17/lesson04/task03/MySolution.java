package com.javarush.test.level17.lesson04.task03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OmniTool on 18.01.2016.
 *
 * 3. Сад-огород

 1. Создайте метод public void addFruit(int index, String fruit) - который добавляет параметр fruit в лист fruits на позицию index
 2. Создайте метод public void removeFruit(int index) - который удаляет из fruits элемент с индексом index
 3. Создайте метод public void addVegetable(int index, String vegetable) - который добавляет параметр vegetable в лист vegetables на позицию index
 4. Создайте метод public void removeVegetable(int index) - который удаляет из vegetables элемент с индексом index
 5. Класс Garden будет использоваться нитями. Поэтому сделай так, чтобы все методы блокировали мютекс this
 6. Реализуй это минимальным количеством кода
 */
public class MySolution { // слепая реализация

    private static Garden testGarden = new Garden();

    public static void main(String[] args) {

        //test1();
        test2();

    }

    private static void test1() {

        for (int i = 0; i < 5; i++) {
            testGarden.addFruit(i, "Fruit " + i);
        }
        testGarden.printList(testGarden.fruits);
        for (int i = 0; i < 5; i++) {
            testGarden.addVegetable(i, "Vegetable " + i);
        }
        testGarden.printList(testGarden.vegetables);

        testGarden.addFruit(7, "New Fruit 0");
        testGarden.printList(testGarden.fruits);

        testGarden.addVegetable(3, "New Vegetable 0");
        testGarden.addVegetable(5, "New Vegetable 1");
        testGarden.printList(testGarden.vegetables);

        testGarden.removeFruit(10);
        testGarden.printList(testGarden.fruits);

        testGarden.removeVegetable(3);
        testGarden.printList(testGarden.vegetables);

        testGarden.removeVegetable(6);
        testGarden.printList(testGarden.vegetables);

    }

    private static void test2() {

        List<Thread> threads = new ArrayList<Thread>();
        threads.add(new ThreadAddFruits());
        threads.add(new ThreadAddVeg());
        threads.add(new ThreadRemoveFruits());
        threads.add(new ThreadRemoveVeg());
        threads.add(new ThreadCounter());

        for (Thread t : threads) {
            t.start();
        }

    }



    public static class Garden {

        private static List<String> fruits = new ArrayList<String>();
        private static List<String> vegetables = new ArrayList<String>();

        public void addFruit(int index, String fruit) {
            addOne(fruits, index, fruit);
        }

        public void removeFruit(int index) {
            removeOne(fruits, index);
        }

        public void addVegetable(int index, String vegetable) {
            addOne(vegetables, index, vegetable);
        }

        public void removeVegetable(int index) {
            removeOne(vegetables, index);
        }

        private synchronized void addOne(List<String> list, int index, String one) {
            int size = list.size();
            if (size < index) {
                for (int i = 0; i < index-size; i++) {
                    list.add("____");
                }
            }
            list.add(index, one);
            System.out.println(Thread.currentThread() + " - add: " + index + " " + one);
            System.out.println();


        }

        private synchronized void removeOne(List<String> list, int index) {
            if (list.size() <= index) {
                System.out.println(Thread.currentThread() + " - can't remove: " + index);
                System.out.println();
            } else {
                list.remove(index);
                System.out.println(Thread.currentThread() + " - remove: " + index);
                System.out.println();
            }
        }

        private synchronized void printList(List<String> list) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("size = " + list.size());
            System.out.println();

        }

        private static int chooseRandomOne(int number) {
            return (int) (Math.random() * number);
        }

    }


    private static class ThreadAddFruits extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                testGarden.addFruit(0, "Fruit " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreadRemoveFruits extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                testGarden.removeFruit(testGarden.chooseRandomOne(testGarden.fruits.size()));
                try {
                    Thread.sleep(620);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreadAddVeg extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                testGarden.addVegetable(0, "Veg " + i);
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreadRemoveVeg extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                testGarden.removeVegetable(testGarden.chooseRandomOne(testGarden.vegetables.size()));
                try {
                    Thread.sleep(870);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ThreadCounter extends Thread {
        @Override
        public void run() {
            while (true) {
                testGarden.printList(testGarden.fruits);
                testGarden.printList(testGarden.vegetables);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
