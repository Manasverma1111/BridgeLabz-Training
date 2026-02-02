package annotation;

class Animal {

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class OverrideAnnotation {

    public static void main(String[] args) {

        Animal animal = new Dog();
        animal.makeSound();
    }
}

