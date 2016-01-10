package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandf1 = new Human("John", true, 77);
        Human grandm1 = new Human("Jane", false, 76);
        Human grandf2 = new Human("John", true, 75);
        Human grandm2 = new Human("Jane", false, 74);
        Human father = new Human("Tim", true, 45, grandf1, grandm1);
        Human moter = new Human("Kat", false, 34, grandf2, grandm2);
        Human child1 = new Human("Alex", true, 5, father, moter);
        Human child2 = new Human("Lex", true, 3, father, moter);
        Human child3 = new Human("Lexie", false, 1, father, moter);

        System.out.println(grandf1);
        System.out.println(grandm1);
        System.out.println(grandf2);
        System.out.println(grandm2);
        System.out.println(father);
        System.out.println(moter);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name,
                boolean sex,
                int age){
            this.name = name;
            this.sex = sex;
            this.age = age;

        }

        Human(String name,
              boolean sex,
              int age,
              Human father,
              Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;

        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
