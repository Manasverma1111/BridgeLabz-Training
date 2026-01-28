import java.util.PriorityQueue;

class InvalidBackupPathException extends Exception {
    InvalidBackupPathException(String message) {
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask> {

    int priority;
    String folderPath;

    BackupTask(int priority, String folderPath) {
        this.priority = priority;
        this.folderPath = folderPath;
    }

    @Override
    public int compareTo(BackupTask other) {
        return other.priority - this.priority;
    }
}

class BackupScheduler {

    PriorityQueue<BackupTask> queue = new PriorityQueue<>();

    void addBackupTask(int priority, String folderPath) throws InvalidBackupPathException {

        if (folderPath == null || folderPath.isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path");
        }

        queue.add(new BackupTask(priority, folderPath));
        System.out.println("Backup task added for " + folderPath);
    }

    void executeBackups() {

        while (!queue.isEmpty()) {
            BackupTask task = queue.poll();
            System.out.println("Backing up folder " + task.folderPath + " (Priority " + task.priority + ")");
        }
    }
}

public class FileBackupScheduler {

    public static void main(String[] args) {

        BackupScheduler scheduler = new BackupScheduler();

        try {
            scheduler.addBackupTask(2, "/documents");
            scheduler.addBackupTask(5, "/system");
            scheduler.addBackupTask(1, "/media");

        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        scheduler.executeBackups();
    }
}
