package linkedlist;
import java.util.Scanner;

class StudentNode {
    int rollNo;
    String name;
    int age;
    char grade;
    StudentNode next;

    StudentNode(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

class StudentLinkedList {
    StudentNode head;

    void addAtBeginning(int r, String n, int a, char g) {
        StudentNode node = new StudentNode(r, n, a, g);
        node.next = head;
        head = node;
    }

    void addAtEnd(int r, String n, int a, char g) {
        StudentNode node = new StudentNode(r, n, a, g);
        if (head == null) {
            head = node;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    void addAtPosition(int pos, int r, String n, int a, char g) {
        if (pos <= 1) {
            addAtBeginning(r, n, a, g);
            return;
        }
        StudentNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) return;

        StudentNode node = new StudentNode(r, n, a, g);
        node.next = temp.next;
        temp.next = node;
    }

    void deleteByRollNo(int r) {
        if (head == null) return;

        if (head.rollNo == r) {
            head = head.next;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNo != r)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    void searchByRollNo(int r) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == r) {
                display(temp);
                return;
            }
            temp = temp.next;
        }
    }

    void updateGrade(int r, char g) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == r) {
                temp.grade = g;
                return;
            }
            temp = temp.next;
        }
    }

    void displayAll() {
        StudentNode temp = head;
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
    }

    void display(StudentNode s) {
        System.out.println(s.rollNo + " " + s.name + " " + s.age + " " + s.grade);
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        while (true) {
            System.out.println("1.AddBeg 2.AddEnd 3.AddPos 4.Delete 5.Search 6.Update 7.Display 8.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                case 2:
                case 3:
                    int r = sc.nextInt();
                    sc.nextLine();
                    String n = sc.nextLine();
                    int a = sc.nextInt();
                    char g = sc.next().charAt(0);

                    if (ch == 1) list.addAtBeginning(r, n, a, g);
                    else if (ch == 2) list.addAtEnd(r, n, a, g);
                    else list.addAtPosition(sc.nextInt(), r, n, a, g);
                    break;

                case 4:
                    list.deleteByRollNo(sc.nextInt());
                    break;

                case 5:
                    list.searchByRollNo(sc.nextInt());
                    break;

                case 6:
                    list.updateGrade(sc.nextInt(), sc.next().charAt(0));
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    sc.close();
                    return;
            }
        }
    }
}

