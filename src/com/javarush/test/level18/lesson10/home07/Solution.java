package com.javarush.test.level18.lesson10.home07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by OmniTool on 25.01.2016.
 *
 * 7. Поиск данных внутри файла

 Считать с консоли имя файла
 Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
 Программа запускается с одним параметром: id (int)
 Закрыть потоки. Не использовать try-with-resources

 В файле данные разделены пробелом и хранятся в следующей последовательности:
 id productName price quantity

 где id - int
 productName - название товара, может содержать пробелы, String
 price - цена, double
 quantity - количество, int

 Информация по каждому товару хранится в отдельной строке
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Incorrect argument");
            return;
        }

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String filename = r.readLine();
        r.close();
        BufferedReader fr = new BufferedReader(new FileReader(filename));
        while (fr.ready()) {
            String str = fr.readLine();
            if (str.matches(args[0] + " *")) System.out.println(str);
            if (str.startsWith(args[0] + " ")) System.out.println(str);
        }
        fr.close();


    }

}
