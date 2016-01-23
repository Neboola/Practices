package com.javarush.test.level18.lesson03.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OmniTool on 22.01.2016.
 *
 * 3. Самые частые байты

 Ввести с консоли имя файла
 Найти байт или байты с максимальным количеством повторов
 Вывести их на экран через пробел.
 Закрыть поток ввода-вывода
 */
public class MySolution { //слепое решение

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String filename = r.readLine();
        FileInputStream fis = new FileInputStream(new File(filename));
        int size = 0;
        while (fis.available() > 0) {
            int bayt = fis.read();
            System.out.println("считано: " + bayt + " - " + (char)bayt);
            if (size < bayt) size = bayt;
        }
        int[] arr = new int[size + 1];
        fis = new FileInputStream(new File(filename));
        while (fis.available() > 0) {
            int symbol = fis.read();
            arr[symbol]++;
        }
        int max = 0;
        for (int b : arr) {
            if (max < b) max = b;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) System.out.print((char)i + "(" + arr[i] + "раз)" + " ");
        }
        fis.close();
        r.close();


    }
}
