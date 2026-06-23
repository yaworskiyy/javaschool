package hw_10;


public class Main {
    public static void main(String[] args) {
        TaskTracker tracker = new TaskTracker();

        // Добавляем задачи
        tracker.addTask("Проверить авторизацию");
        tracker.addTask("Проверить регистрацию");
        tracker.addTask("Написать тесты");

        // Выводим все задачи
        tracker.printAllTasks();

        // Помечаем задачу как выполненную
        tracker.markTaskAsDone("Проверить регистрацию");

        // Проверяем статус
        boolean status = tracker.getTaskStatus("Проверить регистрацию");
        System.out.println("Статус задачи 'Проверить регистрацию': " + (status ? "Выполнена" : "Не выполнена"));

        // Выводим обновленный список
        tracker.printAllTasks();

        // Выводим статистику
        tracker.printStatistics();
    }
}