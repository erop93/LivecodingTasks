package LC;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Class {

    public static void main(String[] args) {
        Comparator<PersonRecord> personSurnameReversedComparator = (o1, o2) -> {
            String surname1 = o1.fullName().split(" ")[1];
            String surname2 = o2.fullName().split(" ")[1];
            return -surname1.compareTo(surname2);
        };
        Comparator<PersonRecord> personNameReversedComparator = (o1, o2) -> {
            String name1 = o1.fullName().split(" ")[0];
            String name2 = o2.fullName().split(" ")[0];
            return -name1.compareTo(name2);
        };
        getPersonList().stream()
                .sorted(personSurnameReversedComparator.thenComparing(personNameReversedComparator))
                .filter(personRecord -> personRecord.age() > 30)
                .forEach(System.out::println);


        List<PersonRecord> sortedFilteredList = getPersonList().stream()
                .filter(person -> person.age() > 30) // Фильтруем тех, кто старше 30 лет
                .sorted((p1, p2) -> { // Сортировка
                    String[] p1NameParts = p1.fullName().split(" ");
                    String[] p2NameParts = p2.fullName().split(" ");
                    int lastNameCompare = p2NameParts[1].compareTo(p1NameParts[1]); // Сравнение по фамилии (обратный порядок)
                    if (lastNameCompare != 0) {
                        return lastNameCompare;
                    }
                    return p1NameParts[0].compareTo(p2NameParts[0]); // Сравнение по имени (прямой порядок)
                })
                .collect(Collectors.toList());

        sortedFilteredList.forEach(System.out::println);
    }


    private static List<PersonRecord> getPersonList() {
        PersonRecord p1 = new PersonRecord(1, "John Smith", 40);
        PersonRecord p2 = new PersonRecord(2, "Jack Daniels", 35);
        PersonRecord p3 = new PersonRecord(3, "Sam Smith", 15);
        PersonRecord p4 = new PersonRecord(4, "Tom Holland", 25);
        PersonRecord p5 = new PersonRecord(5, "Tom Cruise", 60);

        return List.of(p1, p2, p3, p4, p5);
    }
}

record PersonRecord(long personId,
                    String fullName, int age) {
}
//выполнить сортировку по фамилии в обратном порядке, затем по имени,
//взять тех, кто старше 30 лет