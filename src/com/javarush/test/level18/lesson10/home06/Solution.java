package com.javarush.test.level18.lesson10.home06;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by OmniTool on 25.01.2016.
 *
 * 6. Встречаемость символов

 Программа запускается с одним параметром - именем файла, который содержит английский текст.
 Посчитать частоту встречания каждого символа.
 Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
 Вывести на консоль отсортированный результат:
 [символ1] частота1
 [символ2] частота2
 Закрыть потоки. Не использовать try-with-resources

 Пример вывода:
 , 19
 - 7
 f 361
 */
public class Solution {

 public static void main(String[] args) throws IOException{
  String filename = args[0];
  FileInputStream fis = new FileInputStream(filename);

  int maxASCII = 0;

  while (fis.available() > 0) {
   int symbol = fis.read();
   if (symbol > maxASCII) maxASCII = symbol;
  }
  //System.out.println("maxASCII = " + maxASCII);
  int[] arr = new int[maxASCII+1];

  fis.close();

  fis = new FileInputStream(filename);
  while (fis.available() > 0) {
   arr[fis.read()]++;
  }


  for (int i = 0; i < arr.length; i++) {
   if (arr[i] > 0)
    System.out.println((char)i + " " + arr[i]);
  }


  fis.close();




 }

}
