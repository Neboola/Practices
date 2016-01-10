package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileNotFoundException;
import java.nio.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaRush.ru
 * Level 14, Lesson 08, Bonus 01
 * <p/>
 * Заполните массив exceptions 10 различными эксепшенами. Первое исключение уже реализовано в методе initExceptions
 * <p/>
 * Date: 03.05.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main( String[] args )
    {
        initExceptions();

        for ( Exception exception : exceptions )
        {
            System.out.println( exception );
        }
    }

    private static void initExceptions()
    {
        try
        {
            float i = 1 / 0;
        }
        catch ( Exception e )
        {
            exceptions.add( e );
        }

        exceptions.add( new NullPointerException() );
        exceptions.add( new IndexOutOfBoundsException() );
        exceptions.add( new IllegalArgumentException() );
        exceptions.add( new FileNotFoundException() );
        exceptions.add( new InstantiationException() );
        exceptions.add( new BufferOverflowException() );
        exceptions.add( new IllegalAccessException() );
        exceptions.add( new NoSuchFieldException() );
        exceptions.add( new BufferUnderflowException() );
    }
}
