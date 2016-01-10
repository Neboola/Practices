package com.javarush.test.level14.lesson08.home07;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaRush.ru
 * Level 14, Lesson 08, Home 07
 * <p/>
 * Клининговый центр <b/>
 * 1. Реализовать метод cleanAllApartaments. Для каждого объекта из apartaments: <b/>
 * 2. для однокомнатных квартир (Apt1Room) вызвать метод clean1Room, т.е. если объект типа Apt1Room, то вызвать у
 * него метод clean1Romm. <b/>
 * 3. для двухкомнатных квартир (Apt2Room) вызвать метод clean2Rooms, т.е. если объект типа Apt2Room, то вызвать у
 * него метод clean2Rooms. <b/>
 * 4. для трехкомнатных квартир (Apt3Room) вызвать метод clean3Rooms, т.е. если объект типа Apt3Room, то вызвать у
 * него метод clean3Rooms.
 * <p/>
 * Date: 03.05.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main( String[] args )
    {
        List<Apartament> apartaments = new ArrayList<Apartament>();
        apartaments.add( new Apt1Room() );
        apartaments.add( new Apt2Room() );
        apartaments.add( new Apt3Room() );

        cleanAllApartaments( apartaments );
    }

    public static void cleanAllApartaments( List<Apartament> apartaments )
    {
        for ( Apartament apartament : apartaments )
        {
            if ( apartament instanceof Apt1Room )
            {
                ( ( Apt1Room ) apartament ).clean1Room();
            }
            if ( apartament instanceof Apt2Room )
            {
                ( ( Apt2Room ) apartament ).clean2Rooms();
            }
            if ( apartament instanceof Apt3Room )
            {
                ( ( Apt3Room ) apartament ).clean3Rooms();
            }
        }
    }

    static interface Apartament
    {
    }

    static class Apt1Room implements Apartament
    {
        void clean1Room()
        {
            System.out.println( "1 room is cleaned" );
        }
    }

    static class Apt2Room implements Apartament
    {
        void clean2Rooms()
        {
            System.out.println( "2 rooms are cleaned" );
        }
    }

    static class Apt3Room implements Apartament
    {
        void clean3Rooms()
        {
            System.out.println( "3 rooms are cleaned" );
        }
    }
}
