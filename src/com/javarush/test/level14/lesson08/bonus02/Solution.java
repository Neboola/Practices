package com.javarush.test.level14.lesson08.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * JavaRush.ru
 * Level 14, Lesson 08, Bonus 04
 * <p/>
 * Наибольший общий делитель (НОД) <b/>
 * Ввести с клавиатуры 2 целых положительных числа. <b/>
 * Вывести в консоль наибольший общий делитель. <b/>
 * Например, числа 24 и 16. <b/>
 * Результат будет 8, т.к. и 24 и 16 нацело делятся на 8 - максимальное из всех делителей.
 * <p/>
 * Date: 03.05.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main( String[] args ) throws Exception
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        int m = Integer.parseInt( reader.readLine() );
        int n = Integer.parseInt( reader.readLine() );

        System.out.println( greatestCommonDivisor( m, n ) );
    }

    /**
     * Возвращает наибольший общий делитель (НОД) двух целых положительных чисел. НОД вычисляется с помощью
     * бинарного алгоритма Евклида (см. http://en.wikipedia.org/wiki/Binary_GCD_algorithm).
     *
     * @param   m  Первое число
     * @param   n  Второе число
     * @return  НОД(m, n)
     */
    private static int greatestCommonDivisor( int m, int n )
    {
        // Базовый случай:
        if ( m == n )
        {
            return m;
        }
        if ( m == 0 )
        {
            return n;
        }
        if ( n == 0 )
        {
            return m;
        }

        // Рекурсивный случай:
        if ( ( ~m & 1 ) == 1 ) // m четное
        {
            if ( ( n & 1 ) == 1 ) // n четное
            {
                return greatestCommonDivisor( m >> 1, n );
            }
            else // m и n четные
            {
                return greatestCommonDivisor( m >> 1, n >> 1 ) << 1;
            }
        }
        if ( ( ~n & 1 ) == 1 ) // m нечетное, n четное
        {
            return greatestCommonDivisor( m, n >> 1 );
        }

        // уменьшение большего аргумента:
        if ( m > n )
        {
            return greatestCommonDivisor( ( m - n ) >> 1, n );
        }

        return greatestCommonDivisor( ( n - m ) >> 1, m );
    }

// Итеративный вариант:
//    private static int greatestCommonDivisor( int m, int n )
//    {
//        while ( m != 0 && n != 0 )
//        {
//            if (m > n)
//                m %= n;
//            else
//                n %= m;
//        }
//
//        return m + n;
//    }
}
