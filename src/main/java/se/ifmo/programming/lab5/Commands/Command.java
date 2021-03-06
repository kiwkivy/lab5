package se.ifmo.programming.lab5.Commands;

import se.ifmo.programming.lab5.storage.Storage;

import java.util.Collection;

/**
 * Родительский класс для команд.
 */

public abstract class Command<T extends Collection<E>, E> {
    protected Storage<?, E> storage;
    protected E element;

    public Command(){
    }


    public Command(Storage<?, E> storage) {
        this.storage = storage;
    }

    public Command(Storage<?, E> storage, E element) {
        this.storage = storage;
        this.element = element;
    }

    /**
     * Выполнение команды
     */
    public abstract void execute();
}
