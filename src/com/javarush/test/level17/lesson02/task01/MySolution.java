package com.javarush.test.level17.lesson02.task01;

import java.util.ArrayList;

/**
 * Created by OmniTool on 18.01.2016.
 */
public class MySolution { // слепая реализация

    public static void main(String[] args) {

    }

    public static class NoteThread extends Thread {

        @Override
        public void run() {
            for (int index = 0; index < 999; index++) {

            }
        }

    }

    private static class Note {

        private static ArrayList<Note> notes = new ArrayList<Note>();
        String text;

        private void addNote(String text) {

        }

        private void removeNote(String name) {

        }
    }

}
