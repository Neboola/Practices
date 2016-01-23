package com.javarush.test.level18.lesson05.task03;

import java.io.*;

/**
 * Created by OmniTool on 22.01.2016.
 *
 * 3. Разделение файла

 Считать с консоли три имени файла: файл1, файл2, файл3.
 Разделить файл1 по следующему критерию:
 Первую половину байт записать в файл2, вторую половину байт записать в файл3.
 Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
 Закрыть потоки. Не использовать try-with-resources
 */
public class Solution { // слепое решение

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis1 = new FileInputStream(new File(reader.readLine()));
        FileOutputStream fis2 = new FileOutputStream(new File(reader.readLine()));
        FileOutputStream fis3 = new FileOutputStream(new File(reader.readLine()));

        byte[] bufferForFIS3 = new byte[fis1.available() / 2];
        byte[] bufferForFIS2 = new byte[fis1.available() - bufferForFIS3.length];

        int count2 = fis1.read(bufferForFIS2);
        int count3 = fis1.read(bufferForFIS3);

        fis2.write(bufferForFIS2, 0, count2);
        fis3.write(bufferForFIS3, 0, count3);

        fis1.close();
        fis2.close();
        fis3.close();


    }

}
