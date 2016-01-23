package com.javarush.test.level18.lesson03.task04;

import java.io.*;

/**
 * Created by OmniTool on 22.01.2016.
 *
 * 4. Самые редкие байты

 Ввести с консоли имя файла
 Найти байт или байты с минимальным количеством повторов
 Вывести их на экран через пробел
 Закрыть поток ввода-вывода
 */
public class MySolution { //слепое решение

 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  String filename = r.readLine();
  FileInputStream fis = new FileInputStream(new File(filename));
  int size = 0;
  while (fis.available() > 0) {
   int bayt = fis.read();
   System.out.println("считано: " + bayt + " - " + (char)bayt);
   if (size < bayt) size = bayt;
  }
  int[] arr = new int[size + 1];
  fis = new FileInputStream(new File(filename));
  while (fis.available() > 0) {
   int symbol = fis.read();
   arr[symbol]++;
  }
  int min = Character.MAX_VALUE;
  for (int b : arr) {
   if ((min > b) && (b != 0)) min = b;
  }

  for (int i = 0; i < arr.length; i++) {
   if (arr[i] == min) System.out.print((char)i + "(" + arr[i] + "раз)" + " ");
  }
  fis.close();
  r.close();


 }
}
