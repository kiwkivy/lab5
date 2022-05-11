package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.DragonVectorStorage;

import java.util.Collection;

/**
 * Команда print_field_descending_cave : вывести значения поля cave всех элементов в порядке убывания.
 */

public class PrintFieldDescendingCave extends Command {
    DragonVectorStorage dragonVectorStorage;
    public static String description = "вывести значения поля cave всех элементов в порядке убывания";
    public static String syntax = "print_field_descending_cave";

    public PrintFieldDescendingCave(DragonVectorStorage dragonVectorStorage) {
        this.dragonVectorStorage = dragonVectorStorage;
    }

    @Override
    public void execute(){
        System.out.println("Значения поля cave всех элементов в порядке убывания:");
        Collection dragonCaveCollection = dragonVectorStorage.getAllDescendingCave();
        for (Object dragonCave : dragonCaveCollection){
            System.out.println(dragonCave.toString());
        }
    }
}
