public class MergeTwoJSON {

    public static void main(String[] args) {

        String json1 = "{ \"name\": \"Steve\", \"email\": \"steve@gmail.com\" }";
        String json2 = "{ \"age\": 21, \"city\": \"Delhi\" }";

        String merged = json1.substring(0, json1.length() - 1) + ", " + json2.substring(1);

        System.out.println(merged);
    }
}
