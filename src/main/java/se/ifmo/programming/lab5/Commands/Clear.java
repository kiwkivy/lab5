package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.Storage;

/**
 * Команда clear : очистить коллекцию.
 */

public class Clear extends Command {
    public static String description = "очистить коллекцию";
    public static String syntax = "clear";

    public Clear(Storage storage) {
        super(storage);
    }

    @Override
    public void execute(){
        storage.clear();
        System.out.println("Коллекция очищена");
    }
}
