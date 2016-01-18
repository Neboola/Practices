package com.javarush.test.level17.lesson04.task05;

/**
 * Created by OmniTool on 18.01.2016.
 */

/* МВФ
Singleton паттерн - синхронизация в методе
IMF - это Международный Валютный Фонд
Внутри метода getFund создайте синхронизированный блок
Внутри синхронизированного блока инициализируйте переменную imf так, чтобы метод getFund всегда возвращал один и тот же объект
*/

public class Solution {

    public static void main(String[] args) {


        new ThreadIMF().start();

        new ThreadIMF().start();

        new ThreadIMF().start();


    }

    public static class IMF {

        private static IMF imf;

        static {

            //synchronized (Solution.class){

                imf = new IMF();
            //}
        }


        public static IMF getFund() {
            //add your code here - добавь код тут
            //synchronized (IMF.class)
            //{
                return imf;
            //}
        }
        //public IMF getImf() {return imf;}

        private IMF() {
        }
    }

    private static class ThreadIMF extends Thread {
        @Override
        public void run() {
            IMF imf1 = new IMF();
            System.out.println(imf1.getFund());
            IMF imf2 = new IMF();
            System.out.println(imf2.getFund());
            IMF imf3 = new IMF();
            System.out.println(imf3.getFund());
        }
    }
}
