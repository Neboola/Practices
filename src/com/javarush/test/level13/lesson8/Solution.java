package com.javarush.test.level13.lesson8;

import java.io.*;

/**
 * Created by Neboola on 05.12.2015.
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String fileNameIn = "file1", fileNameOut = "file2";
        InputStream inStream = new FileInputStream(fileNameIn);
        OutputStream outStream = new FileOutputStream(fileNameOut);

        while (inStream.available() > 0) {
            int data = inStream.read();
            outStream.write(data);
        }

        inStream.close();
        outStream.close();

    }
}
