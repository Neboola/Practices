package com.javarush.test.level18.lesson03.task02;

import java.io.*;

/**
 * Created by OmniTool on 22.01.2016.
 *
 * 2. Минимальный байт

 Ввести с консоли имя файла
 Найти минимальный байт в файле, вывести его на экран.
 Закрыть поток ввода-вывода
 */
public class MySolution { //слепое решение

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name = r.readLine();
        int min = Character.MAX_VALUE;
        FileInputStream fs = new FileInputStream(new File(name));
        while (fs.available() > 0) {
            int bayt = fs.read();
            System.out.println("считано: " + bayt + " - " + (char)bayt);
            if (min > bayt) min = bayt;
        }
        System.out.println();
        System.out.println("min: " + min + " - [" + (char)min + "]");
        System.out.println("\\r : " + (int)'\r');
        System.out.println("\\n : " + (int)'\n');
        fs.close();
    }

}
