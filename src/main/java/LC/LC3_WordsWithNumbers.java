package LC;

import java.util.Arrays;

public class LC3 {
    public static void main(String[] args) {
        System.out.println(order("4of Fo1r pe6ople g3ood th5e the2"));
    }

    private static String order(String words) {
        if (words.isEmpty()) {
            return "";
        }

        String[] wordArray = words.split(" ");
        Arrays.sort(wordArray, (a, b) -> findNumber(a) - findNumber(b));
        return String.join(" ", wordArray);
    }


    private static int findNumber(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                return c - '0';
            }
        }
        return 0;
    }
}

/**
 * Необходимо отсортировать заданную строку.
 * Каждое слово в строке будет содержать одно число.
 * Это число обозначает позицию, которую слово должно занимать в результате.
 * <p>
 * Примечание. Числа могут быть от 1 до 9.
 * Таким образом, первым словом будет 1 (а не 0).
 * <p>
 * Если входная строка пуста, верните пустую строку.
 * <p>
 * Пример:
 * "is2 Thi1s T4est 3a" ---> "Thi1s is2 3a T4est"
 * *"4of Fo1r pe6ople g3ood th5e the2" --> "Fo1r the2 g3ood 4of th5e pe6ople"
 */
