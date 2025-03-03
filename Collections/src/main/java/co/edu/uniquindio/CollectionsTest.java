package co.edu.uniquindio;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 5, 6));

        System.out.println(Collections.min(numbers));
        System.out.println(Collections.max(numbers));

        Collections.sort(numbers);
        System.out.println(numbers);

        int index = Collections.binarySearch(numbers, 6);
        System.out.println(index);

        int freq = Collections.frequency(numbers,1);
        System.out.println(freq);
    }
}
