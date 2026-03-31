package linkedlist;

class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;

    ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;
    private int timeQuantum;
    private int currentTime = 0;
    private int processCount = 0;

    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        processCount++;
    }

    private void removeProcess(ProcessNode prev, ProcessNode curr) {
        if (curr == head && curr == tail) {
            head = tail = null;
        } else if (curr == head) {
            head = head.next;
            tail.next = head;
        } else if (curr == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = curr.next;
        }
        processCount--;
    }

    public void displayProcesses() {
        if (head == null) return;

        ProcessNode temp = head;
        do {
            System.out.print("[PID:" + temp.pid + " RT:" + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void execute() {
        if (head == null) return;

        ProcessNode curr = head;
        ProcessNode prev = tail;

        while (processCount > 0) {
            if (curr.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, curr.remainingTime);
                curr.remainingTime -= execTime;
                currentTime += execTime;

                ProcessNode temp = curr.next;
                while (temp != curr) {
                    if (temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                }

                if (curr.remainingTime == 0) {
                    curr.turnaroundTime = currentTime;
                    removeProcess(prev, curr);
                    curr = prev.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }

                displayProcesses();
            }
        }
    }

    public void displayAverageTimes(ProcessNode originalHead) {
        int totalWT = 0;
        int totalTAT = 0;
        int count = 0;

        ProcessNode temp = originalHead;
        do {
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            count++;
            temp = temp.next;
        } while (temp != originalHead);

        System.out.println("Average Waiting Time: " + (double) totalWT / count);
        System.out.println("Average Turnaround Time: " + (double) totalTAT / count);
    }

    public ProcessNode getHead() {
        return head;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        ProcessNode originalHead = scheduler.getHead();

        scheduler.execute();
        scheduler.displayAverageTimes(originalHead);
    }
}

