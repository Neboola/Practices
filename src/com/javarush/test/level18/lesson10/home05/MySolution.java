package com.javarush.test.level18.lesson10.home05;

import java.io.*;
import java.math.BigDecimal;

/**
 * Created by OmniTool on 25.01.2016.
 *
 * 5. Округление чисел

 Считать с консоли 2 имени файла
 Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
 Округлить числа до целых и записать через пробел во второй файл
 Закрыть потоки. Не использовать try-with-resources
 Принцип округления:
 3.49 - 3
 3.50 - 4
 3.51 - 4
 -3.49 - -3
 -3.50 - -3   :(
 -3.51 - -4
 */
public class MySolution { //перевод чисел без -3.50 = -3

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name1 = r.readLine();
        String name2 = r.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(name1));
        String str = reader.readLine();
        String[] strArr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            BigDecimal bigDecimal = new BigDecimal(strArr[i]);
            bigDecimal = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
            sb.append(bigDecimal + " ");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(name2));
        writer.write(sb.toString());

        r.close();
        reader.close();
        writer.close();



    }

}
