package runtime_analysis;

import java.util.*;

class ConcatenateString {
    public static String concatenateStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println(concatenateStrings(arr));
    }
}

