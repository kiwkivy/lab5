package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.exceptions.ElementNotValidException;
import se.ifmo.programming.lab5.storage.Storage;

/**
 * Команда update id name age : обновить значение элемента коллекции, id которого равен заданному.
 */

public class Update<E> extends Command {
    private int id;
    public static String description = "обновить значение элемента коллекции, id которого равен заданному";
    public static String syntax = "update id {element}";

    public Update(Storage storage, E element, int id) {
        super(storage);
        this.element = element;
        this.id = id-1;
    }

    @Override
    public void execute() {
        try {
            storage.update(id, element);
            System.out.println("Элемент с id "+ id +" обновлён");
        }catch (ElementNotValidException e){
        }
    }
}
