package hw_10;


import java.util.ArrayList;
import java.util.List;

public class TaskTracker {
    private List<Task> tasks;

    public TaskTracker() {
        this.tasks = new ArrayList<>();
    }

    // Добавить новую задачу в список
    public void addTask(String name) {
        tasks.add(new Task(name));
        System.out.println("Задача \"" + name + "\" добавлена!");
    }

    // Вывести все задачи
    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст!");
            return;
        }
        System.out.println("=== Список задач ===");
        for (Task task : tasks) {
            task.printInfo();
        }
        System.out.println("====================");
    }

    // Пометить задачу как сделанную (на базе переданного имени задачи)
    public void markTaskAsDone(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                if (task.isDone()) {
                    System.out.println("Задача \"" + name + "\" уже выполнена!");
                } else {
                    task.markAsDone();
                    System.out.println("Задача \"" + name + "\" отмечена как выполненная!");
                }
                return;
            }
        }
        System.out.println("Задача с именем \"" + name + "\" не найдена!");
    }

    // Получить статус задачи по переданному названию
    public boolean getTaskStatus(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                return task.isDone();
            }
        }
        System.out.println("Задача с именем \"" + name + "\" не найдена!");
        return false;
    }

    // Вывести статистику по задачам
    public void printStatistics() {
        int total = tasks.size();
        int done = 0;
        for (Task task : tasks) {
            if (task.isDone()) {
                done++;
            }
        }
        int open = total - done;
        System.out.println("Всего задач: " + total);
        System.out.println("Выполнено: " + done);
        System.out.println("Открыто: " + open);
    }
}