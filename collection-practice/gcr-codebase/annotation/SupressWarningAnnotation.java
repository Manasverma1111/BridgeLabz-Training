package annotation;
import java.util.ArrayList;

public class SupressWarningAnnotation {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        list.add("Java");
        list.add(100);
        list.add(3.14);

        String language = (String) list.get(0);
        int number = (Integer) list.get(1);

        System.out.println(language);
        System.out.println(number);
    }
}
