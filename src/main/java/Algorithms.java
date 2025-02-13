package LC;

import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

//      Дан массив и длинна подмассива. Необходимо найти подмассив,
//      среднее значение элементов которого будет максимальным.
//      В данном случае подмассив с максимальным среднем значением является {12,-5,-6,50}
//        (12 - 5 - 6 + 50) / 4 = 12.75

//        Посчитать сумму для 1 подмассива, а для второго прибавить еще 1 элемент и вычесть первый.

        int sum = 0;
        int sumMax = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length + 1 - k; i++) {
            sum = 0;
            for (int j = i; j < k + i; j++) {
                sum = sum + nums[j];
            }
            if (sum > sumMax) {
                sumMax = sum;
                index = i;
            }
        }
        System.out.println(sumMax);
        int[] ints = Arrays.copyOfRange(nums, index, index + k);
        System.out.println(Arrays.toString(ints));


        // проверить что число является палиндромом

        int num = 1221; //true

        int nums2 = num;
        int reverse = 0;

        while (nums2 > 0) {
            int lastDigit = nums2 % 10;
            reverse = reverse * 10 + lastDigit;
            nums2 /= 10;
        }
        System.out.println(reverse == nums2);


        //you will be given a string and two indexes (a and b).
        // Your task is to reverse the portion of that string between those two indices inclusive.
        //The first index a will always be smaller than the string length;
        // the second index b can be greater than the string length. More examples in the test cases. Good luck!

        String string = "Hello, World!";
        int a = 3;
        int b = 6;
        System.out.println(reversePartOfString(string, a, b));

    }

    public static String reversePartOfString(String string, int a, int b) {
        String substring = string.substring(a, b);
        String substringReverse = new StringBuilder(substring).reverse().toString();
        return string.replace(substring, substringReverse);
    }

}
