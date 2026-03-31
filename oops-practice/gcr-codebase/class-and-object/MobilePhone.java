class MobilePhone {

    String brand;
    String model;
    double price;
//    method to display mobile details
    void displayDetails() {

        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        MobilePhone mobile1 = new MobilePhone();
        mobile1.brand = "VIVO";
        mobile1.model = "VIVO V29";
        mobile1.price = 15999.0;
        mobile1.displayDetails();

        MobilePhone mobile2 = new MobilePhone();
        mobile2.brand = "ONE PLUS";
        mobile2.model = "ONE PLUS nord4";
        mobile2.price = 39999.0;
        mobile2.displayDetails();

        MobilePhone mobile3 = new MobilePhone();
        mobile3.brand = "APPLE";
        mobile3.model = "iphone pro16";
        mobile3.price = 79999.0;
        mobile3.displayDetails();
    }
}

