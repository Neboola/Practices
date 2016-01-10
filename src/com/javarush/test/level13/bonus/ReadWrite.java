package com.javarush.test.level13.bonus;

import java.io.*;

/**
 Чтение файла

 1. Считать с консоли имя файла.
 2. Вывести в консоль(на экран) содержимое файла.
 3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.

 Запись в файл

 1. Прочесть с консоли имя файла.
 2. Считывать строки с консоли, пока пользователь не введет строку "exit".
 3. Вывести все строки в файл, каждую строчку с новой стороки.
 */
public class ReadWrite
{
    public static void main(String[] args) throws IOException
    {


        BufferedReader in = new BufferedReader(new FileReader("file1"));
        Screen scr = new Screen();



        while (true) {
            String s = in.readLine();
            if (s != null) scr.write(s);
            else break;
        }

        in.close();

        System.out.println();
        System.out.println("Enter file name");
        String fName = scr.read();

        //OutputStream out = new FileOutputStream(fName);
        BufferedWriter out = new BufferedWriter(new FileWriter(fName));

        System.out.println();
        System.out.println("Enter strings");
        while (true) {
            String s = scr.read();
            if (s.equals("exit")) break;
            //out.write(s.charAt(0));
            out.write(s);
            out.write('\n');
        }

        out.close();

        System.out.println();

        BufferedReader inn = new BufferedReader(new FileReader(fName));
        while (true) {
            String s = inn.readLine();
            if (s != null) scr.write(s);
            else break;
        }

        inn.close();

        System.out.println();
        InputStream innn = new FileInputStream(fName);
        while (innn.available() > 0) { System.out.print((char) innn.read());}
        innn.close();





    }

    static class Screen{


        public void write(String s) throws IOException
        {
            System.out.println(s);
        }
        public String read() throws IOException
        {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            return r.readLine();
        }

    }
}
