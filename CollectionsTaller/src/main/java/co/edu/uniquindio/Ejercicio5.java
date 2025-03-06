package co.edu.uniquindio;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

//Crear una lista de productos de tipo HashMap,
// otra lista de tipo LinkedHashMap y otra de tipo TreeMap y explicar las diferencias de cada una.
public class Ejercicio5 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        hashMap.put(3, "Tres");
        hashMap.put(1, "Uno");
        hashMap.put(2, "Dos");

        linkedHashMap.put(3, "Tres");
        linkedHashMap.put(1, "Uno");
        linkedHashMap.put(2, "Dos");

        treeMap.put(3, "Tres");
        treeMap.put(1, "Uno");
        treeMap.put(2, "Dos");

        System.out.println("HashMap (orden impredecible): " + hashMap);
        System.out.println("LinkedHashMap (orden de inserción): " + linkedHashMap);
        System.out.println("TreeMap (orden natural): " + treeMap);
    }
}
