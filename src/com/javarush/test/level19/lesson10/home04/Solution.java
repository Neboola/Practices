package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");

    }

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            try(BufferedReader bf = new BufferedReader(new FileReader(br.readLine())))
            {
                while(bf.ready())
                {
                    String s = bf.readLine();
                    String [] a_s = s.split(" ");
                    int k=0;
                    for (int i = 0; i < a_s.length; i++)
                    {
                        if(words.contains(a_s[i])) k++;
                    }
                    if (k==2) System.out.println(s);
                }
            }catch (Exception e){}


        }catch (Exception e){}
    }
}
