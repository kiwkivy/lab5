package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.exceptions.ElementNotValidException;
import se.ifmo.programming.lab5.storage.Storage;

/**
 * Команда insert_at index name age : добавить новый элемент в заданную позицию.
 */

public class InsertAt<E> extends Command {
    private int index;
    public static String description = "добавить новый элемент в заданную позицию";
    public static String syntax = "insert_at index name age";

    public InsertAt(Storage storage, E element, int index) {
        super(storage, element);
        this.index = index-1;
    }

    @Override
    public void execute(){
        try {
            storage.insertAt(index, element);
            System.out.println("Эленент добавлин в позицию "+index);
        }catch (ElementNotValidException e){
        }
    }
}
