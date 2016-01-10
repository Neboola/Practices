package com.javarush.test.level14.lesson08.home04;

/**
 * JavaRush.ru
 * Level 14, Lesson 08, Home 04
 * <p/>
 * 1. Напишите реализацию метода printMainInfo, чтобы: <b/>
 * 1.1 Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw <b/>
 * 1.2 Если в метод передают объект типа Movable, у этого объекта вызывался метод move <b/>
 * 2. Метод main менять нельзя.
 * <p/>
 * Date: 01.05.13
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main( String[] args )
    {
        Object obj = new Circle();
        Movable movable = ( Movable ) obj;
        Drawable drawable = new Rectangle();

        printMainInfo( drawable );
        printMainInfo( movable );
    }

    public static void printMainInfo( Object object )
    {
        if ( object instanceof Drawable )
        {
            ( ( Drawable ) object ).draw();
        }
        if ( object instanceof Movable )
        {
            ( ( Movable ) object ).move();
        }
    }

    static interface Movable
    {
        void move();
    }

    static class Circle implements Movable
    {

        public void draw()
        {
            System.out.println( "can be drawn" );
        }

        public void move()
        {
            System.out.println( "can be moved" );
        }
    }

    static interface Drawable
    {
        void draw();
    }

    static class Rectangle implements Drawable
    {
        public void draw()
        {
            System.out.println( "can be drawn" );
        }

        public void move()
        {
            System.out.println( "can be moved" );
        }
    }
}
