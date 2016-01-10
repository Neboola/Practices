package com.javarush.test.level13.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 1. Сортировка четных чисел из файла.

 Задача:
 1. Ввести имя файла с консоли.
 2. Прочитать из него набор чисел.
 3. Вывести на консоль только четные, отсортированные по возрастанию.

 Пример ввода:
 5
 8
 11
 3
 2
 10

 Пример вывода:
 2
 8
 10
 */
public class InputAndSort
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader fR = new BufferedReader(new FileReader("file3"));
        List<Integer> list = new ArrayList<Integer>();

        while (true) {
            String s = fR.readLine();
            if (s == null) break;
            list.add(Integer.parseInt(s));
            System.out.println(s + " added to list");

        }

        System.out.println();
        for (int i : list) {
            System.out.println(i);
        }

        Collections.sort(list);
        System.out.println();
        for (int i : list) {
            if (i % 2 == 0) System.out.println(i);
        }

    fR.close();

    }
}
