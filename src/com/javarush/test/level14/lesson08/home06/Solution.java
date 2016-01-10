package com.javarush.test.level14.lesson08.home06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * JavaRush.ru
 * Level 14, Lesson 08, Home 03
 * <p/>
 * Расширение функционала по аналогии, чтение с консоли: <b/>
 * 1. Разобраться, что программа умеет делать. <b/>
 * 2. Все классы должны быть внутри класса Solution. <b/>
 * 3. Добавить классы Cartoon, Triller. <b/>
 * 4. Разобраться, как мы получаем объект класса SoapOpera по ключу "soapOpera". <b/>
 * Аналогично получению объекта SoapOpera сделать: <b/>
 * 5. Добавить в MovieFactory.getMovie получение объекта Cartoon для ключа "cartoon". <b/>
 * 6. Добавить в MovieFactory.getMovie получение объекта Triller для ключа "triller". <b/>
 * 7. Считать с консоли несколько ключей (строк). <b/>
 * 7.1 Ввод заканчивается, как только вводится строка не совпадающая с одной из: "cartoon", "triller", "soapOpera". <b/>
 * 8. Создать переменную movie класса Movie и для каждой введенной строки(ключа): <b/>
 * 8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie. <b/>
 * 8.2 вывести на экран movie.getClass().getSimpleName().
 * <p/>
 * Date: 01.05.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main( String[] args ) throws Exception
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        Movie movie;
        String key;

        for ( key = reader.readLine(); isValidKey( key ); key = reader.readLine() )
        {
            movie = MovieFactory.getMovie( key );
            System.out.println( movie.getClass().getSimpleName() );
        }
    }

    static class MovieFactory
    {
        static Movie getMovie( String key )
        {
            Movie movie = null;

            if ( "soapOpera".equals( key ) )
            {
                movie = new SoapOpera();
            }
            if ( "cartoon".equals( key ) )
            {
                movie = new Cartoon();
            }
            if ( "triller".equals( key ) )
            {
                movie = new Triller();
            }

            return movie;
        }
    }

    static abstract class Movie
    {
    }

    static class SoapOpera extends Movie
    {
    }

    static class Cartoon extends Movie
    {
    }

    static class Triller extends Movie
    {
    }

    private static boolean isValidKey( String key )
    {
        return "soapOpera".equals( key ) || "cartoon".equals( key ) || "triller".equals( key );
    }
}
