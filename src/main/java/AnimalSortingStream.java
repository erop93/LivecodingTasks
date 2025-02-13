import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        //Взять всех животных возрастом 20 - 30 лет.
        // Есть ли среди них хоть один из страны Венгрия (Hungarian)?
        //Ответ вывести в консоль

        list.stream()
                .filter(animal -> animal.getAge() > 20 && animal.getAge() < 30)
                .anyMatch(animal -> "Hungarian".equals(animal.getOrigin()));
        boolean hungarianAnimals = false;

//        Отобрать всех животных из Японии (Japanese) и записать породу UPPER_CASE в если пол Female
//        преобразовать к строкам породы животных и вывести в консоль

        list.stream()
                .filter(animal -> "Japanese".equals(animal.getOrigin()))
                .map(animal -> "Female".equals(animal.getGender()) ? animal.getBreed().toUpperCase() : animal.getBreed())
                .forEach(System.out::println);

//        Взять всех животных. Отсортировать их породу в стандартном порядке и взять первые 100.
//        Вывести в консоль возраст самого старого животного

        list.stream()
                .sorted(Comparator.comparing(Animal::getBreed))
                .limit(100)
                .max(Comparator.comparingInt(Animal::getAge))
                .ifPresent(maxAge -> System.out.println(maxAge));


//        Взять всех животных. Преобразовать их в породы, а породы в []char
//        Вывести в консоль длину самого короткого массива

        list.stream()
                .map(animal -> animal.getBreed().toCharArray())
                .min(Comparator.comparingInt(array -> array.length));

    }
}

@Data
class Animal {
    private int id;

    private String breed;

    private int age;

    private String origin;

    private String gender;

    public Animal() {
    }
}
