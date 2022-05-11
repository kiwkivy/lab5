package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.Storage;

/**
 * Команда reorder : отсортировать коллекцию в порядке, обратном нынешнему.
 */

public class Reorder extends Command {
    public static String description = "отсортировать коллекцию в порядке, обратном нынешнему";
    public static String syntax = "reorder";

    public Reorder(Storage storage) {
        super(storage);
    }

    @Override
    public void execute(){
        System.out.println("Коллекция отсортирована в обратном порядке");
        storage.reorder();
    }
}
