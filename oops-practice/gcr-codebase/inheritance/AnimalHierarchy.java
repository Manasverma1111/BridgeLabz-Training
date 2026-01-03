class Animal {
    protected String name;
    protected int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof Woof");
    }
}

class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow");
    }
}

class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Chirp Chirp");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {

        Animal dog = new Dog("Dog", 3);
        Animal cat = new Cat("Cat", 2);
        Animal bird = new Bird("Bird", 1);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}
