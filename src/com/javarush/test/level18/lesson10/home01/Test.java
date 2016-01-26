package com.javarush.test.level18.lesson10.home01;

/**
 * Created by OmniTool on 25.01.2016.
 */
public class Test {

    public static void main(String[] args) {
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println((byte)i + " " + i);
        }
        System.out.println();
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.println((byte)i + " " + i);
        }
        System.out.println();
        for (char i = 91; i <= 96; i++) {
            System.out.println((byte)i + " " + i);
        }
    }

}
