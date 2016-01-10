package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grf1 = new Human("grf1", true, 55);
        Human grf2 = new Human("grf2", true, 55);
        Human grm1 = new Human("grm1", false, 55);
        Human grm2 = new Human("grm2", false, 55);
        Human f1 = new Human("f1", true, 25);

        grf1.children.add(f1);

        grm1.children.add(f1);
        Human m2 = new Human("m2", false, 25);

        grf2.children.add(m2);

        grm2.children.add(m2);
        Human ch1 = new Human("c1", false, 1);

        f1.children.add(ch1);

        m2.children.add(ch1);
        Human ch2 = new Human("c2", false, 1);
        f1.children.add(ch2);
        m2.children.add(ch2);
        Human ch3 = new Human("c3", false, 1);
        f1.children.add(ch3);
        m2.children.add(ch3);

        System.out.println(grf1);
        System.out.println(grf2);
        System.out.println(grm1);
        System.out.println(grm2);
        System.out.println(f1);
        System.out.println(m2);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);

    }

    public static class Human
    {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
