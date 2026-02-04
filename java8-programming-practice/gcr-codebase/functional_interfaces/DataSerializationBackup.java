package functional_interfaces;

interface BackupSerializable {
}

class UserData implements BackupSerializable {
    private String username;
    private String email;

    public UserData(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserData{username='" + username + "', email='" + email + "'}";
    }
}

class TempCache {
    private String cacheData;

    public TempCache(String cacheData) {
        this.cacheData = cacheData;
    }
}

class BackupService {

    public static void backup(Object obj) {

        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up object: " + obj);
        } else {
            System.out.println("Object NOT eligible for backup");
        }
    }
}

public class DataSerializationBackup {

    public static void main(String[] args) {

        UserData user = new UserData("Steve", "steve1248@example.com");
        TempCache cache = new TempCache("session-data");

        BackupService.backup(user);
        BackupService.backup(cache);
    }
}
