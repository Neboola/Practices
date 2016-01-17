package com.javarush.test.level16.lesson13.bonus01new;

import java.util.ArrayList;

/**
 * Created by OmniTool on 17.01.2016.
 *
 * 1. Factory method pattern

 Задача: 1. Внимательно посмотри, какие классы у тебя есть.
 2. В отдельных файлах в пакете common создай классы JpgReader, PngReader, BmpReader, которые реализуют интерфейс ImageReader.
 3. В отдельном файле в пакете bonus01 создай класс ImageReaderFactory с одним методом.
 3.1. Подумай, как он должен называться.
 3.2. Подумай, какие модификаторы должны быть у этого метода.
 4. Этот метод должен:
 4.1. для каждого значения из ImageTypes возвращать соответствующий Reader, например, для ImageTypes.JPG - JpgReader;
 4.2. если передан неправильный параметр, то выбросить исключение IllegalArgumentException("Неизвестный тип картинки").
 */
public class Solution {

    public static void main(String[] args) {
        ImageReaderFactory factory = new ImageReaderFactory();

        ArrayList<ImageReader> readers = new ArrayList<ImageReader>();

        ArrayList<Image> images = new ArrayList<Image>();
        images.add(new Image(ImageTypes.BMP));
        images.add(new Image(ImageTypes.JPG));
        images.add(new Image(ImageTypes.PNG));
        images.add(new Image(ImageTypes.JPEG));

        for (int i = 0; i < images.size(); i++) {
            try {
                readers.add(factory.makeImageReader(images.get(i).getType()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        for (ImageReader reader : readers) {
            reader.initReading();
        }
    }

}
