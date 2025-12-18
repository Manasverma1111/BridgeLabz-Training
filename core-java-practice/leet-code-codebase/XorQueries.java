import java.util.Scanner;

class XorQueries {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pre = new int[n];
        pre[0] = arr[0];

        // Compute prefix XOR array
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ arr[i];
        }

        // Initialize result array
        int[] res = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];

            if (i == 0) {
                res[k] = pre[j];
            } else {
                res[k] = pre[j] ^ pre[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Create a scanner to take input from the user
        Scanner input = new Scanner(System.in);

        // Input the size of the array
        System.out.println("Enter the number of elements in the array:");
        int n = input.nextInt();

        // Create and populate the array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        // Input the number of queries
        System.out.println("Enter the number of queries:");
        int q = input.nextInt();

        // Create and populate the 2D queries array
        int[][] queries = new int[q][2];
        System.out.println("Enter the queries (each query as two integers representing the range):");
        for (int i = 0; i < q; i++) {
            queries[i][0] = input.nextInt();
            queries[i][1] = input.nextInt();
        }

        // Close the scanner
        input.close();

        // Create an instance of the Solution class and get the result
        XorQueries solution = new XorQueries();
        int[] result = solution.xorQueries(arr, queries);

        // Output the result
        System.out.println("Result of XOR queries:");
        for (int res : result) {
            System.out.println(res);
        }
    }
}
