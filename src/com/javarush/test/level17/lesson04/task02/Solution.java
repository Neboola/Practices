package com.javarush.test.level17.lesson04.task02;

/**
 * Created by OmniTool on 18.01.2016.
 */
import java.util.ArrayList;
import java.util.List;

/* Синхронизированные заметки
1. Класс Note будет использоваться нитями. Поэтому сделай так, чтобы обращения к листу notes блокировали мютекс notes, не this
2. Все System.out.println не должны быть заблокированы (синхронизированы), т.е. не должны находиться в блоке synchronized
*/

public class Solution {
    public static class Note {

        public final List<String> notes = new ArrayList<String>();

        public synchronized void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);

                notes.add(index, note);


            System.out.println("Добавлена заметка [" + note + "]");
        }

        public synchronized void removeNote(int index) {
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            String note;

                note = notes.remove(index);


            System.out.println("Удалена заметка [" + note + "] с позиции " + index);
        }
    }
}
