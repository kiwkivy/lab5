package se.ifmo.programming.lab5.Commands;

/**
 * Команда exit : завершить программу (без сохранения в файл).
 */

public class Exit extends Command {
    public static String description = "завершить программу (без сохранения в файл)";
    public static String syntax = "exit";

    @Override
    public void execute(){
        System.out.println("Завершение работы программы.");
        System.out.println("Ждём вас снова!");
        System.exit(0);
    }
}
