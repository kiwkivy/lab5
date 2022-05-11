package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.Storage;

/**
 * Команда show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении.
 */

public class Show extends Command{
    public static String description = "вывести в стандартный поток вывода все элементы коллекции " +
            "в строковом представлении";
    public static String syntax = "show";

    public Show(Storage storage) {
        super(storage);
    }

    @Override
    public void execute(){
        System.out.println("Вывод коллекции:");
        storage.show();
    }
}
