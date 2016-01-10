package com.javarush.test.level14.lesson08.home01;

/**
 * JavaRush.ru
 * Level 14, Lesson 08, Home 01
 * <p/>
 * 1. Создать интерфейс Bridge с методом int getCarsCount(). <b/>
 * 2. Создать классы WaterBridge и SuspensionBridge, которые реализуют интерфейс Bridge. <b/>
 * 3. Метод getCarsCount() должен возвращать любое значение типа int. <b/>
 * 4. Метод getCarsCount должен возвращать различные значения для различных классов. <b/>
 * 5. В классе Solution создать публичный метод println(Bridge bridge). <b/>
 * 6. В методе println вывести на консоль значение getCarsCount() для объекта bridge. <b/>
 * 7. Каждый класс и интерфейс должны быть в отдельных файлах.
 * <p/>
 * Date: 01.05.13
 * @author Sergey Kandalintsev
 */
public class Solution {
    public static void main( String[] args ) {
        println( new WaterBridge() );
        println( new SuspensionBridge() );
    }

    public static void println( Bridge bridge ) {
        System.out.println( bridge.getCarsCount() );
    }
}

