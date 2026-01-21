public class DefangIpAddress {

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {

        String str = "1.1.1.1";
        System.out.println(defangIPaddr(str));
    }
}
