package generics;

abstract class Category {

    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class BookCategory extends Category {

    public BookCategory(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

class ClothingCategory extends Category {

    public ClothingCategory(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

class GadgetCategory extends Category {

    public GadgetCategory(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

class Product<T extends Category> {

    private String productName;
    private double price;
    private T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{name='" + productName + "', price=" + price + ", category=" + category.getName() + '}';
    }
}

class Discount {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
    }
}

public class OnlineMarketPlace {

    public static void main(String[] args) {

        BookCategory bookCategory = new BookCategory("Books");
        ClothingCategory clothingCategory = new ClothingCategory("Clothing");
        GadgetCategory gadgetCategory = new GadgetCategory("Gadgets");

        Product<BookCategory> bookProduct = new Product<>("Java Programming", 50.0, bookCategory);
        Product<ClothingCategory> clothingProduct = new Product<>("T-Shirt", 20.0, clothingCategory);
        Product<GadgetCategory> gadgetProduct = new Product<>("Smartphone", 300.0, gadgetCategory);
        System.out.println("Before Discount:");
        System.out.println(bookProduct);
        System.out.println(clothingProduct);
        System.out.println(gadgetProduct);

        Discount.applyDiscount(bookProduct, 10);
        Discount.applyDiscount(clothingProduct, 15);
        Discount.applyDiscount(gadgetProduct, 5);

        System.out.println("\nAfter Discount:");
        System.out.println(bookProduct);
        System.out.println(clothingProduct);
        System.out.println(gadgetProduct);
    }

}
