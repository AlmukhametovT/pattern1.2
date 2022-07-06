package ru.ufa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        System.out.println("Доброго времени суток!");

        logger.log("Просим пользователя ввести входные данные для списка");
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int f = 0;

        try {
            System.out.println("Введите размер списка N");
            String inputN = scanner.nextLine();
            System.out.println("Введите верхнюю границу значений элементов в списке M");
            String inputM = scanner.nextLine();
            System.out.println("Введите число f для фильтрации списка");
            String inputF = scanner.nextLine();
            n = Integer.parseInt(inputN);
            m = Integer.parseInt(inputM);
            f = Integer.parseInt(inputF);

        } catch (NumberFormatException exception) {
            System.out.println("Ошибка преобразования значения");
        } finally {
            scanner.close();
        }

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(m));
        }

        System.out.println("Список размера " + n + " заполенный случайными числами от 0 до " + m + ": " + list);

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(f);
        List<Integer> filteredList = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println("Список отсортированный, пропущены элементы меньше " + f + ": " + filteredList);

        logger.log("Завершаем программу");
    }
}