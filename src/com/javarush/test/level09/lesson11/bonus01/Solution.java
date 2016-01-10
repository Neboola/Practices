package com.javarush.test.level09.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два имени файла. И копирует первый файл на место заданное вторым именем.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //System.out.println("source:");
        String sourceFileName = reader.readLine();
        //File f1 = new File(sourceFileName);
        //System.out.println("destintion:");
        String destinationFileName = reader.readLine();
        //File f2 = new File(destinationFileName);

        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(sourceFileName);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(destinationFileName);

        int count = 0;
        while (fileInputStream.available()>0)
        {
            int data = fileInputStream.read();

            fileOutputStream.write(data);

            count++;

            //System.out.println(count);
        }

        System.out.println("Скопировано байт " + count);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
