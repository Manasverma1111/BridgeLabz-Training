class Circle {

    double radius;
//    method to calculate area
    double calculateArea() {

        return Math.PI * radius * radius;
    }
//    method to calculate circumference
    double calculateCircumference() {

        return 2 * Math.PI * radius;
    }
//    method to display results
    void displayDetails() {

        System.out.printf("Area of circle: %.4f%n", calculateArea());
        System.out.printf("Circumference of circle: %.4f%n", calculateCircumference());
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.radius = 2.5;
        circle.displayDetails();
    }
}
