package co.edu.uniquindio;

import java.util.Stack;

//Cree una pila (Stack) que pueda almacenar objetos de diferentes tipos
// y que solo permite insertar elementos si el tipo del objeto coincide con
// el tipo del elemento en la cima de la pila.
public class Ejercicio2 {
    public static void main(String[] args) {
        PilaDinamica pila = new PilaDinamica();
        pila.push(10);
        pila.push(20);
        pila.push("Hola"); // Error
        pila.mostrarPila();
    }
}

// Implementación de Stack genérico con restricción de tipo
class PilaDinamica {
    Stack<Object> pila = new Stack<>();

    public void push(Object obj) {
        if (pila.isEmpty() || pila.peek().getClass().equals(obj.getClass())) {
            pila.push(obj);
        } else {
            System.out.println("Error: El tipo del nuevo elemento no coincide con el de la cima de la pila.");
        }
    }

    public void mostrarPila() {
        System.out.println(pila);
    }
}