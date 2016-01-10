package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.println("= " + isDateOdd(r.readLine()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static boolean isDateOdd(String date)
    {
        char[] arr = date.toCharArray();
        Map<String, Integer> monthMap = new HashMap<String, Integer>();
        monthMap.put("JANUARY", 31);
        monthMap.put("FEBRUARY", 28); //monthMap.put("FEBRUARY_V", 29);
        monthMap.put("MARCH", 31);
        monthMap.put("APRIL", 30);
        monthMap.put("MAY", 31);
        monthMap.put("JUNE", 30);
        monthMap.put("JULY", 31);
        monthMap.put("AUGUST", 31);
        monthMap.put("SEPTEMBER", 30);
        monthMap.put("OCTOBER", 31);
        monthMap.put("NOVEMBER", 30);
        monthMap.put("DECEMBER", 31);

        ArrayList<State> states = new ArrayList<State>();
        states.add(new MonthState());
        states.add(new DayState());
        states.add(new YearState());
        int i = 0;


        for (char c : arr) {

            if (c == ' ') {
                i++;
                continue;
            }
            states.get(i).symbolProc(c);

        }

        int y = Integer.parseInt(states.get(2).toString());


        String m = states.get(0).toString();
        int daysInM = 0;
        for (Map.Entry<String, Integer> e : monthMap.entrySet() ) {
            if ((e.getKey().equals("FEBRUARY")) && (y % 4 == 0)) {
                daysInM = daysInM + 29;
            }
            daysInM = daysInM + e.getValue();


            if (m.equals(e.getKey())) break;
        }



        int d = Integer.parseInt(states.get(1).toString());

        daysInM = daysInM + d;



        for (State s : states) {

            System.out.print(s + " ");
        }

        return (daysInM + 1) % 2 == 0 ? false : true;



    }

    private static class State
    {
        private ArrayList<Character> data = new ArrayList<Character>();


        public void symbolProc(char c)
        {
            data.add(c);
        }

        @Override
        public String toString()
        {

            StringBuffer b = new StringBuffer();
            for (char c : data) b.append(c);

            return b.toString();
        }




    }
    private static class MonthState extends State
    {



    }
    private static class DayState extends State
    {



    }
    private static class YearState extends State
    {



    }

}
