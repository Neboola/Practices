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
                System.out.println("BmpReader created");
                return new BmpReader();
            case JPG:
                System.out.println("JpgReader created");
                return new JpgReader();
            case PNG:
                System.out.println("PngReader created");
                return new PngReader();
            default:
                System.out.println("NoReader created");
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
