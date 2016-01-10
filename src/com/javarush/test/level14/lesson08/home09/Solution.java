package com.javarush.test.level14.lesson08.home09;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaRush.ru
 * Level 14, Lesson 08, Bonus 09
 * <p/>
 * 1. Реализуйте метод getAmount в классе Money: <b/>
 * 1.1 Подумайте, какого типа нужно создать приватную переменную, если метод getAmount будет ее возвращать. <b/>
 * 1.2 Создайте приватную переменную этого типа и верните ее в методе getAmount. <b/>
 * 1.3 В конструкторе присвойте ей значение, полученное параметром. <b/>
 * 2. В отдельном файле создайте класс Hrivna. <b/>
 * 3. Наследуйте класс Hrivna от класса Money. <b/>
 * 4. В классе Hrivna реализуйте метод getCurrencyName, который возвращает "HRN". <b/>
 * 5. В отдельном файле создайте класс USD. <b/>
 * 6. Наследуйте класс USD от класса Money. <b/>
 * 7. В классе USD реализуйте метод getCurrencyName, который возвращает "USD". <b/>
 * 8. Подумайте, объекты каких классов можно добавить в список(лист) allMoney. <b/>
 * 9. Добавить в конструктор класса Person заполнение листа allMoney объектами всех возможных классов.
 * <p/>
 * Date: 03.05.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main( String[] args )
    {
        Person ivan = new Person( "Иван" );
        for ( Money money : ivan.getAllMoney() )
        {
            System.out.println( ivan.name + " имеет заначку в размере " + money.getAmount() + " "
                    + money.getCurrencyName() );
        }
    }

    static class Person
    {
        public String name;

        Person( String name )
        {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            allMoney.add( new Hrivna( 0.01 ) );
            allMoney.add( new USD( 1000000000 ) );
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney()
        {
            return allMoney;
        }
    }
}
