package future_logistics;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Goods Transport Details");
        String input = sc.nextLine();

        GoodsTransport goodsTransport = Utility.parseDetails(input);
        if (goodsTransport != null) {
            System.out.println("Transport Vehicle: " + goodsTransport.vehicleSelection());
            System.out.println("Total Charge: " + goodsTransport.calculateTotalCharge());
        }
    }
}
