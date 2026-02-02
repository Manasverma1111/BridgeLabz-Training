public class QueueOperations {

    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int items;

    public QueueOperations(int size) {

        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    public void enqueue(int value) {

        if (items == maxSize) {
            System.out.println("full");
            return;
        }

        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        items++;
    }

    public int dequeue() {

        if (items == 0) {
            System.out.println("empty");
            return -1;
        }
        int temp = queueArray[front];
        front = (front + 1) % maxSize;
        items--;
        return temp;
    }

    public void display() {

        if (items == 0) {
            System.out.println("empty");
            return;
        }

        System.out.print("");
        for (int i = 0; i < items; i++) {
            System.out.print(queueArray[(front + i) % maxSize] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        QueueOperations queue = new QueueOperations(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.display();
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.display();
    }

}
