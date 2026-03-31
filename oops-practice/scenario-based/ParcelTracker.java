class ParcelStage {

    String stage;
    ParcelStage next;

    ParcelStage(String stage) {
        this.stage = stage;
        this.next = null;
    }
}

public class ParcelTracker {

    private ParcelStage head;

    public void addStage(String stage) {
        ParcelStage newNode = new ParcelStage(stage);

        if (head == null) {
            head = newNode;
            return;
        }

        ParcelStage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addCheckpoint(String afterStage, String newStage) {
        ParcelStage temp = head;

        while (temp != null) {
            if (temp.stage.equals(afterStage)) {
                ParcelStage checkpoint = new ParcelStage(newStage);
                checkpoint.next = temp.next;
                temp.next = checkpoint;
                return;
            }
            temp = temp.next;
        }
    }

    public void trackParcel() {
        ParcelStage temp = head;

        if (temp == null) {
            System.out.println("Parcel lost or not found.");
            return;
        }

        while (temp != null) {
            System.out.println(temp.stage);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        tracker.addCheckpoint("Shipped", "Customs Check");
        tracker.trackParcel();
    }
}
