package com.javarush.test.level18.lesson05.task01;


/* Исправить ошибки
Исправить функциональность в соответствии с требованиями
Программа должна:
1. переписать все байты одного файла в другой одним куском.
2. закрывать потоки ввода-вывода
Подсказка: 4 ошибки
*/

import java.io.*;

public class Solution { // http://info.javarush.ru/JavaRush_tasks_discussion/2014/01/30/package-com-javarush-test-level18-lesson05-task01-.html
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("data");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("result");
        byte[] buffer = new byte[inputStream.available()];
        //while (inputStream.available() > 0) {
            //читаем весь файл одним куском
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);

        //}
        inputStream.close();
        outputStream.close();

    }
}