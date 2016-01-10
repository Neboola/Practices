package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама.
Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму.
Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама.
Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу,
маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        //дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.

        Cat grF = new Cat(reader.readLine());
        Cat grM = new Cat(reader.readLine());
        Cat f = new Cat(reader.readLine(), grF, null);
        Cat m = new Cat(reader.readLine(), null, grM);
        Cat s = new Cat(reader.readLine(), f, m);
        Cat d = new Cat(reader.readLine(), f, m);

        //дедушка, бабушка, папа, мама, сын, дочь

        System.out.println(grF);
        System.out.println(grM);
        System.out.println(f);
        System.out.println(m);
        System.out.println(s);
        System.out.println(d);

    }

    public static class Cat
    {
        private String name;
        private Cat f;
        private Cat m;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat f, Cat m)
        {
            this.name = name;
            this.f = f;
            this.m = m;
        }

        @Override
        public String toString()
        {
            String mo;
            String fa;
            if (m == null)
                mo = ", no mother";
            else
                mo = ", mother is " + m.name;

            if (f == null)
                fa = ", no father";
            else
                fa = ", father is " + f.name;



                return "Cat name is " + name + mo + fa;
        }
    }

}
