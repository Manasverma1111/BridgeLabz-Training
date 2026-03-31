interface Worker {
    void performDuties();
}

// Superclass
class Personn {
    protected String name;
    protected int id;

    Personn(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Personn implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        displayPersonInfo();
        System.out.println("Role: Chef");
        System.out.println("Duty: Preparing and cooking food");
    }
}

// Waiter class
class Waiter extends Personn implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {

        displayPersonInfo();
        System.out.println("Role : Waiter");
        System.out.println("Duty : Serving food to customers");
    }
}

public class RestaurantManagement {
    public static void main(String[] args) {

        Worker chef = new Chef("Rahul", 101);
        Worker waiter = new Waiter("Amit", 102);
        chef.performDuties();
        System.out.println();

        waiter.performDuties();
    }
}
