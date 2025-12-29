import java.util.Scanner;

public class RemoveElement {
    public static int removeElmt(int[] nums, int val) {
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
//        create scanner object
        Scanner scanner = new Scanner(System.in);
//        get input value for n and array
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the value to remove:");
        int val = scanner.nextInt();

        int newLength = removeElmt(nums, val);

        System.out.println("The new length of the array is: " + newLength);
        System.out.println("The modified array is:");
        for(int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
