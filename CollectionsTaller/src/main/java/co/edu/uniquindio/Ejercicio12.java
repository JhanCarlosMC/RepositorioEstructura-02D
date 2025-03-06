package co.edu.uniquindio;

import java.util.TreeSet;

//En una universidad, los nombres de los estudiantes deben mantenerse ordenados alfabéticamente
// para facilitar su búsqueda. Para ello, se utilizará un TreeSet,
// que automáticamente organizará los nombres de los estudiantes
// a medida que se agregan y permitirá obtener fácilmente el primer y el último nombre de la lista.
public class Ejercicio12 {
    public static void main(String[] args) {
        TreeSet<String> estudiantes = new TreeSet<>();

        // Agregar estudiantes
        estudiantes.add("Carlos");
        estudiantes.add("Ana");
        estudiantes.add("Beatriz");

        System.out.println("Estudiantes ordenados: " + estudiantes);
        System.out.println("Primer estudiante: " + estudiantes.first());
        System.out.println("Último estudiante: " + estudiantes.last());
    }
}
