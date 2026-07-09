package hw_13;

import java.util.LinkedList;

public class AssaultQueue {
    private LinkedList<String> queue;

    public AssaultQueue() {
        queue = new LinkedList<>();
    }

    public void addRecruit(String name) {
        queue.addLast(name);
    }

    public String retreatCoward() {
        return queue.pollFirst(); // удаляет и возвращает первый элемент, или null если пусто
    }

    public void printQueue() {
        System.out.println("Текущая очередь: " + queue);
    }

    @Override
    public String toString() {
        return "AssaultQueue{" + queue + '}';
    }
}