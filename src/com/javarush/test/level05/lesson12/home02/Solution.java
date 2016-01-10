package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1 = new Man("Dan", 34);
        Man man2 = new Man("Mik", "34th Avenu, 22");
        Woman woman1 = new Woman(20, "Hospital");
        Woman woman2 = new Woman(0);

        //выведи их на экран тут

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    //добавьте тут ваши классы
    public static class Man{
        public String name;
        public int age;
        public String address;

        public Man(){
            this.name = "Name";
            this.age = 21;
            this.address = "Address";
        }

        public Man(int age){
            this.name = "Name";
            this.age = age;
            this.address = "Address";
        }

        public Man(String name){
            this.name = name;
            this.age = 21;
            this.address = "Address";
        }

        public Man(String name, int age){
            this.name = name;
            this.age = age;
            this.address = "Address";
        }

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Man(int age, String address){
            this.name = "Name";
            this.age = age;
            this.address = address;
        }

        public Man(String name, String address){
            this.name = name;
            this.age = 21;
            this.address = address;
        }

        public String toString(){
            return (this.name + " " + this.age + " " + this.address);
        }


    }

    public static class Woman{
        public String name;
        public int age;
        public String address;

        public Woman(){
            this.name = "Name";
            this.age = 21;
            this.address = "Address";
        }

        public Woman(int age){
            this.name = "Name";
            this.age = age;
            this.address = "Address";
        }

        public Woman(String name){
            this.name = name;
            this.age = 21;
            this.address = "Address";
        }

        public Woman(String name, int age){
            this.name = name;
            this.age = age;
            this.address = "Address";
        }

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Woman(int age, String address){
            this.name = "Name";
            this.age = age;
            this.address = address;
        }

        public Woman(String name, String address){
            this.name = name;
            this.age = 21;
            this.address = address;
        }

        public String toString(){
            return (name + " " + age + " " + address);
        }


    }
}
