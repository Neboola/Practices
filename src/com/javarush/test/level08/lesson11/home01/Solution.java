package com.javarush.test.level08.lesson11.home01;


import java.util.*;


/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. пункт 3
        Iterator it = cats.iterator();
        Cat cat = (Cat) it.next();
        cats.remove(cat);

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //напишите тут ваш код. пункт 2
        Set<Cat> cats = new HashSet<Cat>();

        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());

        return cats;
    }

    public static void printCats(Set<Cat> cats)
    {
        // пункт 4
        Iterator it = cats.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
    }

    // пункт 1
    public static class Cat{

    }

}
