import java.util.*;

class Order {
    private List<String> productList;
    private String deliveryAddress;
    private int cost;

    public Order(List<String> productList, String deliveryAddress, int cost) {
        this.productList = new ArrayList<>(productList);
        this.deliveryAddress = deliveryAddress;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Заказ: " + productList + " | Адрес доставки: " + deliveryAddress + " | Стоимость заказа: " + cost;
    }
}

public class Main2 {
    public static void main(String[] args) {
        List<String> products1 = Arrays.asList("Ноутбук", "Мышь", "Сумка");
        Order order1 = new Order(products1, "ул. Ленина, 123", 150900);
        List<String> products2 = Arrays.asList("Смартфон", "Чехол");
        Order order2 = new Order(products2, "пр. Мира, 45", 80550);
        List<String> products3 = Arrays.asList("Книга", "Ручка", "Блокнот");
        Order order3 = new Order(products3, "ул. Садовая, 67", 1750);
        Map<Integer, Order> orderMap = new HashMap<>();
        orderMap.put(1, order1);
        orderMap.put(2, order2);
        orderMap.put(3, order3);
        System.out.println(orderMap.get(2));
        orderMap.remove(2);
        System.out.println(orderMap.get(2));
    }
}