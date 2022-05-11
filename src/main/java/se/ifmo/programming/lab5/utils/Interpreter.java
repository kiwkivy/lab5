package se.ifmo.programming.lab5.utils;

import se.ifmo.programming.lab5.Commands.*;
import se.ifmo.programming.lab5.data.*;
import se.ifmo.programming.lab5.storage.DragonVectorStorage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interpreter {
    private final boolean isConsoleMod;
    private File file;
    private DragonVectorStorage dragonVectorStorage;
    public static List<String> scriptArray = new ArrayList<>();

    public Interpreter(DragonVectorStorage dragonVectorStorage) {
        this.dragonVectorStorage = dragonVectorStorage;
        this.isConsoleMod = true;
    }

    public Interpreter(DragonVectorStorage dragonVectorStorage, File file) {
        this.dragonVectorStorage = dragonVectorStorage;
        this.isConsoleMod = false;
        this.file = file;
    }

    /**
     * Метод, реализующий работу интерпретатора. Интерпретатор работает в двух режимах: консольном и скриптовом.
     */

    public void start() {
        FileWorker worker = new FileWorker();
        String data;
        Scanner scanner = null;
        if (isConsoleMod){
            scanner = new Scanner(System.in);
        }else{
            try {
                scanner = new Scanner(file);
            }catch(FileNotFoundException e){
                System.out.println("Ошибка доступа к файла.");
            }
        }
        do {
            if (isConsoleMod) {
                System.out.print("Введите команду: ");
            }
            data = scanner.nextLine();
            String[] commandParts = data.split("\\s+");
            String command = commandParts[0];
            if (!data.equals("")) {
                if (commandParts.length == 1) {
                    switch (command) {
                        case "clear":
                            Command clear = new Clear(dragonVectorStorage);
                            clear.execute();
                            break;
                        case "exit":
                            Command exit = new Exit();
                            exit.execute();
                            break;
                        case "help":
                            Command help = new Help();
                            help.execute();
                            break;
                        case "info":
                            Command info = new Info(dragonVectorStorage);
                            info.execute();
                            break;
                        case "reorder":
                            Command reorder = new Reorder(dragonVectorStorage);
                            reorder.execute();
                            break;
                        case "save":
                            Command save = new Save(dragonVectorStorage, worker, dragonVectorStorage.getFile());
                            save.execute();
                            break;
                        case "show":
                            Command show = new Show(dragonVectorStorage);
                            show.execute();
                            break;
                        case "print_field_descending_cave":
                            Command printFieldDescendingCave = new PrintFieldDescendingCave(dragonVectorStorage);
                            printFieldDescendingCave.execute();
                            break;
                        default:
                            System.out.println(
                                    "Команда <" + data + "> не распознана. Для получения справки введите help"
                            );
                            break;
                    }
                } else {
                    switch (command) {
                        case "count_by_color":
                            if (commandParts.length == 2 && Checker.checkColor(commandParts[1])) {
                                Color color = Color.valueOf(commandParts[1]);
                                Command countByColor = new CountByColor(dragonVectorStorage, color);
                                countByColor.execute();
                            } else {
                                System.out.println("Команда введена неверно. Для получения справки введите help");
                                System.out.println("Доступные цвета - GREEN, BLUE, BLACK, ORANGE, WHITE ");
                            }
                            break;
                        case "execute_script":
                            if (commandParts.length == 2) {
                                File scriptFile = new File(commandParts[1]);
                                if (scriptFile.exists()) {
                                    if (!scriptFile.canRead()){
                                        System.out.println("Отсутствуют права на чтение!");
                                    } else if (!scriptFile.canWrite()) {
                                        System.out.println("Отсутствуют права на запись!");
                                    }
                                    if (!scriptArray.contains(commandParts[1])) {
                                        scriptArray.add(commandParts[1]);
                                        Command executeScript = new ExecuteScript(dragonVectorStorage, scriptFile);
                                        scriptArray.remove(commandParts[1]);
                                        executeScript.execute();
                                    } else System.out.println("Данный скрипт уже использован.");
                                } else
                                    System.out.println(
                                            "Не удалось получить данные из файла. Проверьте корректность данных."
                                    );
                            }
                            break;
                        case "filter_starts_with_name":
                            if (commandParts.length == 2) {
                                Command filterStartsWithName = new FilterStartsWithName(
                                        dragonVectorStorage,
                                        commandParts[1]
                                );
                                filterStartsWithName.execute();
                            }
                            break;
                        case "remove_by_id":
                            if (commandParts[1].length() == 2 && Checker.checkIntUpZero(commandParts[1])) {
                                Command removeById = new RemoveById(
                                        dragonVectorStorage,
                                        Integer.parseInt(commandParts[1])
                                );
                                removeById.execute();
                            } else System.out.println("Команда введена неверно. Для получения справки введите help");
                            break;
                        case "remove_lower":
                            if (commandParts[1].length() == 2) {
                                if (Checker.checkIntUpZero(commandParts[1]) &&
                                        (Integer.parseInt(commandParts[1]) < dragonVectorStorage.getIdCounter())) {
                                    Command removeLower = new RemoveLower(
                                            dragonVectorStorage,
                                            dragonVectorStorage.getDragonVector().get(
                                                    Integer.parseInt(commandParts[1]) - 1
                                            )
                                    );
                                    removeLower.execute();
                                } else
                                    System.out.println(
                                            "Элемента с таким id не существует. " +
                                            "Введите show для просмотра существующих элементов"
                                    );
                            } else System.out.println("Команда введена неверно. Для получения справки введите help");
                            break;
                        case "add":
                            if (commandParts.length == 3 && Checker.checkIntUpZero(commandParts[2])) {
                                if (dragonVectorStorage.getIdCounter() <= 99) {
                                    Dragon dragon;
                                    CreatorOfDragons creatorOfDragons = new CreatorOfDragons(commandParts[1],
                                            Integer.parseInt(commandParts[2]));
                                    if (isConsoleMod) {
                                        dragon = creatorOfDragons.create();
                                    } else {
                                        dragon = creatorOfDragons.create(scanner);
                                    }
                                    if (dragon != null && dragon.isValid()) {
                                        Command add = new Add(dragonVectorStorage, dragon);
                                        add.execute();
                                    }
                                } else System.out.println("Превышено количество элементов коллекции.");
                            } else System.out.println("Команда введена неверно. Для получения справки введите help");
                            break;
                        case "insert_at":
                            if (commandParts.length == 4 && Checker.checkIntUpZero(commandParts[1]) &&
                                    Checker.checkIntUpZero(commandParts[3])) {
                                if (dragonVectorStorage.getIdCounter() > Integer.parseInt(commandParts[1])) {
                                    Dragon dragon;
                                    CreatorOfDragons creatorOfDragons = new CreatorOfDragons(
                                            commandParts[2],
                                            Integer.parseInt(commandParts[3])
                                    );
                                    if (isConsoleMod) {
                                        dragon = creatorOfDragons.create();
                                    } else {
                                        dragon = creatorOfDragons.create(scanner);
                                    }
                                    if (dragon != null && dragon.isValid()) {
                                        Command add = new Add(dragonVectorStorage, dragon);
                                        add.execute();
                                    }
                                    Command insertAt = new InsertAt(dragonVectorStorage, dragon, Integer.parseInt(commandParts[1]));
                                    insertAt.execute();
                                } else
                                    System.out.println(
                                            "Коллекция меньше, чем введённый номер элемента. " +
                                            "Размер коллекции: " + dragonVectorStorage.getIdCounter()
                                    );
                            } else System.out.println("Команда введена неверно. Для получения справки введите help");
                            break;
                        case "update":
                            if (commandParts.length == 4 && Checker.checkIntUpZero(commandParts[1]) &&
                                    Checker.checkIntUpZero(commandParts[3])) {
                                if (dragonVectorStorage.getIdCounter() > Integer.parseInt(commandParts[1])) {
                                    Dragon dragon = null;
                                    CreatorOfDragons creatorOfDragons = new CreatorOfDragons(
                                            commandParts[2],
                                            Integer.parseInt(commandParts[3])
                                    );
                                    if (isConsoleMod) {
                                        dragon = creatorOfDragons.create();
                                    } else {
                                        dragon = creatorOfDragons.create(scanner);
                                    }
                                    if (dragon != null && dragon.isValid()) {
                                        Command update = new Update(
                                                dragonVectorStorage,
                                                dragon,
                                                Integer.parseInt(commandParts[1])
                                        );
                                        update.execute();
                                    }
                                } else
                                    System.out.println("Номер элемента не может быть больше количества элементов" +
                                            " коллекции = " + dragonVectorStorage.getIdCounter());
                            } else System.out.println("Команда введена неверно. Для получения справки введите help");
                            break;
                        default:
                            System.out.println("Команда <"+data+"> не распознана. Для получения справки введите help");
                            break;
                    }
                }
            }
        } while (this.isConsoleMod || scanner.hasNextLine());
    }
}
