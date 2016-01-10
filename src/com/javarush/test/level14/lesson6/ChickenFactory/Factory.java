package com.javarush.test.level14.lesson6.ChickenFactory;

/**
 * Created by Neboola on 08.12.2015.
 */
public class Factory {

    public static void main(String[] args) {
    try{
        Hen hen;
        hen = getHen("Russia");
        System.out.println(hen.getDescription());
        hen = getHen("Moldova");
        System.out.println(hen.getDescription());
        hen = getHen("Belarus");
        System.out.println(hen.getDescription());
        hen = getHen("Ukrain");
        System.out.println(hen.getDescription());
        hen = getHen("USA");
        System.out.println(hen.getDescription());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    }

    static Hen getHen(String country) throws Exception{
        Hen hen = null;
        //while (hen == null) {
            switch (country) {
                case "Russia" :
                    hen = new RussianHen();
                    break;
                case "Ukrain" :
                    hen = new UkrainianHen();
                    break;
                case "Moldova" :
                    hen = new MoldovanHen();
                    break;
                case "Belarus" :
                    hen = new BelarusianHen();
                    break;
                default:
                    throw new Exception("No chicken for you!");


            }
        //}

        return hen;

    }
}
