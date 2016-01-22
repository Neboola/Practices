package com.javarush.test.level18.lesson03.task05;

import java.io.*;
import java.util.*;

/**
 * Created by OmniTool on 22.01.2016.
 *
 * 5. Сортировка байт

 Ввести с консоли имя файла
 Считать все байты из файла.
 Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
 Вывести на экран
 Закрыть поток ввода-вывода

 Пример байт входного файла
 44 83 44

 Пример вывода
 44 83
 */
public class MySolution { // слепое решение

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(new File(filename));
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }

        set.addAll(list);

        list.clear();
        list.addAll(set);
        Collections.sort(list);

        for (int i : list) System.out.println((char)i + "-" + i);


        fileInputStream.close();

    }
}
