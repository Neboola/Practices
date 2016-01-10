package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        int age;
        String name;
        double money;
        Human mother;
        Human father;
        boolean isMale;

        public Human(int age)
        {
            this.age = age;
        }

        public Human(String name)
        {
            this.name = name;
        }

        public Human(double money)
        {
            this.money = money;
        }

        public Human(Human mother)
        {
            this.mother = mother;
        }

        public Human(Human father, Human mother)
        {
            this.father = father;
            this.mother = mother;
        }

        public Human(boolean isMale)
        {
            this.isMale = isMale;
        }

        public Human(int age, String name)
        {
            this.age = age;
            this.name = name;
        }

        public Human(int age, String name, boolean isMale)
        {
            this.age = age;
            this.name = name;
            this.isMale = isMale;
        }

        public Human(int age, String name, boolean isMale, Human mother)
        {
            this.age = age;
            this.name = name;
            this.isMale = isMale;
            this.mother = mother;
        }

        public Human(int age, String name, boolean isMale, Human mother, Human father)
        {
            this.age = age;
            this.name = name;
            this.isMale = isMale;
            this.mother = mother;
            this.father = father;
        }
    }
}
