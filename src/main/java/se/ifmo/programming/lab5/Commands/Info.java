package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.Storage;

/**
 * Команда info : вывести в стандартный поток вывода информацию о коллекции
 * (тип, дата инициализации, количество элементов и т.д.).
 */

public class Info extends Command{
    public static String description = "вывести в стандартный поток вывода информацию о коллекции " +
            "(тип, дата инициализации, количество элементов и т.д.)";
    public static String syntax = "info";

    public Info(Storage storage) {
        super(storage);
    }

    public void execute(){
        System.out.println("Информация о коллекции:");
        storage.info();
    }
}
