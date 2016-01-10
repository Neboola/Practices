package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter
{
    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public void write(char[] cbuf) throws IOException
    {
        System.out.println(cbuf);
        super.write(cbuf);
    }

    @Override
    public void write(String str) throws IOException
    {
        super.write(str);
    }

    @Override
    public Writer append(CharSequence csq) throws IOException
    {
        return super.append(csq);
    }

    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException
    {
        return super.append(csq, start, end);
    }

    @Override
    public Writer append(char c) throws IOException
    {
        return super.append(c);
    }
}
