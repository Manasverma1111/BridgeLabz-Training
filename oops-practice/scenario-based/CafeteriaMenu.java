import java.util.Scanner;

public class CafeteriaMenu {
//    displays the cafeteria menu
    public static void displayMenu(String[] items) {

        System.out.println("Campus Cafeteria Menu");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + " : " + items[i]);
        }
    }
//    returns item name based on index
    public static String getItemByIndex(String[] items, int index) {

        if (index < 0 || index >= items.length) {
            return "Invalid selection";
        }
        return items[index];
    }

    public static void main(String[] args) {

        String[] menuItems = {"Veg Sandwich", "Cheese Burger", "Pasta", "Fried Rice", "Paneer Roll", "Masala Dosa", "French Fries", "Cold Coffee", "Tea", "Ice Cream"};
        Scanner sc = new Scanner(System.in);

        displayMenu(menuItems);

        System.out.print("\nEnter item index to order: ");
        int choice = sc.nextInt();
        String selectedItem = getItemByIndex(menuItems, choice);

        if (!selectedItem.equals("Invalid selection")) {
            System.out.println("You ordered: " + selectedItem);
        } else {
            System.out.println("Please select a valid menu index.");
        }

    }
}
