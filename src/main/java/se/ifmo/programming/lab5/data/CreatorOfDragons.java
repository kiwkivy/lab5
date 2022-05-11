package se.ifmo.programming.lab5.data;

import java.util.Scanner;

/**
 * Класс для создания объектов типа Dragon
 */
public class CreatorOfDragons {
    private String name;
    private int age;

    public CreatorOfDragons(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * Метод создаёт объект типа Dragon на основе пользовательского ввода.
     *
     * @return dragon
     */
    public Dragon create(){
        boolean isWrong = true;
        Scanner scanner = new Scanner(System.in);
        String data = "";
        while (isWrong) {
            System.out.println("Доступные цвета - GREEN, BLUE, BLACK, ORANGE, WHITE ");
            System.out.print("Введите цвет вашего дракона: ");
            data = scanner.nextLine();
            if (Checker.checkColor(data)) {
                isWrong = false;
            }else{
                System.out.println("Данного цвета не существует. Попробуйте ещё раз.");
            }
        }
        Color color = Color.valueOf(data);
        isWrong = true;

        while (isWrong) {
            System.out.println("Доступные типы - AIR, UNDERGROUND, FIRE ");
            System.out.print("Введите тип вашего дракона: ");
            data = scanner.nextLine();
            if (Checker.checkType(data)) {
                isWrong = false;
            }else{
                System.out.println("Данного типа драконов не существует. Попробуйте ещё раз.");
            }
        }
        DragonType type = DragonType.valueOf(data);
        isWrong = true;


        while (isWrong) {
            System.out.println("Доступные характеры - WISE, CHAOTIC_EVIL, FICKLE");
            System.out.print("Введите характер вашего дракона: ");
            data = scanner.nextLine();
            if (Checker.checkCharacter(data)) {
                isWrong = false;
            }else{
                System.out.println("Данного характера не существует. Попробуйте ещё раз.");
            }
        }
        DragonCharacter character = DragonCharacter.valueOf(data);
        isWrong = true;

        System.out.println("Коррдинаты вашего дракона.");
        while (isWrong) {
            System.out.print("Введите x: ");
            data = scanner.nextLine();
            if (Checker.checkLong(data)){
                isWrong = false;
            }else{
                System.out.println("Доступный диапазон: от –9 223 372 036 854 775 808 до 9 223 372 036 854 775 807");
            }
        }
        Long x = Long.parseLong(data);
        isWrong = true;

        while (isWrong) {
            System.out.print("Введите y: ");
            data = scanner.nextLine();
            if (Checker.checkDouble(data)){
                isWrong = false;
            }else{
                System.out.println("Доступный диапазон:  от ±4.9*10^(-324) до ±1.8*10^(308)");
            }
        }
        Double y = Double.parseDouble(data);
        isWrong = true;


        Coordinates coordinates = new Coordinates();
        coordinates.setX(x);
        coordinates.setY(y);

        System.out.println("Информация о пещере.");
        while (isWrong) {
            System.out.print("Введите количество сокровищ: ");
            data = scanner.nextLine();
            if (Checker.checkDoublePositive(data)) {
                isWrong = false;
            } else {
                System.out.println("Доступный диапазон:  от 4.9*10^(-324) до 1.8*10^(308)");
            }
        }
        Double numberOfTreasures = Double.parseDouble(data);
        isWrong = true;

        while (isWrong) {
            System.out.print("Введите глубину пещер: ");
            data = scanner.nextLine();
            if (Checker.checkDouble(data)){
                isWrong = false;
            } else {
                System.out.println("Диапазон зачений для глубины: от –9 223 372 036 854 775 808 до 9 223 372 036 854 775 807");
            }
        }
        Long depth = Long.parseLong(data);

        System.out.println();
        DragonCave cave = new DragonCave();
        cave.setNumberOfTreasures(numberOfTreasures);
        cave.setDepth(depth);

        Dragon dragon = new Dragon(name, coordinates, age, color, type, character, cave);
        return dragon;
    }

    /**
     * Метод создаёт объект типа Dragon на основе значений из файла.
     *
     * @return dragon
     */
    public Dragon create(Scanner scanner) {
        try {
            Color color = Color.valueOf(scanner.nextLine());
            DragonType type = DragonType.valueOf(scanner.nextLine());
            DragonCharacter character = DragonCharacter.valueOf(scanner.nextLine());
            Long x = Long.parseLong(scanner.nextLine());
            Double y = Double.parseDouble(scanner.nextLine());
            Coordinates coordinates = new Coordinates();
            coordinates.setX(x);
            coordinates.setY(y);
            DragonCave cave = new DragonCave();
            Double numberOfTreasures = Double.parseDouble(scanner.nextLine());
            Long depth = Long.parseLong(scanner.nextLine());
            cave.setDepth(depth);
            cave.setNumberOfTreasures(numberOfTreasures);

            Dragon dragon = new Dragon(name, coordinates, age, color, type, character, cave);
            return dragon;
        }catch (Exception e){
            System.out.println("Некорректный ввод дракона");
            return null;
        }
    }

}
