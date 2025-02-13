package LC;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int left = 0;                // Левая граница поиска
        int right = array.length - 1; // Правая граница поиска

        while (left <= right) {
            int mid = left + (right - left) / 2; // Находим середину диапазона

            // Проверяем, является ли средний элемент искомым
            if (array[mid] == target) {
                return mid; // Возвращаем индекс найденного элемента
            }

            // Если искомый элемент меньше среднего, ищем в левой части массива
            if (array[mid] > target) {
                right = mid - 1;
            }
            // Если искомый элемент больше среднего, ищем в правой части массива
            else {
                left = mid + 1;
            }
        }

        // Если элемент не найден, возвращаем -1
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;

        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Элемент найден на индексе: " + result);
        } else {
            System.out.println("Элемент не найден");
        }
    }
}