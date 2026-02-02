class A {
    void show() {
        System.out.println("A");
    }
}

class B extends A {
    void show() {
        System.out.println("B");
    }
}

class C extends B {
    void show() {
        System.out.println("C");
    }
}

class D extends B {
    void show() {
        System.out.println("D");
    }
}

public class MultipleInheritanceScenario {

    public static void main(String[] args) {

        D d = new D();
        d.show();
    }
}