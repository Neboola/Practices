package com.javarush.test.level08.lesson11.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Lina on 05.10.2015.
 */
public class TestDelete
{
    public static void main(String[] args)
    {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 12; i++)
        {
            set.add(i);
        }

        Iterator it = set.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("__________");

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            int n = Integer.parseInt(iterator.next().toString());
            //System.out.println(n);
            if(n % 2 == 0){
                iterator.remove();

            }
        }


        for(int k : set){
            System.out.println(k);
        }






    }
}
