package com.javarush.test.level13.bonus02;

import java.util.ArrayList;
import java.util.List;

/**
 2. Сказка Репка.

 Задача:
 1. Реализовать интерфейс RepkaItem в классе Person.
 2. В классе Person реализовать метод pull(Person person), который выводит фразу типа ' за '. Пример "Бабка за Дедку".
 3. Исправить логическую ошибку цикла в методе tell класса RepkaStory.
 4. Выполнить метод main и наслаждаться сказкой!
 */
public class RepkaStory
{
    public static void main(String[] args)
    {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));
        RepkaStory.tell(plot);
    }

    static void tell(List<Person> plot) {
        for (int i = 0; i < plot.size() - 1; i++) {
            plot.get(i+1).pull(plot.get(i));
        }
    }


    public static class Person implements RepkaItem
    {
        private String name;
        private String namePadezh;

        public Person(String name, String namePadezh)
        {
            this.name = name;
            this.namePadezh = namePadezh;
        }

        @Override
        public String getNamePadezh() {
            return namePadezh;
        }

        public void pull(Person person) {
            System.out.println(name + " за " + person.namePadezh);
        }
    }

    interface RepkaItem
    {
        String getNamePadezh();

    }
}
