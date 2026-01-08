package linkedlist;

class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManager {
    private ItemNode head;

    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode newNode = new ItemNode(id, name, qty, price);
        ItemNode temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void removeByItemId(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        ItemNode prev = head;
        ItemNode curr = head.next;

        while (curr != null) {
            if (curr.itemId == id) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchById(int id) {
        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    public void calculateTotalValue() {
        ItemNode temp = head;
        double total = 0;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    public void displayInventory() {
        ItemNode temp = head;

        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(ItemNode item) {
        System.out.println(item.itemId + " | " + item.itemName + " | Qty: " + item.quantity + " | Price: " + item.price);
    }

    public void sortByName(boolean ascending) {
        head = mergeSort(head, true, ascending);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, false, ascending);
    }

    private ItemNode mergeSort(ItemNode node, boolean byName, boolean asc) {
        if (node == null || node.next == null) return node;

        ItemNode mid = getMiddle(node);
        ItemNode nextOfMid = mid.next;
        mid.next = null;

        ItemNode left = mergeSort(node, byName, asc);
        ItemNode right = mergeSort(nextOfMid, byName, asc);

        return sortedMerge(left, right, byName, asc);
    }

    private ItemNode sortedMerge(ItemNode a, ItemNode b, boolean byName, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (byName) {
            condition = asc ?
                    a.itemName.compareToIgnoreCase(b.itemName) <= 0 :
                    a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = sortedMerge(a.next, b, byName, asc);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, byName, asc);
            return b;
        }
    }

    private ItemNode getMiddle(ItemNode node) {
        if (node == null) return node;

        ItemNode slow = node;
        ItemNode fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager inv = new InventoryManager();

        inv.addAtEnd(101, "Laptop", 5, 55000);
        inv.addAtEnd(102, "Mouse", 20, 500);
        inv.addAtBeginning(100, "Keyboard", 10, 1200);
        inv.addAtPosition(2, 103, "Monitor", 7, 9000);

        System.out.println("Inventory:");
        inv.displayInventory();

        System.out.println("\nSearch by ID:");
        inv.searchById(102);

        System.out.println("\nUpdate Quantity:");
        inv.updateQuantity(101, 8);
        inv.displayInventory();

        System.out.println("\nTotal Value:");
        inv.calculateTotalValue();

        System.out.println("\nSort by Name (Ascending):");
        inv.sortByName(true);
        inv.displayInventory();

        System.out.println("\nSort by Price (Descending):");
        inv.sortByPrice(false);
        inv.displayInventory();
    }
}
