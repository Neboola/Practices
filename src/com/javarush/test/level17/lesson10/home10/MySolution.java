package com.javarush.test.level17.lesson10.home10;

/* Посчитаем
1. Сделай так, чтобы результат успел посчитаться для всех элементов массива values НЕ используя Thread.sleep
2. Исправь synchronized блок так, чтобы массив values заполнился значением 1
*/

public class MySolution { // http://help.javarush.ru/questions/39857/level17-lesson10-home10-%D0%B7%D0%B0%D0%B3%D0%B0%D0%B4%D0%BE%D1%87%D0%BD%D0%B0%D1%8F-%D0%BC%D0%B0%D0%B3%D0%B8%D1%8F-jav-%D1%8B

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        counter1.join();
        counter2.join();
        counter3.join();
        counter4.join();


        for (int i = 0; i < values.length; i++) {
            System.out.println(i + " : " + values[i]);
            if (values[i] != 1) {

                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }
        System.out.println(count);


    }

    public static void incrementCount() {
        count++;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            while (count < values.length) {
                synchronized (Counter.class) {
                    values[count]++;
                    incrementCount();
                }

            }
        }
    }
}