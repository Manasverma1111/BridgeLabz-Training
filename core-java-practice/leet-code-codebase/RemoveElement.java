import java.util.Scanner;

class removeElement {
    public int removeElmt(int[] nums, int val) {
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter the value to remove:");
        int val = scanner.nextInt();

        removeElement solution = new removeElement();
        int newLength = solution.removeElmt(nums, val);

        System.out.println("The new length of the array is: " + newLength);
        System.out.println("The modified array is:");
        for(int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
