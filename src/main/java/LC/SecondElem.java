import java.util.*;
import java.util.stream.Collectors;

public class SecondElem {
//    Дана строка в нижнем регистре с встречающейся несколько раз последовательностью "hi".
//    Найти общее число таких последовательностей в строке.
    public static void main(String[] args) {
        String str = "xxhixxxxhihi";

        int count = 0;
        String target = "hi";

        for (int i = 0; i <= str.length() - target.length(); i++) {
            if (str.substring(i, i + target.length()).equals(target)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
