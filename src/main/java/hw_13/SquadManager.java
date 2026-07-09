package hw_13;

import java.util.*;

public class SquadManager {

    // Часть 2
    public void demonstrateListCreations() {
        System.out.println("=== Часть 2: Формирование отрядов ===");

        // 1. ArrayList
        List<String> mainSquad = new ArrayList<>();
        mainSquad.add("Штурмовик1");
        mainSquad.add("Штурмовик2");
        mainSquad.add("Штурмовик3");
        mainSquad.add("Штурмовик4");
        System.out.println("Основной отряд (ArrayList): " + mainSquad);

        // 2. Arrays.asList()
        List<String> supportSquad = Arrays.asList("Поддержка1", "Поддержка2", "Поддержка3");
        System.out.println("Отряд поддержки (Arrays.asList): " + supportSquad);

        // 3. List.of()
        List<String> eliteSquad = List.of("Элит1", "Элит2");
        System.out.println("Элитный отряд (List.of): " + eliteSquad);

        // Попытки модификации
        System.out.println("\nПопытки модификации:");
        modifyList(mainSquad, "Основной отряд (ArrayList)");
        modifyList(supportSquad, "Отряд поддержки (Arrays.asList)");
        modifyList(eliteSquad, "Элитный отряд (List.of)");
        System.out.println();
    }

    private void modifyList(List<String> list, String listName) {
        // Попытка добавить
        try {
            list.add("Новый боец");
            System.out.println(listName + " — добавление успешно");
        } catch (Exception e) {
            System.out.println(listName + " — добавление не удалось: " + e.getClass().getSimpleName());
        }

        // Попытка удалить (удаляем первый элемент, если есть)
        try {
            if (!list.isEmpty()) {
                list.remove(0);
                System.out.println(listName + " — удаление успешно");
            } else {
                System.out.println(listName + " — список пуст, удаление невозможно");
            }
        } catch (Exception e) {
            System.out.println(listName + " — удаление не удалось: " + e.getClass().getSimpleName());
        }
    }

    // Часть 3: Отсеивание трусов (через Iterator)
    public void filterOutCowards(List<String> squad) {
        System.out.println("=== Часть 3: Отсеивание трусов ===");
        System.out.println("Отряд до фильтрации: " + squad);

        Iterator<String> iterator = squad.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.startsWith("Трус")) {
                iterator.remove();
            }
        }

        System.out.println("Отряд после фильтрации: " + squad);
        System.out.println();
    }

    // Бонус: альтернативная фильтрация через removeIf()
    public void filterOutCowardsWithRemoveIf(List<String> squad) {
        System.out.println("=== Бонус: фильтрация через removeIf() ===");
        System.out.println("Отряд до фильтрации: " + squad);
        squad.removeIf(name -> name.startsWith("Трус"));
        System.out.println("Отряд после фильтрации: " + squad);
        System.out.println();
    }
}