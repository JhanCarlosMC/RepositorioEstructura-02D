package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String[] args) {
        List<String> listElements = new ArrayList<>();
        listElements.add("Manzana");
        listElements.add("Banana");
        listElements.add("Cereza");

        ListIterator<String> listIterator = listElements.listIterator();

        // Iterar hacia adelante
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            System.out.println("Elemento: " + element);
        }

        // Iterar hacia atrás
        while (listIterator.hasPrevious()) {
            String element = listIterator.previous();
            System.out.println("Elemento: " + element);
        }

        // Modificar la lista durante la iteración
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            if (element.equals("Banana")) {
                listIterator.set("Naranja"); //Reemplaza
            }
        }

        // Eliminar elemento de la lista durante la iteración
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            if (element.equals("Cereza")) {
                listIterator.remove();  //Elimina
            }
        }

        System.out.println("---");
        System.out.println(listIterator);
        System.out.println(listElements);
    }
}
