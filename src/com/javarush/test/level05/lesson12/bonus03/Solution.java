package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;
import java.util.TreeSet;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int i = 0;
        while (i <= 0) {
            i = Integer.parseInt(reader.readLine());
        }
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int j = 0; j < i; j++) {
            s.add(Integer.parseInt(reader.readLine()));
        }

        int maximum = s.last();



        //напишите тут ваш код




        System.out.println(maximum);
    }
}
