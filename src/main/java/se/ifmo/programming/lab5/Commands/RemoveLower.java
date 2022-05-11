package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.Storage;

/**
 * Команда remove_lower id : удалить из коллекции все элементы, меньшие, чем заданный.
 */

public class RemoveLower<E> extends Command{
    public static String description = "удалить из коллекции все элементы, меньшие, чем заданный";
    public static String syntax = "remove_lower id";

    public RemoveLower(Storage storage, E element) {
        super(storage);
        this.element = element;
    }

    @Override
    public void execute() {
        storage.removeLower(element);
        System.out.println("Элементы, меньшее заданного, удалены из коллекции");
    }
}
