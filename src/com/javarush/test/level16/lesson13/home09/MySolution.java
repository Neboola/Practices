package com.javarush.test.level16.lesson13.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OmniTool on 16.01.2016.
 *
 * 9. Только по-очереди!

 1. В классе Solution создать нить public static Read3Strings унаследовавшись от Thread.
 2. В методе run реализовать чтение с консоли трех строк.
 3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
 4. В методе main вывести результат для каждой нити.
 5. Используйте join
 Пример входных данных:
 a
 b
 c
 d
 e
 f
 Выходные данные:
 a b c
 d e f
 */
public class MySolution { //слепая реализация

    private static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static volatile List<String> list = new ArrayList<String>();

    public static void main(String[] args) throws InterruptedException, IOException {
        Thread t1 = new Read3Strings();
        Thread t2 = new Read3Strings();
        Thread t3 = new Read3Strings();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        reader.close();

    }

    public static class Read3Strings extends Thread {

        @Override
        public void run() {
            try {
                list.add(reader.readLine() + " " + reader.readLine() + " " + reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

