package annotation;

class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature is running (deprecated)");
    }

    public void newFeature() {
        System.out.println("New feature is running");
    }
}

public class DeprecatedAnnotation {

    public static void main(String[] args) {

        LegacyAPI api = new LegacyAPI();

        api.oldFeature();
        api.newFeature();
    }
}
