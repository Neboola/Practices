package com.javarush.test.level18.lesson03.task05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by OmniTool on 22.01.2016.
 */
public class Test { //слепое решение
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                list.add(j);
            }
        }

        for (Integer i : list) System.out.print(i + " ");
        System.out.println();

        Set<Integer> set = new HashSet<>();
        set.addAll(list);

        for (Integer i : set) System.out.print(i + " ");
        System.out.println();

    }
}
