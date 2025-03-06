package co.edu.uniquindio;

import java.util.HashMap;

//Un directorio telefónico necesita almacenar nombres junto con sus
// respectivos números de teléfono y permitir búsquedas eficientes.
// Para este caso, se usará un HashMap, el cual asociará cada nombre
// con su número telefónico, posibilitando consultas rápidas y evitando duplicados.
public class Ejercicio15 {
    public static void main(String[] args) {
        HashMap<String, String> contactos = new HashMap<>();

        // Agregar contactos
        contactos.put("Carlos", "3112345678");
        contactos.put("Ana", "3229876543");

        System.out.println("Número de Ana: " + contactos.get("Ana"));
    }
}
