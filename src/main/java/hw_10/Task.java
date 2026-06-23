package hw_10;

public class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    // Пометить задачу как выполненную
    public void markAsDone() {
        this.isDone = true;
    }

    // Получить статус - выполнена задача или нет
    public boolean isDone() {
        return isDone;
    }

    // Получить название задачи
    public String getName() {
        return name;
    }

    // Вывести информацию о задаче
    public void printInfo() {
        String status = isDone ? "[x]" : "[ ]";
        System.out.println(status + " " + name);
    }
}