package com.javarush.test.level16.lesson13.bonus01new.common;

import com.javarush.test.level16.lesson13.bonus01new.ImageReader;

/**
 * Created by OmniTool on 17.01.2016.
 */
public class JpgReader implements ImageReader {
    @Override
    public void initReading() {
        System.out.println("JpgReader готов");
    }
}
