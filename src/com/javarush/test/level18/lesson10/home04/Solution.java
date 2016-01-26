package com.javarush.test.level18.lesson10.home04;

import java.io.*;

/**
 * Created by OmniTool on 25.01.2016.
 *
 * 4. Объединение файлов

 Считать с консоли 2 имени файла
 В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
 Закрыть потоки. Не использовать try-with-resources
 */
public class Solution { // слепое решение

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String f1 = r.readLine();
        String f2 = r.readLine();
        FileInputStream fis1 = new FileInputStream(f1);
        FileInputStream fis2 = new FileInputStream(f2);
        byte[] buf1 = new byte[fis1.available()];
        byte[] buf2 = new byte[fis2.available()];
        fis1.read(buf1);
        fis2.read(buf2);
        fis1.close();
        fis2.close();
        FileOutputStream fos1 = new FileOutputStream(f1);
        fos1.write(buf2);
        fos1.write(buf1);
        fos1.close();
        r.close();


    }

}
