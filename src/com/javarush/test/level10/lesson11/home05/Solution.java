package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        ArrayList<char[]> listOfArr = new ArrayList<char[]>();
        for (String s : list) {
            listOfArr.add(s.toCharArray());
        }
//напишите тут ваш код
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

        for (Character ch : alphabet) {
            map.put(ch, 0);
        }





        for (char[] chars : listOfArr) {
            for (char c : chars) {

                    for (Map.Entry<Character, Integer> e : map.entrySet()) {
                        if (c == e.getKey()) e.setValue(e.getValue() + 1);
                    }

            }
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

    }

}
