package hw_14;

import java.lang.reflect.*;

public class ObjectScanner {

    public static void scan(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("=== Информация об объекте класса " + clazz.getSimpleName() + " ===");

        // Поля – используем getDeclaredFields, чтобы видеть даже приватные
        System.out.println("\n--- Поля (getDeclaredFields) ---");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true); // разрешаем доступ к приватным
            try {
                System.out.println(f.getName() + " = " + f.get(obj));
            } catch (IllegalAccessException e) {
                System.out.println(f.getName() + " - недоступно");
            }
        }

        // Методы – getDeclaredMethods показывает все методы класса (не унаследованные)
        System.out.println("\n--- Методы (getDeclaredMethods) ---");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName() + " (" + m.getParameterCount() + " параметров)");
        }

        // Конструкторы – getDeclaredConstructors показывает все конструкторы класса
        System.out.println("\n--- Конструкторы (getDeclaredConstructors) ---");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c.getName() + " (параметров: " + c.getParameterCount() + ")");
        }
    }


    public static void main(String[] args) {
        Person p = new Person("Bob");
        p.age = 25;
        p.height = 1.80;
        p.nickname = "Bobby";

        scan(p);
    }
}