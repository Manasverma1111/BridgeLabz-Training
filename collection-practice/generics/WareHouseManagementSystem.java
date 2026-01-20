package generics;

import java.util.ArrayList;
import java.util.List;

abstract class WareHouseItem {

    private String name;

    public WareHouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Electronics extends WareHouseItem {

    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WareHouseItem {

    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WareHouseItem {

    public Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WareHouseItem> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

}

class Warehouse {

    public static void display(List<? extends WareHouseItem> items) {

        for (WareHouseItem item : items) {
            System.out.println(item.getName());
        }
    }
}
public class WareHouseManagementSystem {
    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Wheat"));

        furnitureStorage.addItem(new Furniture("Sofa"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics:");
        Warehouse.display(electronicsStorage.getItems());
        System.out.println();
        System.out.println("Groceries:");
        Warehouse.display(groceriesStorage.getItems());
        System.out.println();
        System.out.println("Furniture:");
        Warehouse.display(furnitureStorage.getItems());
    }

}
