package com.javarush.test.level09.lesson11.bonus02;

import java.io.*;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два имени файла. И копирует первый файл на место,
заданное вторым именем.
Новая задача: Программа вводит два имени файла. И копирует первый файл
на место, заданное вторым именем.
Если файла (который нужно копировать) с указанным именем не существует,
то программа должна вывести надпись «Файл не существует.»
и еще раз прочитать имя файла с консоли,
а уже потом считывать файл для записи.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));




/*
        System.out.println();
        File f1 = new File(sourceFileName);
        f1.createNewFile();
        File f2 = new File(destinationFileName);
        f2.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(f1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(f1));
        for (int i = 0; i < 5; i++) {
            bw.write(reader.readLine() + '\n');
        }
        bw.close();
        String s = "";
        while (s != null){
            s = br.readLine();
            System.out.println(s);
        }
        System.out.println();
*/
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        while (true) {
            try {
                String sourceFileName = reader.readLine();
                fileInputStream = new FileInputStream(sourceFileName);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Файл не существует.");
            }

        }
        //
                String destinationFileName = reader.readLine();
                fileOutputStream = new FileOutputStream(destinationFileName);



        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
