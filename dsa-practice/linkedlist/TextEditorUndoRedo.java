package linkedlist;

class TextStateNode {
    String text;
    TextStateNode prev;
    TextStateNode next;

    TextStateNode(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextStateNode head;
    private TextStateNode tail;
    private TextStateNode current;
    private int size = 0;
    private final int MAX_SIZE = 10;

    public void addState(String text) {
        TextStateNode newNode = new TextStateNode(text);

        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = countNodes();
        }

        if (head == null) {
            head = tail = current = newNode;
            size = 1;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        current = newNode;
        size++;

        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text available.");
            return;
        }
        System.out.println("Current Text: " + current.text);
    }

    private int countNodes() {
        int count = 0;
        TextStateNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class TextEditorUndoRedo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello Java");
        editor.displayCurrentState();
    }
}

