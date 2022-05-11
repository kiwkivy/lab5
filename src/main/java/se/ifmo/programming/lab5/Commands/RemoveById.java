package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.Storage;

/**
 * Команда remove_by_id id : удалить элемент из коллекции по его id.
 */

public class RemoveById extends Command {
    int id;
    public static String description = "удалить элемент из коллекции по его id";
    public static String syntax = "remove_by_id id";

    public RemoveById(Storage storage, int id) {
        super(storage);
        this.id = id;
    }

    @Override
    public void execute() {
        storage.removeById(id);
        System.out.println("Элемент с id "+id+" удалён из коллекции");
    }
}
