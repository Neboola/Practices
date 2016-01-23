package com.javarush.test.level18.lesson03.task01;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by OmniTool on 22.01.2016.
 *
 * 1. Максимальный байт

 Ввести с консоли имя файла
 Найти максимальный байт в файле, вывести его на экран.
 Закрыть поток ввода-вывода
 */
public class MySolution { //слепое решение

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name = r.readLine();
        int max = Character.MIN_VALUE;
        FileInputStream fs = new FileInputStream(new File(name));
        while (fs.available() > 0) {
            int bayt = fs.read();
            System.out.println("считано: " + bayt + " - " + (char)bayt);
            if (max < bayt) max = bayt;
        }
        System.out.println();
        System.out.println("max: " + max + " - [" + (char)max + "]");
        System.out.println("\\r : " + (int)'\r');
        System.out.println("\\n : " + (int)'\n');
        fs.close();
        r.close();
    }

}
