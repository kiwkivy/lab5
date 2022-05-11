package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.exceptions.ElementNotValidException;
import se.ifmo.programming.lab5.storage.Storage;

/**
 * Команда add name age : добавить новый элемент в коллекцию.
 */
public class Add<E> extends Command {
    public static String description = "добавить новый элемент в коллекцию";
    public static String syntax = "add name age";

    public Add(Storage storage, E element) {
        super(storage,element);
    }

    @Override
    public void execute(){
        try {
            storage.add(element);
            System.out.println("Элемент добавлен в коллекцию");
        }catch (ElementNotValidException e){
            System.out.println("Некорректный ввод элемента");
        }
    }
}

