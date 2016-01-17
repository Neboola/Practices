package com.javarush.test.level16.lesson13.bonus01new;

import com.javarush.test.level16.lesson13.bonus01new.common.BmpReader;
import com.javarush.test.level16.lesson13.bonus01new.common.JpgReader;
import com.javarush.test.level16.lesson13.bonus01new.common.PngReader;

/**
 * Created by OmniTool on 17.01.2016.
 */
public class ImageReaderFactory {
    public ImageReader makeImageReader(ImageTypes type) {
        switch (type) {
            case BMP:
                System.out.println("Reader создан для " + type);
                return new BmpReader();
            case JPG:
                System.out.println("Reader создан для " + type);
                return new JpgReader();
            case PNG:
                System.out.println("Reader создан для " + type);
                return new PngReader();
            default:
                System.out.println("Reader не создан");
                throw new IllegalArgumentException("Неизвестный тип картинки: " + type);
        }
    }
}
