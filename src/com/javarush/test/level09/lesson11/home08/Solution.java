package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> arr = new ArrayList<int[]>();
        //5
        arr.add(new int[] {5, 5, 5, 5, 5});
        //2
        arr.add(new int[] {2, 2});
        //4
        arr.add(new int[] {4, 4, 4, 4});
        //7
        arr.add(new int[] {7, 7, 7, 7, 7, 7, 7});
        //0
        arr.add(new int[] {});

        return arr;

    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
