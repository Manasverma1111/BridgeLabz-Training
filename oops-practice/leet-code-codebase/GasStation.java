public class GasStation {

    public static int canComplete(int[] gas, int[] cost) {

        int start = 0;
        int currGas = 0;
        int totalGas = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];

            currGas += diff;
            totalGas += diff;

            if (currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }

        return (totalGas >= 0) ? start : -1;
    }

    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] cost ={3,4,5,1,2};

        System.out.println(canComplete(gas, cost));
    }
}
