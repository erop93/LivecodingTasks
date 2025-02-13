package LC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LiveCoding {
    /*
Что будет результатом? (выбрать один)
a) 70.0 50.0
b) 50.0 70.0 50.0
c) 1, 50.0 5, 70.0 7, 50.0
d) 5, 70.0 7, 50.0
e) ничего не будет выведено
     */
    public static void main(String[] args) {
        List<Order1> orders = List.of(
                new Order1(1, 50),
                new Order1(5, 70),
                new Order1(7, 70));
        Map<Double, List<Order1>> collect = orders.stream()
                .collect(Collectors.groupingBy(Order1::amount));
        collect.forEach((source, r) -> System.out.print(source + " "));


        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Alex", "Charlie");
        String names2 = names.stream()
                .filter(name -> name.startsWith("A"))
                .sorted(Comparator.comparingInt(String::length))
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println(names2);
    }
}

record Order1 (long orderId,
             double amount) {
}
