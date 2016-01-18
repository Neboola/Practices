package com.javarush.test.level17.lesson04.task03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OmniTool on 18.01.2016.
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        printList(list);

        for (int i = 0; i < 5; i++) {
            list.add("First");
        }
        printList(list);

        list.add(4, "Second");
        printList(list);

        list.remove(5);
        printList(list);

        for (int i = 0; i < 7; i++) {
            System.out.println(chooseRandomOne(7));
        }




    }

    private static void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("size = " + list.size());
        System.out.println();

    }

    private static int chooseRandomOne(int number) {
        return (int) (Math.random() * number);
    }


}
