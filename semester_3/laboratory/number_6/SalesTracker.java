import java.util.*;

public class SalesTracker {
    private LinkedHashMap<String, Integer> salesMap;
    private double totalRevenue;

    public SalesTracker() {
        salesMap = new LinkedHashMap<>();
        totalRevenue = 0.0;
    }

    public void addSale(String productName, double price) {
        salesMap.put(productName, salesMap.getOrDefault(productName, 0) + 1);
        totalRevenue += price;
    }

    public void printAllSales() {
        if (salesMap.isEmpty()) {
            System.out.println("Пока нет продаж.");
            return;
        }
        System.out.println("Список проданных товаров");
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product + " " + quantity);
        }
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public String getMostPopularProduct() {
        if (salesMap.isEmpty()) {
            return "Нет продаж";
        }
        String mostPopular = null;
        int maxSales = 0;
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        tracker.addSale("Яблоки", 50.0);
        tracker.addSale("Хлеб", 30.0);
        tracker.addSale("Молоко", 70.0);
        tracker.addSale("Яблоки", 50.0);
        tracker.addSale("Шоколад", 90.0);
        tracker.addSale("Хлеб", 30.0);
        tracker.addSale("Кофе", 150.0);
        tracker.addSale("Молоко", 70.0);
        tracker.addSale("Яблоки", 50.0);
        tracker.printAllSales();
        System.out.println("Общая сумма продаж: " + tracker.getTotalRevenue() + " руб");
        System.out.println("Самый популярный товар: " + tracker.getMostPopularProduct());
    }
}