package hw_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Часть 1: База данных пришельцев
        System.out.println("=== Часть 1: База данных пришельцев ===");
        List<Alien> aliens = new ArrayList<>();
        aliens.add(new Alien("Зигмунд", "Марс", 5));
        aliens.add(new Alien("Глок", "Венера", 3));
        aliens.add(new Alien("Зигмунд", "Марс", 8)); // дубликат по имени и планете
        aliens.add(new Alien("Ксорг", "Юпитер", 9));
        aliens.add(new Alien("Плуто", "Нептун", 2));

        System.out.println("Список пришельцев:");
        for (Alien a : aliens) {
            System.out.println(a);
        }

        // Проверка на дубликаты
        boolean hasDuplicate = false;
        for (int i = 0; i < aliens.size(); i++) {
            for (int j = i + 1; j < aliens.size(); j++) {
                if (aliens.get(i).equals(aliens.get(j))) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) break;
        }
        System.out.println("Содержит ли список дубликат? " + hasDuplicate);
        System.out.println();

        // Часть 2 и 3 через SquadManager
        SquadManager squadManager = new SquadManager();
        squadManager.demonstrateListCreations();

        // Часть 3: подготовка списка и фильтрация
        List<String> squad = new ArrayList<>(Arrays.asList("Трус Петя", "Иван", "Трус Вася", "Сергей", "Анна"));
        squadManager.filterOutCowards(squad);
        // Бонус (закомментирован, можно раскомментировать для проверки)
        // squad = new ArrayList<>(Arrays.asList("Трус Петя", "Иван", "Трус Вася", "Сергей", "Анна"));
        // squadManager.filterOutCowardsWithRemoveIf(squad);

        // Часть 4: Очередь на вход
        System.out.println("=== Часть 4: Очередь на вход ===");
        AssaultQueue queue = new AssaultQueue();
        queue.addRecruit("Боец1");
        queue.addRecruit("Боец2");
        queue.addRecruit("Боец3");
        queue.addRecruit("Боец4");
        queue.addRecruit("Боец5");
        System.out.println("Исходная очередь:");
        queue.printQueue();

        System.out.println("Уходят из начала:");
        System.out.println("Ушёл: " + queue.retreatCoward());
        System.out.println("Ушёл: " + queue.retreatCoward());
        System.out.println("Очередь после ухода двух:");
        queue.printQueue();

        queue.addRecruit("Новобранец6");
        queue.addRecruit("Новобранец7");
        queue.addRecruit("Новобранец8");
        System.out.println("Итоговая очередь:");
        queue.printQueue();
        System.out.println();

        // Часть 5: Отчёт командованию
        System.out.println("=== Часть 5: Отчёт командованию ===");
        List<Alien> captured = Arrays.asList(
                new Alien("Зигмунд", "Марс", 5),
                new Alien("Глок", "Венера", 3)
        );
        MissionReport report1 = new MissionReport("Штурм Зоны 51", captured, 50);
        MissionReport report2 = new MissionReport("Штурм Зоны 51", captured, 50);

        System.out.println("Отчёт 1:");
        System.out.println(report1);
        System.out.println("\nОтчёт 2:");
        System.out.println(report2);

        System.out.println("\nСравнение через == : " + (report1 == report2));
        System.out.println("Сравнение через equals() : " + report1.equals(report2));
        // equals не переопределён, поэтому сравниваются ссылки -> false
    }
}
