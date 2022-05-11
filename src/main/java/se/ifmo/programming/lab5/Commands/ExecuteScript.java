package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.DragonVectorStorage;
import se.ifmo.programming.lab5.utils.Interpreter;

import java.io.File;
/**
 * Команда execute_script file_name : считать и исполнить скрипт из указанного файла.
 * В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 */
public class ExecuteScript extends Command {
    private final DragonVectorStorage dragonVectorStorage;
    private File scriptFile;

    public static String description = "считать и исполнить скрипт из указанного файла." +
            " В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    public static String syntax = "execute_script file_name";

    public ExecuteScript(DragonVectorStorage dragonVectorStorage, File scriptFile){
        this.dragonVectorStorage = dragonVectorStorage;
        this.scriptFile = scriptFile;
    }

    @Override
    public void execute() {
        System.out.println("Выполнение скрипта " + scriptFile);
        Interpreter interpreter = new Interpreter(dragonVectorStorage, scriptFile);
        interpreter.start();
        System.out.println("Скрипт " + scriptFile + " завершён.");
    }
}
