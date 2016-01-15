package com.javarush.test.level16.lesson13.home03;

import com.javarush.test.level20.lesson02.task05.Solution;

/**
 * Created by OmniTool on 15.01.2016.
 *
 * 3. Рекурсивное создание нитей

 1. Измени класс GenerateThread так, чтобы он стал нитью.
 2. Создай конструктор GenerateThread, который должен:
 2.1. Вызвать конструктор суперкласса с параметром String - номером созданной нити. Используй countCreatedThreads.
 2.2. Запустить текущую нить.
 2.3. Номер первой нити должен начинается с 1.
 3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods. Начни печатать toString.
 3.1. Метод toString должен возвращать № текущей нити и слово " created". Используй getName(). Пример: [8 created]
 4. Пока количество созданных нитей меньше Solution.count метод run должен:
 4.1. создать новую нить типа GenerateThread.
 4.2. Вывести в консоль созданную в пункте 4.1. нить.
 5. В итоге должно быть выведено в консоль 15 строк.
 */
public class MySolution2 {

    private static int count = 10;

    public static void main(String[] args) throws InterruptedException {
        new GenerateThread(1);
    }

    private static class GenerateThread extends Thread {

        private static int countCreatedThreads;

        public GenerateThread(int number) {
            super(String.valueOf(number));
            countCreatedThreads = number;
            start();
        }

        @Override
        public void run() {
            if (countCreatedThreads < count ) {
                new GenerateThread(countCreatedThreads + 1);
            }
            System.out.println(this);
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }
    }
}
