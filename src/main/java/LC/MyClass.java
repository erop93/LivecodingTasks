import LC.Customer;
import LC.Order;
import LC.OrderItem;
import LC.Product;

import java.util.*;
import java.util.stream.Collectors;

public class MyClass {

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1, "Laptop", "Electronics", 1200),
                new Product(2, "Smartphone", "Electronics", 800),
                new Product(3, "Desk", "Furniture", 150),
                new Product(4, "Chair", "Furniture", 100),
                new Product(5, "Headphones", "Electronics", 200)
        );

        List<String> topProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(2)
                .map(Product::getName)
                .toList();
        System.out.println(topProducts);




        List<Customer> customers = List.of(
                new Customer(1, "Alice"),
                new Customer(2, "Bob"),
                new Customer(3, "Charlie")
        );

        List<Order> orders = List.of(
                new Order(1, customers.get(0), List.of(
                        new OrderItem(new Product(1, "Laptop", "Electronics", 1200), 1)
                )),
                new Order(2, customers.get(1), List.of(
                        new OrderItem(new Product(2, "Desk", "Furniture", 150), 1)
                ))
        );

        Set<Customer> customersWithOrders = orders.stream()
                .map(Order::getCustomer)
                .collect(Collectors.toSet());
        boolean customerWithoutOrders = customers.stream()
                .anyMatch(customer -> !customersWithOrders.contains(customer));
        System.out.println(customerWithoutOrders);
    }
}
