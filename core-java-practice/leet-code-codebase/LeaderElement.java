import java.util.*;

public class LeaderElement {
    public static void main(String[] args) {
//        create scanner object
        Scanner sc = new Scanner(System.in);
//        gte input values of array
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> ans = findLeader(arr);
        System.out.println("Leader elements");
        for (int elmt : ans) {
            System.out.print(elmt + " ");
        }
        sc.close();
    }
//    function to find leader element
    public static ArrayList<Integer> findLeader(int[] arr) {

        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        int maxFromRight = arr[n - 1];
        res.add(maxFromRight);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                res.add(maxFromRight);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
