package co.edu.uniquindio;

import java.util.Stack;

//En la navegación web, los usuarios necesitan poder retroceder a páginas anteriores.
// Para este propósito, se usará un Stack, que funciona como una pila LIFO (Last In, First Out).
// Cada vez que el usuario visite una nueva página, esta se añadirá a la pila, y cuando decida volver atrás,
// se eliminará la última página visitada para regresar a la anterior.
public class Ejercicio9 {
    public static void main(String[] args) {
        Stack<String> historial = new Stack<>();

        // Visitar páginas
        historial.push("www.google.com");
        historial.push("www.wikipedia.org");
        historial.push("www.github.com");

        // Ir atrás
        System.out.println("Retrocediendo a: " + historial.pop());

        System.out.println("Página actual: " + historial.peek());
    }
}
