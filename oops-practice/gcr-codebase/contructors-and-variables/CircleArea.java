class CircleArea {

    double radius;

    CircleArea() {
        this(1.0);   // Calls parameterized constructor
    }

    CircleArea(double radius) {
        this.radius = radius;
    }
    void displayRadius() {

        System.out.println("Radius : " + radius);
    }

    public static void main(String[] args) {

        CircleArea c1 = new CircleArea();
        CircleArea c2 = new CircleArea(6.5);

        c1.displayRadius();
        c2.displayRadius();
    }
}
