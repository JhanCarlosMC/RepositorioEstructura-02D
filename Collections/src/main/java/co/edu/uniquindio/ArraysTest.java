package co.edu.uniquindio;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 5, 6};
        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        Integer[] array1 = {1, 2, 3};
        System.out.println(Arrays.equals(array1, numbers));

        Arrays.fill(array1, 13);
        System.out.println(Arrays.toString(array1));
    }

}
