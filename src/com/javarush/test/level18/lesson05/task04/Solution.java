package com.javarush.test.level18.lesson05.task04;

import java.io.*;

/**
 * Created by OmniTool on 23.01.2016.
 *
 * 4. Реверс файла

 Считать с консоли 2 имени файла: файл1, файл2.
 Записать в файл2 все байты из файл1, но в обратном порядке
 Закрыть потоки. Не использовать try-with-resources
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(new File(reader.readLine()));
        FileOutputStream out = new FileOutputStream(new File(reader.readLine()));

        byte[] buffer = new byte[in.available()];

        in.read(buffer);

        reverse(buffer);

        out.write(buffer);
        in.close();
        out.close();
        reader.close();
    }

    private static void reverse(byte[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int l = arr.length;
        for (int i = 0; i <= l / 2 ; i++) {
            byte temp = arr[i];
            arr[i] = arr[l - 1 - i];
            arr[l - 1 - i] = temp;
        }
    }

    static void reverse(int[] arr) {

        if (arr == null || arr.length < 1) {
            return;
        }
        System.out.println("Было: ");
        printArr(arr);
        int l = arr.length;
        for (int i = 0; i < l / 2 ; i++) {
            int temp = arr[i];
            arr[i] = arr[l - 1 - i];
            arr[l - 1 - i] = temp;
        }
        System.out.println("Стало: ");
        printArr(arr);
    }

    static void printArr(int[] arr){


        for (int n : arr)
            System.out.print(n + " ");
        System.out.println();

    }


}
