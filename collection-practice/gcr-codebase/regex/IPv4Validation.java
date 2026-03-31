package regex;
public class IPv4Validation {

    private static final String IPV4_REGEX = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}" + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

    public static boolean isValid(String ip) {
        return ip != null && ip.matches(IPV4_REGEX);
    }

    public static void main(String[] args) {

        String ip = "129.102.17.10";
        System.out.println(isValid(ip));
    }
}

