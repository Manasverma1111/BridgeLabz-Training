class Person {

    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display person details
    void displayDetails() {

        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }

    // Main method for testing
    public static void main(String[] args) {

        Person p1 = new Person("Steve Rogers", 34);
        Person p2 = new Person(p1);   // Clone p1 using copy constructor

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
    }
}
