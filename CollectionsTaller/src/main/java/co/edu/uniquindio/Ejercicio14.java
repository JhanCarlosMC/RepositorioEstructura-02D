package co.edu.uniquindio;

import java.util.ArrayDeque;

//En una aplicación de mensajería, se requiere un historial de los últimos mensajes enviados.
// Para lograrlo, se utilizará un ArrayDeque, que permitirá agregar nuevos mensajes
// al final de la estructura y recuperar los últimos diez mensajes enviados de manera rápida y eficiente.
public class Ejercicio14 {
    public static void main(String[] args) {
        ArrayDeque<String> mensajes = new ArrayDeque<>();

        // Agregar mensajes
        mensajes.add("Hola");
        mensajes.add("¿Cómo estás?");
        mensajes.add("Todo bien, gracias.");

        // Recuperar últimos mensajes
        System.out.println("Últimos mensajes: " + mensajes);
    }
}
