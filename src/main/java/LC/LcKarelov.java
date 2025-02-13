import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LcKarelov {

}

class Sale {
    String productName;
    String category;
    double price;
    int quantity;

    Sale(String productName, String category, double price, int quantity) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public double getTotalSale() {
        return price * quantity;
    }

    //
//### Задача: Анализ продаж
//**Условие:** Дано список объектов класса `Sale`, представляющего информацию о продажах.
// Каждый объект содержит данные о названии продукта, категории, цене и количестве. Напишите программу, которая:
//
//            1. Сгруппирует продажи по категории продукта и
//            для каждой категории вычислит общую сумму продаж (цена * количество).
//            2. Отфильтрует категории, у которых сумма продаж больше 100.
//            3. Отсортирует оставшиеся категории по общей сумме продаж в порядке убывания.
//            4. Выведет название категории и общую сумму продаж для оставшихся категорий.
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("Laptop", "Electronics", 1000, 1),
                new Sale("Smartphone", "Electronics", 500, 2),
                new Sale("Chair", "Furniture", 150, 5),
                new Sale("Desk", "Furniture", 300, 1),
                new Sale("Pen", "Stationery", 1, 100),
                new Sale("Notebook", "Stationery", 2, 50)
        );

        Map<String, Double> totalSalesByCategory = sales.stream()
                .collect(Collectors.groupingBy(Sale::getCategory, Collectors.summingDouble(Sale::getTotalSale)));
        System.out.println(totalSalesByCategory);

        Map<String, Double> filteredSale = totalSalesByCategory.entrySet().stream()
                .filter(entry -> entry.getValue() > 100)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        filteredSale.forEach((category, total) ->
                System.out.println("Filtered Category: " + category + ", Total Sales: " + total));

        List<Map.Entry<String, Double>> sortedSale = filteredSale.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());
        sortedSale.forEach(entry ->
                System.out.println("Sorted Category: " + entry.getKey() + ", Total Sales: " + entry.getValue()));

        sortedSale.forEach(entry ->
                System.out.println("Category: " + entry.getKey() + ", Total Sales: " + entry.getValue()));
    }
}

@Data
@AllArgsConstructor
class Author {
    private String name;

    private List<Book> books;

    public static void main(String[] args) {
        Book jamesBond = new Book("James Bond", 2001);
        Book jamesBond2 = new Book("James Bond2", 2003);
        Book jamesBond3 = new Book("James Bond3", 2008);
        Book jamesBond4 = new Book("James Bond4", 2011);
        Author author1 = new Author("Ian Fleming", List.of(jamesBond, jamesBond2, jamesBond3, jamesBond4));

        Book garryPotter = new Book("Garry Potter", 2001);
        Book garryPotter2 = new Book("Garry Potter2", 2003);
        Book garryPotter3 = new Book("Garry Potter3", 2008);
        Book garryPotter4 = new Book("Garry Potter4", 2011);
        Author author2 = new Author("Joanne Rowling", List.of(garryPotter, garryPotter2, garryPotter3, garryPotter4));

        // вывести список названий книг авторов написанных после 2005
        Stream.of(author1, author2)
                .flatMap(author -> author.getBooks().stream())
                .filter(book -> book.getYear() > 2005)
                .map(Book::getName)
                .forEach(System.out::println);

    }
}

@Data
@AllArgsConstructor
class Book {
    private String name;
    private Integer year;
}


@Data
@AllArgsConstructor
class Client {
    Integer id;
    String name;
    Integer age;
    List<Phone> phones;

    public static void main(String[] args) {
        Phone phone1 = new Phone(1234567L, Phone.PhoneType.MOBIL);
        Phone phone2 = new Phone(321434L, Phone.PhoneType.STATIONARY);
        Phone phone3 = new Phone(4214L, Phone.PhoneType.MOBIL);
        Client firstClient = new Client(1, "first client", 25, List.of(phone1, phone2, phone3));
        Phone phone4 = new Phone(1234567L, Phone.PhoneType.MOBIL);
        Client secondClient = new Client(2, "second client", 48, List.of(phone4));
        Phone phone5 = new Phone(1234567L, Phone.PhoneType.MOBIL);
        Phone phone6 = new Phone(1234567L, Phone.PhoneType.STATIONARY);
        Client thirdClient = new Client(3, "third client", 48, List.of(phone5, phone6));
        //Найти самого возрастного клиента, которой пользуется стационарным телефоном
        List<Client> list = List.of(firstClient, secondClient, thirdClient);

        Client oldestWithStationary = list.stream()
                .filter(client -> client.getPhones().stream()
                        .anyMatch(phone -> phone.getType() == Phone.PhoneType.STATIONARY))
                .max(Comparator.comparing(client -> client.getAge()))
                .orElse(null);
    }
}

@Data
@AllArgsConstructor
class Phone {
    Long number;
    PhoneType type;

    enum PhoneType {
        STATIONARY,
        MOBIL
    }
}


@AllArgsConstructor
@Data
class Student {
    private String name; // имя
    private int age; // возраст
    private double grade; // оценка (0-100)
    private String major; // специальность

    //1. Отфильтровать студентов, старше 18 лет.
    //2. Группировать студентов по специальности и найти среднюю оценку для каждой специальности.
    //3. Отсортировать специальности по средней оценке в порядке убывания.
    //4. Вернуть результат как `Map`, где ключом является специальность, а значением — средняя оценка.
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 20, 85, "Computer Science"),
                new Student("Bob", 17, 90, "Mathematics"),
                new Student("Charlie", 22, 70, "Computer Science"),
                new Student("Dave", 19, 60, "Mathematics"),
                new Student("Eve", 21, 95, "Physics"),
                new Student("Frank", 24, 80, "Physics")
        );

        List<Student> older18 = students.stream()
                .filter(student -> student.getAge() > 18)
                .collect(Collectors.toList());
        System.out.println(older18);

        Map<String, Double> majorAndAvgGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, Collectors.summingDouble(Student::getGrade)));
        System.out.println(majorAndAvgGrade);

        List<Map.Entry<String, Double>> sortedByGrade = majorAndAvgGrade.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());
        System.out.println("Majors sorted by average grade:");
        sortedByGrade.forEach(entry ->
                System.out.println("Major: " + entry.getKey() + ", Average Grade: " + entry.getValue()));

        Map<String, Double> sortedGradeMap = majorAndAvgGrade.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println("Sorted average grade map:");
        sortedGradeMap.forEach((major, avgGrade) ->
                System.out.println("Major: " + major + ", Average Grade: " + avgGrade));


    }
}

@AllArgsConstructor
@Data
class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> items;

    //У вас есть интернет-магазин, который продаёт различные товары.
    // Вам дан список заказов, где каждый заказ содержит информацию о клиенте,
    // купленных товарах и их количестве. Нужно провести анализ продаж и выполнить несколько задач:
    //
    //1) Найти топ-3 самых популярных товаров (по количеству проданных единиц).
    //2) Вычислить общую сумму выручки по каждому клиенту.
    //3)Сгруппировать товары по категориям и вывести список товаров в каждой категории,
    // отсортированный по количеству продаж.
    //4)Определить, есть ли клиенты, купившие товары из более чем одной категории.
    public static void main(String[] args) {
        // Пример данных
        Product laptop = new Product(1, "Laptop", "Electronics", 1000);
        Product mouse = new Product(2, "Mouse", "Electronics", 20);
        Product chair = new Product(3, "Chair", "Furniture", 50);
        Product table = new Product(4, "Table", "Furniture", 150);
        Product notebook = new Product(5, "Notebook", "Stationery", 5);
        List<Order> orders = List.of(
                new Order(1, new Customer(1, "Alice"), List.of(
                        new OrderItem(laptop, 1),
                        new OrderItem(mouse, 2)
                )),
                new Order(2, new Customer(2, "Bob"), List.of(
                        new OrderItem(chair, 4),
                        new OrderItem(table, 1)
                )),
                new Order(3, new Customer(1, "Alice"), List.of(
                        new OrderItem(notebook, 10),
                        new OrderItem(laptop, 3)
                ))
        );

        orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.groupingBy(item -> item.getProduct(), Collectors.summingInt(OrderItem::getQuantity)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        Map<String, Double> collect = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer().getName(),
                        Collectors.summingDouble(order -> order.getItems().stream()
                                .mapToDouble(orderItem -> orderItem.getProduct().getPrice() * orderItem.getQuantity())
                                .sum()
                        )));
        System.out.println(collect);

        //4)Определить, есть ли клиенты, купившие товары из более чем одной категории.
        Map<Customer, Set<String>> collect1 = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer(), Collectors.flatMapping(
                        order -> order.getItems().stream().map(orderItem -> orderItem.getProduct().getCategory()),
                        Collectors.toSet()
                )));
        collect1.entrySet().stream()
                .filter(customerSetEntry -> customerSetEntry.getValue().size() > 1)
                .map(customerSetEntry -> customerSetEntry.getKey())
                .forEach(System.out::println);

        //3)Сгруппировать товары по категориям и вывести список товаров в каждой категории,

        Map<String, Set<String>> collect2 = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.groupingBy(item -> item.getProduct().getCategory(),
                        Collectors.mapping(orderItem -> orderItem.getProduct().getName(), Collectors.toSet())
                ));
        System.out.println(collect2);
    }
}

@AllArgsConstructor
@Data
class Customer {
    private int id;
    private String name;
}

@AllArgsConstructor
@Data
class OrderItem {
    private Product product;
    private int quantity;
}

@AllArgsConstructor
@Data
class Product {
    private int id;
    private String name;
    private String category;
    private double price;


    static boolean isOpenStatus(String status) {
        return "OPEN".equals(status);
    }

    // Напишите программу, чтобы найти второе по величине число в массиве

    public static void main(String[] args) {
        int[] numbersArray = {10, 15, 32, 100, -99, 11, 98, 36, 95, 33, 100}; //98
        int[] numbersArray1 = {10, 15, 32, 100}; // 32
        int[] numbersArray2 = {-1, -2, -3, -4, -5}; //-2

        int max = numbersArray2[0];
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < numbersArray2.length; i++) {
            if (numbersArray2[i] > max) {
                max = numbersArray2[i];
            }
        }

        for (int j = 0; j < numbersArray2.length; j++) {
            if (numbersArray2[j] > secondMax && numbersArray2[j] < max) {
                secondMax = numbersArray2[j];
            }
        }
        System.out.println(max);
        System.out.println(secondMax);

    }
}
