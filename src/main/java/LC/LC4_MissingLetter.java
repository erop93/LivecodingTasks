package LC;

public class LC4 {
    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));

    }

    private static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] != 1) {
                return (char) (array[i] + 1);
            }
        }
        throw new IllegalArgumentException("No missing letter");
    }
}


/**
 * Напишите метод, который принимает на вход массив последовательных (возрастающих) букв
 * и возвращает недостающую букву в массиве.
 * <p>
 * Вы всегда получите действительный массив.
 * И всегда будет отсутствовать ровно одна буква.
 * Длина массива всегда будет не менее 2.
 * <p>
 * Массив всегда будет содержать буквы только в одном регистре.
 * <p>
 * Пример:
 * ['a','b','c','d','f'] -> 'e'
 * ['O','Q','R','S'] -> 'P'
 */