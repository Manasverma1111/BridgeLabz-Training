package interfaces;

class CircularBufferSimulation {
    int[] buffer;
    int size, front = 0, rear = 0, count = 0;

    CircularBufferSimulation(int size) {
        this.size = size;
        buffer = new int[size];
    }

    void insert(int x) {
        buffer[rear] = x;
        rear = (rear + 1) % size;

        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size; // overwrite oldest
        }
    }

    void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBufferSimulation cb = new CircularBufferSimulation(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();

        cb.insert(4);
        cb.display();
    }
}

