package com.javarush.test.level17.lesson10.bonus01;

import com.javarush.test.level13.bonus02.RepkaStory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by OmniTool on 21.01.2016.
 *
 * 1. CRUD

 Задача: CrUD - Create, Update, Delete
 Программа запускается с одним из следующих наборов параметров:
 -c name sex bd
 -u id name sex bd
 -d id
 -i id
 Значения параметров:
 name - имя, String
 sex - пол, "м" или "ж", одна буква
 bd - дата рождения в следующем формате 15/04/1990
 -с - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
 -u - обновляет данные человека с данным id
 -d - производит логическое удаление человека с id
 -i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

 id соответствует индексу в списке
 Все люди должны храниться в allPeople
 Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

 Пример параметров: -c Миронов м 15/04/1990
 */
public class MySolution { //слепое решение
 // для упрощения будем вводить параметры в консоль и проверять результат немедленно

 private static List<Person> allPeople = new ArrayList<>();

 public static void main(String[] args) throws IOException {

  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  String command = "";

  while (!command.equals("exit")) {
   command = reader.readLine();
   try {
    execute(command);
    printList();
   } catch (IncorrectCommandException e) {
    System.out.println(e.getMessage());
    printHelp();
   } catch (NoSuchPersonExeption | IncorrectDateException e) {
    System.out.println(e.getMessage());
    System.out.println();
   }

  }

 }

 private static void printHelp() {
  System.out.println("Help:");
  System.out.println("-c name sex bd");
  System.out.println("-u id name sex bd");
  System.out.println("-d id");
  System.out.println("-i id");
  System.out.println();
 }

 private static void execute(String command) throws IncorrectCommandException, NoSuchPersonExeption, IncorrectDateException {
  String[] params = command.split(" ");
  switch (params[0]) {
   case "-c" :
    if (params.length < 4) {
     throw new IncorrectCommandException("Incorrect number of parameters");
    }
    if (!(params[2].equals("m") || params[2].equals("w"))) {
     throw new IncorrectCommandException("Incorrect parameter. Set the second parameter: 'm' or 'w'");
    }
    System.out.println("Create:");
    create(params[1], params[2], params[3]);
    return;
   case "-u" :
    if (params.length < 5) {
     throw new IncorrectCommandException("Incorrect number of parameters");
    }
    if (!(params[2].equals("m") || params[2].equals("w"))) {
     throw new IncorrectCommandException("Incorrect parameter. Set the third parameter: 'm' or 'w'");
    }
    System.out.println("Update:");
    update(params[1], params[2], params[3], params[4]);
    return;
   case "-d" :
    if (params.length < 2) {
     throw new IncorrectCommandException("Incorrect number of parameters");
    }
    System.out.println("Delete:");
    delete(params[1]);
    return;
   case "-i" :
    if (params.length < 2) {
     throw new IncorrectCommandException("Incorrect number of parameters");
    }
    System.out.println("Info:");
    info(params[1]);
    return;
   default :
    throw new IncorrectCommandException("Incorrect command");
  }
 }

 private static void printList() {
  System.out.println();
  for (Person p : allPeople) {
   System.out.println("Person " + p);
  }
  System.out.println();
 }

 private static boolean isValid(String value, String datePattern) {

  if (value == null || datePattern == null || datePattern.length() <= 0) {
   return false;
  }

  SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
  formatter.setLenient(false);


  try {
   formatter.parse(value);
  } catch (ParseException e) {
   return false;
  }

  return true;
 }

 private static void create(String name, String sex, String bd) throws IncorrectDateException {
  if (!isValid(bd, "dd/MM/yyyy")) throw new IncorrectDateException("Date is not correct. It should be dd/mm/yyyy");
  Person p = new Person(name, sex, bd);
  allPeople.add(p);
  System.out.println("New person : " + p.getId() + " has been added");
 }

 private static void update(String id, String name, String sex, String bd) throws NoSuchPersonExeption {


   Person p = findPerson(id);
   p.setName(name);
   p.setSex(sex);
   p.setBd(bd);
   System.out.println("Person " + id + " has been edited");

 }

 private static void delete(String id) throws NoSuchPersonExeption {

   Person p = findPerson(id);
   allPeople.remove(p);
   System.out.println("Person " + id + " has been deleted");

 }

 private static void info(String id) throws NoSuchPersonExeption {

   Person p = findPerson(id);

   System.out.println("Person " + p);

 }

 private static Person findPerson(String id) throws NoSuchPersonExeption {
  for (Person p : allPeople) {
   if (p.getId().equals(id)) {
    return p;
   }
  }
  throw new NoSuchPersonExeption("ID is not correct");
 }

 private static class Person {
  private static int lastID = 0;
  private String id;
  private String name;
  private String sex;
  private String bd;

  public void setName(String name) {
   this.name = name;
  }

  public void setSex(String sex) {
   this.sex = sex;
  }

  public void setBd(String bd) {
   this.bd = bd;
  }

  public String getId() {
   return id;
  }

  public String getName() {
   return name;
  }

  public String getSex() {
   return sex;
  }

  public String getBd() {
   return bd;
  }

  public Person(String name, String sex, String bd) {
   id = String.valueOf((lastID++));
   this.name = name;
   this.sex = sex;
   this.bd = bd;
  }

  @Override
  public String toString() {
   String bd = "";
   SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
   try {
    Date date = formatter1.parse(getBd());
    SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    bd = formatter2.format(date);
   } catch (ParseException e) {
    e.printStackTrace();
   }
   return getId() + " : " + getName() + " - " + getSex() + " - " + bd;
  }
 }
}
