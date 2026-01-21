package interfaces;
import java.util.*;

public class SetToSortedList {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 1, 4, 2));
        Set<Integer> sortedSet = new TreeSet<>(set);
        List<Integer> sortedList = new ArrayList<>(sortedSet);
        System.out.println(sortedList);
    }
}
