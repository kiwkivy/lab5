package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.DragonVectorStorage;
import se.ifmo.programming.lab5.utils.FileWorker;

import java.io.File;

/**
 * Команда save : сохранить коллекцию в файл.
 */

public class Save extends Command{
    private FileWorker worker;
    private File file;
    private DragonVectorStorage dragonVectorStorage;
    public static String description = "сохранить коллекцию в файл";
    public static String syntax = "save";

    public Save(DragonVectorStorage dragonVectorStorage, FileWorker worker, File file) {
        this.dragonVectorStorage = dragonVectorStorage;
        this.worker = worker;
        this.file = file;
    }

    @Override
    public void execute() {
        System.out.println("Коллекция сохранена в файл");
        dragonVectorStorage.save(dragonVectorStorage, file, worker);
    }
}
