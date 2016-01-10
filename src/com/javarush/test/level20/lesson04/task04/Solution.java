package com.javarush.test.level20.lesson04.task04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {
    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
        public static void serializeStatic(ObjectOutputStream oos) throws IOException{
            oos.writeChars(staticString);
        }
        public static void deserializeStatic(ObjectInputStream ois) throws IOException
        {
            staticString=ois.readLine();
        }
    }
}
