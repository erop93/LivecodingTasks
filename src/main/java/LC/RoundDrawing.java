package LC;

public class Car {

    public static void main(String[] args) {
        System.out.println(printCircle(5));
        System.out.println(printCircle(10));
        System.out.println(printCircle(4));
        System.out.println(printCircle(16));
    }


    public static String printCircle(int radius) {
        StringBuilder result = new StringBuilder();
        int diameter = 2 * radius;

        for (int y = 0; y <= diameter; y++) {
            for (int x = 0; x <= diameter; x++) {
                int dx = x - radius;
                int dy = y - radius;
                // Проверка на принадлежность точки окружности
                if (dx * dx + dy * dy <= radius * radius) {
                    result.append("*");
                } else {
                    result.append(" ");
                }
            }
            result.append("\n"); // Новая строка после каждой строки круга
        }

        return result.toString();
    }
}
