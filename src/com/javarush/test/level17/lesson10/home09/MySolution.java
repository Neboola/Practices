package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by OmniTool on 21.01.2016.
 *
 * 9. Транзакционность

 Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
 1. Считать с консоли 2 имени файла
 2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
 В методе joinData:
 3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
 4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
 4.1. очистить allLines от данных
 4.2. выбросить исключение CorruptedDataException
 Метод joinData должен вызываться в main. Все исключения обработайте в методе main.

 *
 * http://info.javarush.ru/dotfinal/2014/08/21/com-javarush-test-level17-lesson10-home09.html
 * "Lansky 13 октября 2015, 17:27 0
 идиотизм, а не текст задачи.
 Зачем писать «транзакционный», если этого не требует валидатор?
 Сделал все верно, а в методе main еще обрабатывал исключение, т.е. восстанавливал список allLines из временной копии,
 и задача НЕ ПРОХОДИЛА ТОЛЬКО ИЗ-ЗА ЭТОГО! Убрал транзакционность — все прошло."

 */
public class MySolution {  //слепое решение

    private static List<String> allLines = new ArrayList<String>();
    private static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileAllLines = reader.readLine();
        String fileForRemoveLines = reader.readLine();

        readFile(fileAllLines, allLines);
        readFile(fileForRemoveLines, forRemoveLines);

        printList(allLines);
        printList(forRemoveLines);

        try {
            System.out.println();
            joinData();
            System.out.println("нужные строки удалены");
        } catch (CorruptedDataException e) {
            System.out.println("все строки удалены");
        }

        printList(allLines);
        printList(forRemoveLines);

    }

    private static void readFile (String fromFile, List<String> toList) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fromFile));
        String line;
        while ( (line = reader.readLine()) != null ) {
            toList.add(line);
        }
        reader.close();
    }

    private static void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            System.out.println("все строки найдены");
        } else {
            allLines.clear();
            System.out.println("найдены не все строки");
            throw new CorruptedDataException();
        }
    }

    private static void printList(List<String> list) {
        System.out.println();
        for (String s : list) System.out.println(s);

    }

}
