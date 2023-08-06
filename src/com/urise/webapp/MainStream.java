package com.urise.webapp;

import java.util.*;
import java.util.stream.Collectors;


public class MainStream {
    public static void main(String[] args) {
        int[] values = new int[]{3, 4, 3, 7};
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(1);
        integers.add(3);
        integers.add(7);
        integers.add(9);
        integers.add(4);
        integers.add(6);
        integers.add(10);
        integers.add(12);
        integers.add(14);
        integers.add(1);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            oddOrEven(integers);
        }
        long end = System.currentTimeMillis();
        System.out.println("MY " + (end - start));
    }

    /**
     * @param values an array (digits 1-9)
     * @return min number consisting of min distinct values
     * not using String
     * Example {1,2,3,3,2,3} return 123; {9,8} return 89
     * Solution without using Streams. Using Horner's scheme:
     * int [] arr = {1, 2, 3, 4, 5};
     * int n = 0;
     * for (int d : arr) {
     * n = 10 * n + d;
     * }
     * System.out.println(n);
     */
    static int minValue(int[] values) {
        OptionalInt result = Arrays.stream(values).distinct().reduce((accum, el) -> 10 * accum + el);
        return result.orElseThrow();
    }

    //Реализовать метод List<Integer> oddOrEven(List<Integer> integers) если сумма всех чисел нечетная -
    // удалить все нечетные, если четная - удалить все четные. Сложность алгоритма должна быть O(N).
    // Optional - решение в один стрим.
    static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream().reduce((accum, el) -> accum + el).get();
        if (sum % 2 == 0) {
            return integers.stream().filter(el -> el % 2 != 0).collect(Collectors.toList());
        }
        return integers.stream().filter(el -> el % 2 == 0).collect(Collectors.toList());
    }
}
