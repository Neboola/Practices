package com.javarush.test.level18.lesson10.home02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by OmniTool on 25.01.2016.
 *
 * 2. Пробелы

 В метод main первым параметром приходит имя файла.
 Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
 1. Посчитать количество всех символов.
 2. Посчитать количество пробелов.
 3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
 4. Закрыть потоки. Не использовать try-with-resources
 */
public class Solution { // слепое решение
    // не считаем чимволы перехода на новую строку и пробелы

    public static void main(String[] args) throws IOException {
        File f = new File(args[0]);
        FileInputStream fileInputStream = new FileInputStream(f);

        int spaceCount = 0;
        int symbolCount = 0;

        while (fileInputStream.available() > 0) {
            int s = fileInputStream.read();
            if (s == 32 )
                spaceCount ++;
            else if (s != 10 && s != 13) symbolCount ++;
        }

        System.out.println("symbolCount = " + symbolCount);
        System.out.println("spaceCount = " + spaceCount);

        System.out.println(String.format("%.2f", ((double)symbolCount / (double)spaceCount * 100)));

        fileInputStream.close();
    }

}
