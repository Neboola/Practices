package com.javarush.test.level13.lesson02.task09;

/**
 * Created by Neboola on 05.12.2015.
 */
public class Solution
{

    public static void main(String[] args)
    {
        Runable m = new Runner(10.8);
        Runable r = new Runner(4.2);
        System.out.println("my speed = " + m.speed());
        System.out.println("my speed depending another runner = " + m.speed(r));
    }

    interface Movable {
        Double speed();
    }
    interface Runable extends Movable {
        Double speed(Runable r);
    }
    static class Runner implements Runable {
        Double movement;
        Runner (Double movement) {
            this.movement = movement;
        }


        @Override
        public Double speed(Runable r)
        {
            return speed() - r.speed();
        }

        @Override
        public Double speed()
        {
            return movement;
        }
    }
}
