package com.javarush.test.level18.lesson10.home03;

import java.io.*;

/**
 * Created by OmniTool on 25.01.2016.
 *
 * 3. Два в одном

 Считать с консоли 3 имени файла
 Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
 Закрыть потоки. Не использовать try-with-resources
 */
public class Solution { // слепое решение

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s1 = r.readLine();
        String s2 = r.readLine();
        String s3 = r.readLine();
        FileOutputStream f1 = new FileOutputStream(s1);
        FileInputStream f2 = new FileInputStream(s2);
        FileInputStream f3 = new FileInputStream(s3);
        byte[] buf2 = new byte[f2.available()];
        byte[] buf3 = new byte[f3.available()];
        f2.read(buf2);
        f3.read(buf3);
        f1.write(buf2);
        f1.write(buf3);

        f1.close();
        f2.close();
        f3.close();
        r.close();
    }

}
