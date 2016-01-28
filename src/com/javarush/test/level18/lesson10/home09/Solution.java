package com.javarush.test.level18.lesson10.home09;

import java.io.*;

/**
 * Created by OmniTool on 25.01.2016.
 *
 * 9. Файлы и исключения

 Читайте с консоли имена файлов
 Если файла не существует (передано неправильное имя файла), то
 перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы
 Закрыть потоки. Не использовать try-with-resources
 Не используйте System.exit()
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String name = reader.readLine();
            if (name.equals("exit")) {
                reader.close();
                return;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(name);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(name);
                return;
            }
        }


    }



}
