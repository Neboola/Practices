package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] ch = s.toCharArray();
        boolean f = true;





        for (int i = 0; i < ch.length; i++)
        {
            String ss = String.valueOf(ch[i]);



            if (f && Character.isLetter(ch[i])){
                ch[i] = String.valueOf(ch[i]).toUpperCase().charAt(0);
                f = false;

            }

            if (ss.equals(" ")){

                   f = true;

            }
        }
        for (int i = 0; i < ch.length; i++)
        {
            System.out.print(ch[i]);
        }



        //напишите тут ваш код
    }


}
