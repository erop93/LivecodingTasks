package LC;

import java.util.*;
import java.util.stream.IntStream;

public class LC7 {
/*
new int[] { 20, 37, 20, 21 }, 1
new int[] { 20, 37, 21 }

new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3
new int[] { 1, 1, 3, 3, 7, 2, 2, 2 }

new int [] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3
new int [] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 }

new int[] { 1, 1, 1, 1, 1 }, 5
new int[] { 1, 1, 1, 1, 1 }

new int[] {}, 5
new int[] {}
*/

    public static void main(String[] args) {
        // Примеры тестов
        int[] result1 = new int[]{20, 37, 20, 21}; // Лимит повторений 1
        int[] result2 = new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}; // Лимит повторений 3
        int[] result3 = new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}; // Лимит повторений 3

        System.out.println(Arrays.toString(arrInt(result1, 1)));
        System.out.println(Arrays.toString(arrInt(result2, 3)));
        System.out.println(Arrays.toString(arrInt(result3, 3)));
    }

    static int[] arrInt(int[] array, int num) {
        Map<Integer, Integer> map = new HashMap<>();

        return Arrays.stream(array) // Преобразуем массив в поток IntStream
                .boxed() // Преобразуем IntStream в Stream<Integer>, чтобы работать с объектами
                .peek(num1 -> map.put(num1, map.getOrDefault(num1, 0) + 1))
                // Добавляем текущий элемент в map или увеличиваем его счётчик
                .filter(num1 -> map.get(num1) <= num)
                // Пропускаем элементы, которые превышают заданное количество повторений
                .mapToInt(val -> val) // Преобразуем Stream<Integer> обратно в IntStream
                .toArray(); // Преобразуем IntStream в массив int[]
    }
}

