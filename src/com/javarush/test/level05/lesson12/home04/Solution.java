package com.javarush.test.level05.lesson12.home04;

import java.text.SimpleDateFormat;
import java.util.*;
/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        //Calendar c = Calendar.getInstance();
        //System.out.println(c.get(c.DAY_OF_MONTH) + " " + c.get(c.MONTH) + " " + c.get(c.YEAR));
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd MM yyyy");
        System.out.println(format1.format(d));
    }
}
