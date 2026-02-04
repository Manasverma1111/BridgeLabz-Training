@FunctionalInterface
interface LightAction {
    void activate();
}

public class SmartHomeLighting {

    public static void main(String[] args) {

        LightAction motionTrigger = () -> System.out.println("Lights ON at full brightness");
        LightAction timeTrigger = () -> System.out.println("Lights ON with warm dim mode");
        LightAction voiceTrigger = () -> System.out.println("Lights set to custom color and brightness");

        executeLight(motionTrigger);
        executeLight(timeTrigger);
        executeLight(voiceTrigger);
    }

    static void executeLight(LightAction action) {
        action.activate();
    }
}
