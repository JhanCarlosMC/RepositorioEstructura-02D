package co.edu.uniquindio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

//Crear una lista de elementos que no permite duplicados e imprima el contenido de la lista usando iteradores.
public class Ejercicio3 {
    public static void main(String[] args) {
        LinkedHashSet<String> lista = new LinkedHashSet<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 1"); // No se agregará por ser duplicado

        Iterator<String> iterador = lista.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }
}

