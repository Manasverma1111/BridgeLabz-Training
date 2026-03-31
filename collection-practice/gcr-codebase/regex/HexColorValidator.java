package regex;
public class HexColorValidator {

    public static boolean isValid(String color) {
        return color != null && color.matches("^#[A-Fa-f0-9]{6}$");
    }

    public static void main(String[] args) {

        String color = "#FFA500";
        String color2 = "#ff4500";
        String color3 = "#123";
        System.out.println(isValid(color));
        System.out.println(isValid(color2));
        System.out.println(isValid(color3));
    }
}

