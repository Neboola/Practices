package com.javarush.test.level17.lesson10.home09;

/**
 * Created by OmniTool on 21.01.2016.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. выбросить исключение CorruptedDataException
4.2. очистить allLines от данных
Сигнатуру метода main не менять
*/

// 1 и 2 готово
public class SolutionTwo {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();

        writeInList(fileOne, allLines);
        writeInList(fileTwo, forRemoveLines);
    }



    public void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines) ) {
            allLines.removeAll(forRemoveLines)  ;
            return;
        }

        for (String s : forRemoveLines) {
            if (!allLines.contains(s)){
                allLines.clear();
                throw  new CorruptedDataException();
            }

        }
    }

    public static void writeInList(String file, List<String> list) throws FileNotFoundException
    {
        BufferedReader in = new BufferedReader(new FileReader(file));
        try{
            String s;
            while((s = in.readLine()) != null){
                String[] strings = s.split(" ");

                for (String x : strings){
                    list.add(x);

                }
            }
        }catch (Exception e){

        }


    }
}
