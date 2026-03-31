import java.util.HashSet;

public class JewelsnStones {

    public static int countStones(String jewels, String stones) {

        HashSet<Character> jewelSet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        int count = 0;

        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String jewels = "aA";
        String stones = "aAAbbb";

        int count = countStones(jewels, stones);
        System.out.println(count);
    }
}
