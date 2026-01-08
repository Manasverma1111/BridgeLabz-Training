package linkedlist;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskScheduler {
    private TaskNode head;
    private TaskNode current;

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        TaskNode temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeByTaskId(int id) {
        if (head == null) return;

        TaskNode curr = head;
        TaskNode prev = null;

        do {
            if (curr.taskId == id) {
                if (curr == head) {
                    TaskNode temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println(current.taskId + " | " +current.taskName + " | Priority: " + current.priority + " | Due: " + current.dueDate);

        current = current.next;
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode temp = head;
        do {
            System.out.println(temp.taskId + " | " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println(
                        temp.taskId + " | " +
                                temp.taskName + " | Due: " +
                                temp.dueDate
                );
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {

        CircularTaskScheduler scheduler = new CircularTaskScheduler();

        scheduler.addAtEnd(101, "Design Module", 1, "10-Apr-2026");
        scheduler.addAtEnd(102, "Write Code", 2, "12-Apr-2026");
        scheduler.addAtBeginning(100, "Requirement Analysis", 1, "08-Apr-2026");
        scheduler.addAtPosition(2, 103, "Testing", 3, "15-Apr-2026");

        System.out.println("All Tasks:");
        scheduler.displayTasks();

        System.out.println("\nCurrent Task Execution:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearch by Priority (1):");
        scheduler.searchByPriority(1);

        System.out.println("\nRemoving Task ID 102");
        scheduler.removeByTaskId(102);

        System.out.println("\nUpdated Task List:");
        scheduler.displayTasks();
    }
}
