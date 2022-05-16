package se.ifmo.programming.lab5;

import se.ifmo.programming.lab5.storage.DragonVectorStorage;
import se.ifmo.programming.lab5.utils.Application;

import java.io.File;

public class Main {
    public static void main(String[] args){
        String fileName = System.getenv("FILENAME");
        if (fileName == null) {
            System.out.println("Переменная оркужения не установлена.\nВыход из программы.");
            System.exit(16);
        }
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Файл не найден!\nВыход из программы.");
            System.exit(17);
        }
        else if (!file.canRead()) {
            System.out.println("Отсутствуют права на чтение!\nВыход из программы.");
            System.exit(18);
        } else if (!file.canWrite()) {
            System.out.println("Отсутствуют права на запись!\nВыход из программы.");
            System.exit(19);
        }
        DragonVectorStorage dragonVectorStorage = new DragonVectorStorage(file);
        Application application = new Application(dragonVectorStorage);
        application.run();
    }
}
