package streamAPI;

import java.util.List;

class Stocks {

    String name;
    double price;

    public Stocks(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
public class StockPriceLogger {

    public static void main(String[] args) {

        List<Stocks> stockPrices = List.of(
                new Stocks("Sumitomo", 424.05),
                new Stocks("L&T Finance", 284.85),
                new Stocks("SMC Global", 77.05),
                new Stocks("NTPC Lmtd.", 356.50),
                new Stocks("SAIL", 151.30)
        );

        stockPrices.stream().forEach(n -> System.out.println(n.name + " : " + n.price));

    }
}
