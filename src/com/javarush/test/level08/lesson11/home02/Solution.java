package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();

        //напишите тут ваш код
        for (int i = 0; i < 4; i++)
        {
            result.add(new Cat());
        }

        return result;
    }

    public static Set<Dog> createDogs()
    {

        //напишите тут ваш код
        HashSet<Dog> result = new HashSet<Dog>();
        for (int i = 0; i < 3; i++)
        {
            result.add(new Dog());
        }

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        //напишите тут ваш код
        Set<Object> result = new HashSet<Object>();
        result.addAll(cats);
        result.addAll(dogs);
        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        //напишите тут ваш код
        Iterator it = pets.iterator();

        while (it.hasNext()){
        Object o = it.next();
        Iterator it1 = cats.iterator();
            while (it1.hasNext()){
                Object o1 = it1.next();
                if (o.equals(o1)){
                    it.remove();

                }
            }



        }
    }

    public static void printPets(Set<Object> pets)
    {
        //напишите тут ваш код
        for (Object s : pets){
            System.out.println(s);
        }
        System.out.println("___________");
    }

    //напишите тут ваш код
    public static class Cat{

    }

    public static class Dog{

    }
}
