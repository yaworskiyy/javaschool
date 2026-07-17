package hw_14;

public class Person {
    private String name;
    protected int age;
    public double height;
    String nickname;


    public Person(String name) {
        this.name = name;
    }


    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    private Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }


    public void sayHello() {
        System.out.println("Hello, I'm " + name);
    }


    protected void setAge(int age) {
        this.age = age;
    }


    private String getSecret() {
        return "secret";
    }


    void printInfo() {
        System.out.println(name + ", " + age + ", " + height);
    }
}