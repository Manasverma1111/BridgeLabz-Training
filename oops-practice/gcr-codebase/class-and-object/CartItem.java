class CartItem {

    String itemName;
    double price;
    int quantity;
//    method to add item to cart
    void addItem(int qty) {

        quantity = quantity + qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }
//    method to remove item from cart
    void removeItem(int qty) {

        if (quantity >= qty) {
            quantity = quantity - qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Not enough items to remove.");
        }
    }
//    method to display total cost
    void displayTotalCost() {

        double totalCost = price * quantity;
        System.out.println("Total cost: $" + totalCost);
    }

    public static void main(String[] args) {

        CartItem cart = new CartItem();

        cart.itemName = "Laptop";
        cart.price = 999.99;
        cart.quantity = 1;

        System.out.println("Item: " + cart.itemName + ", Price: $" + cart.price + ", Quantity: " + cart.quantity);

        cart.addItem(2);
        cart.removeItem(1);
        cart.displayTotalCost();
    }
}
