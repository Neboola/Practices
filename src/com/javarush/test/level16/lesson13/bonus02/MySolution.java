package com.javarush.test.level16.lesson13.bonus02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OmniTool on 17.01.2016.
 *
 * 2. Клубок

 Задача: 1. Создай 5 различных своих нитей c отличным от Thread типом:
 1.1. нить 1 должна бесконечно выполняться;
 1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
 1.3. нить 3 должна каждые полсекунды выводить "Ура";
 1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
 1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
 2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
 3. Нити не должны стартовать автоматически.

 Подсказка: Нить 4 можно проверить методом isAlive()
 */
public class MySolution {

    private static List<Thread> threads = new ArrayList<Thread>();
    static {
        threads.add(new Thread1("T1"));
        threads.add(new Thread2("T2"));
        threads.add(new Thread3("T3"));
        threads.add(new Thread4("T4"));
        threads.add(new Thread5("T5"));
    }

    public static void main(String[] args) throws InterruptedException {
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
        threads.get(3).start();
        for (Thread t : threads) {
            if (t.isAlive()) {
                System.out.println(t + " is alive");
            } else {
                System.out.println(t + " is dead");
            }
        }
        Thread.sleep(5000);
        threads.get(1).interrupt();
        Thread.sleep(2000);
        for (Thread t : threads) {
            if (t.isAlive()) {
                System.out.println(t + " is alive");
            } else {
                System.out.println(t + " is dead");
            }
        }
        Thread.sleep(2000);
        threads.get(2).interrupt();
        Thread.sleep(2000);
        for (Thread t : threads) {
            if (t.isAlive()) {
                System.out.println(t + " is alive");
            } else {
                System.out.println(t + " is dead");
            }
        }




    }

    private static class Thread1 extends Thread {

        public Thread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {

            }
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    private static class Thread2 extends Thread {

        public Thread2(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException in " + this);
                    //return;
                }
            }
        }

        @Override
        public String toString() {
            return getName();
        }
    }


    private static class Thread3 extends Thread {

        public Thread3(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ura");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException in " + this);
                }
            }
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    private static class Thread4 extends Thread implements Message {

        public Thread4(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                showWarning();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException in " + this);
            }
        }

        @Override
        public void showWarning() {
            System.out.println("Warning! " + this);
            currentThread().interrupt();
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    private static class Thread5 extends Thread {

        public Thread5(String name) {
            super(name);
        }

        @Override
        public void run() {

        }

        @Override
        public String toString() {
            return getName();
        }
    }
}
