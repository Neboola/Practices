package com.javarush.test.level18.lesson10.home01;

import java.io.*;

/**
 * Created by OmniTool on 26.01.2016.
 *
 * 1. Английские буквы

 В метод main первым параметром приходит имя файла.
 Посчитать количество букв английского алфавита, которое есть в этом файле.
 Вывести на экран число (количество букв)
 Закрыть потоки. Не использовать try-with-resources
 */
public class Solution { //слепое решение

    public static void main(String[] args) throws IOException {

        File f = new File(args[0]);
        FileInputStream fr = new FileInputStream(f);
        int count = 0;
        while (fr.available() > 0) {
            int symbol = fr.read();
            if ( ((symbol >= 65) && (symbol <= 90)) || ((symbol >= 97) && (symbol <= 122)) ) count++;
        }
        System.out.println(count);

        fr.close();
    }

}
