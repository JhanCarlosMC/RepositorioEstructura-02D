package co.edu.uniquindio;

import java.util.LinkedHashSet;

//En una aplicación de música, los usuarios pueden marcar canciones como favoritas.
// Para garantizar que las canciones favoritas se mantengan en el orden en que
// fueron añadidas sin permitir duplicados, se empleará un LinkedHashSet,
// el cual conservará la secuencia de inserción y asegurará que no haya repeticiones.
public class Ejercicio11 {
    public static void main(String[] args) {
        LinkedHashSet<String> cancionesFavoritas = new LinkedHashSet<>();

        // Agregar canciones
        cancionesFavoritas.add("Bohemian Rhapsody");
        cancionesFavoritas.add("Stairway to Heaven");
        cancionesFavoritas.add("Imagine");

        // Evitar duplicados
        cancionesFavoritas.add("Imagine");

        System.out.println("Lista de canciones favoritas: " + cancionesFavoritas);
    }
}
