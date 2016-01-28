package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by OmniTool on 25.01.2016.
 *
 * 8. Нити и байты

 Читайте с консоли имена файлов, пока не будет введено слово "exit"
 Передайте имя файла в нить ReadThread
 Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
 где параметр String - это имя файла, параметр Integer - это искомый байт.
 Закрыть потоки. Не использовать try-with-resources
 */
public class Solution { // проблема, если решать через map - теряется информация, если в файле есть несколько байт с одинаково большой частотой.
                        // Решаем через замену параметра Integer на список List<Integer>, т.к. байт с максимальной частотой может быть несколько.

    private static Map<String, List<Integer>> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ExecutorService exec = Executors.newCachedThreadPool();

        while (true) {
            String filename = r.readLine();
            if (filename.equals("exit")) {
                r.close();
                exec.shutdown();
                printResultMap();
                return;
            }
            exec.execute(new ReadThread(filename));
        }    
    }

    private static synchronized void writeToMap(String filename, List<Integer> baits) {
        resultMap.put(filename, baits);
    }

    private static synchronized void printResultMap() {
        for (Map.Entry<String, List<Integer>> pair : resultMap.entrySet()) {
            System.out.print(pair.getKey() + " ");
            for (Integer bait : pair.getValue())
                System.out.print(bait + " ");
            System.out.println();
        }
    }

    private static class ReadThread extends Thread {
        public ReadThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String filename = getName();
            try {
                FileInputStream fis = new FileInputStream(filename);
                int maxBait = 0;
                while (fis.available() > 0) {
                    int bait = fis.read();
                    if (bait > maxBait) maxBait = bait;
                }
                int[] arr = new int[maxBait+1];
                fis.close();

                int maxCount = 0;
                fis = new FileInputStream(filename);
                while (fis.available() > 0) {
                    int bait = fis.read();
                    arr[bait]++;
                    if (arr[bait] > maxCount) {
                        maxCount = arr[bait];
                    }
                }
                System.out.print("max count = " + maxCount + " ");

                List<Integer> list = new ArrayList<>();

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == maxCount) {
                        System.out.print((char)i + "(" + i  + ") - " + arr[i] + ", ");
                        list.add(i);
                    }
                }
                //System.out.println(list);

                writeToMap(filename, list);

                fis.close();

            } catch ( IOException e) {
                e.printStackTrace();
            }
        }
    }
}
