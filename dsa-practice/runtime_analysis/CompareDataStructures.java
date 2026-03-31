package runtime_analysis;
import java.util.*;

public class CompareDataStructures {

    // Array Linear Search - O(N)
    public static boolean arraySearch(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] datasetSizes = {1000, 100000, 1_000_000};
        int target = -1; // Worst-case: element not present

        for (int size : datasetSizes) {

            int[] array = new int[size];
            Set<Integer> hashSet = new HashSet<>();
            Set<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            // Array Search
            long startArray = System.nanoTime();
            arraySearch(array, target);
            long endArray = System.nanoTime();

            // HashSet Search
            long startHashSet = System.nanoTime();
            hashSet.contains(target);
            long endHashSet = System.nanoTime();

            // TreeSet Search
            long startTreeSet = System.nanoTime();
            treeSet.contains(target);
            long endTreeSet = System.nanoTime();

            System.out.println("Dataset Size: " + size);
            System.out.println("Array Search Time: " + (endArray - startArray) / 1_000_000.0 + " ms");
            System.out.println("HashSet Search Time: " + (endHashSet - startHashSet) / 1_000_000.0 + " ms");
            System.out.println("TreeSet Search Time: " + (endTreeSet - startTreeSet) / 1_000_000.0 + " ms");
            System.out.println();
        }
    }
}

