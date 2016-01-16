package com.javarush.test.level16.lesson13.home07;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OmniTool on 16.01.2016.
 *
 * 7. Поиграем?

 Три человека играют в игру. Каждый игрок (Gamer) характеризуется двумя параметрами: фамилией (name) и количеством действий в секунду (rating).
 Нужно вывести в консоль ход игры и определить победителя и проигравших.
 Итак...
 1. Разберись, что делает программа.
 1.1. List<String> steps хранит последовательность действий, которое каждый игрок выполняет от 0 до последнего.
 1.2. isWinnerFound показывает, найден победитель или нет.
 1.3. метод sleep выбрасывает InterruptedException и принимает параметр типа long.
 1.4. Игроки играют независимо друг от друга.

 2. Реализуйте логику метода run так, чтобы для каждого игрока:
 2.1. За 1 секунду через равные интервалы времени выводились в консоль действия, описанные в steps. Количество выведенных действий должно равняться rating.
 2.2. Любой текст должен начинаться с фамилии игрока (метод getName()), потом следовать двоеточие, а затем сам текст. Пример: [Ivanov:Начало игры].
 2.3. Когда игрок выполнит все действия из steps, то он считается победителем. Выведите [getName() + ":победитель!"].
 2.4. Когда найден победитель, то игра останавливается, и остальные игроки считаются побежденными. Выведите для них [getName() + ":проиграл"].
 */
public class MySolution { //слепая реализация

    private static List<String> steps = new ArrayList<String>();
    private static boolean isWinnerFound = false;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            steps.add("step " + i);
        }
        new Gamer("Vasya", 3);
        new Gamer("Petya", 4);
        new Gamer("Kolya", 2);
    }

    private static class Gamer extends Thread{

        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
            start();

        }

        @Override
        public void run() {
            System.out.println(getName() + " starts");

            for (int i = 0; i < steps.size(); i++) {
                if (isWinnerFound) {
                    System.out.println(getName() + ":looser");
                    return;
                }
                System.out.println(getName() + ":" + steps.get(i));
                try {
                    Thread.sleep(1000/rating);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " interrupted");
                }
            }
            isWinnerFound = true;
            System.out.println(getName() + ":wins!");

        }


    }
}
