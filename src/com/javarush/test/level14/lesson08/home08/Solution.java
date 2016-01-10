package com.javarush.test.level14.lesson08.home08;

/**
 * JavaRush.ru
 * Level 14, Lesson 08, Home 08
 * <p/>
 * 1. Подумать, как связаны интерфейсы Swimable(способен плавать) и Walkable(способен ходить) с классом
 * OceanAnimal(животное океана). <b/>
 * 2. Расставить правильно наследование интерфейсов и класса OceanAnimal. <b/>
 * 3. Подумать, как могут быть связаны классы  Orca(Касатка), Whale(Кит), Otter(Выдра) с классом OceanAnimal. <b/>
 * 4. Расставить правильно наследование между классами Orca, Whale, Otter и классом OceanAnimal. <b/>
 * 5. Подумать, какой класс должен реализовать интерфейс Walkable и добавить интерфей этому классу. <b/>
 * 6. Подумать, какое животное на самом деле умеет плавать, но его класс не реализует интерфейс Swimable.
 * Добавь этомуклассу интерфейс Swimable. <b/>
 * 7. Метод getCurrentAnimal должен быть реализован во всех классах, которые наследуются от OceanAnimal.
 * Подумай, что должен возвращать этот метод.
 * <p/>
 * Date: 03.05.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main( String[] args )
    {
        Swimable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test( Swimable animal )
    {
        animal.swim();
    }

    static interface Walkable
    {
        void walk();
    }

    static interface Swimable
    {
        void swim();
    }

    static abstract class OceanAnimal implements Swimable
    {
        public void swim()
        {
            OceanAnimal currentAnimal = ( OceanAnimal ) getCurrentAnimal();
            currentAnimal.swimming();
        }

        private void swimming()
        {
            System.out.println( getCurrentAnimal().getClass().getSimpleName() + " is swimming" );
        }

        abstract Swimable getCurrentAnimal();
    }

    static class Orca extends OceanAnimal
    {
        @Override
        Swimable getCurrentAnimal()
        {
            return this;
        }
    }

    static class Whale extends OceanAnimal
    {
        @Override
        Swimable getCurrentAnimal()
        {
            return this;
        }
    }

    static class Otter implements Walkable, Swimable
    {
        @Override
        public void swim()
        {
        }

        @Override
        public void walk()
        {
        }
    }
}
