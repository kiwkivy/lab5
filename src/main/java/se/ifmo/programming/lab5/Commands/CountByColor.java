package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.data.Color;
import se.ifmo.programming.lab5.storage.DragonVectorStorage;

/**
 * Команда count_by_color color : вывести количество элементов, значение поля color которых равно заданному.
 */

public class CountByColor extends Command {
    private Color color;
    private DragonVectorStorage dragonVectorStorage;
    public static String description = "вывести количество элементов, значение поля color которых равно заданному";
    public static String syntax = "count_by_color color";

    public CountByColor(DragonVectorStorage dragonVectorStorage, Color color) {
       this.dragonVectorStorage = dragonVectorStorage;
       this.color = color;
    }

    @Override
    public void execute() {
        dragonVectorStorage.countByColor(color);
    }
}
