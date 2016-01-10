package com.javarush.test.level14.lesson4;

/**
 * Created by Neboola on 06.12.2015.
 3. Food

 1. Реализовать интерфейс Selectable в классе Food.
 2. Метод onSelect() должен писать в консоль "food is selected".
 3. Подумай, какие методы можно вызвать для переменной food и какие для selectable.
 4. В методе foodMethods вызови методы onSelect, eat, если это возможно.
 5. В методе selectableMethods вызови методы onSelect, eat, если это возможно.
 6. Явное приведение типов не использовать.
 */
public class Solution
{
    public static void main(String[] args) {

        Food f = new Food();
        f.foodMethods();
    }

    private static class Food implements Selectable {
        void foodMethods() {
            onSelect();
            eat();
        }
        void eat(){
            System.out.println("omnomnom");
        }
        public void onSelect() {
            System.out.println("food is selected");
        }


    }

    interface Selectable {
        void onSelect();
    }
}
