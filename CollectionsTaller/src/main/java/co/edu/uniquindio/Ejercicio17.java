package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.TreeMap;

//En una agenda de eventos, es fundamental organizar las actividades
// según su fecha de realización. Para cumplir con este requerimiento,
// se usará un TreeMap, que almacenará los eventos con sus respectivas
// fechas como clave, garantizando que siempre se mantengan ordenados
// cronológicamente y permitiendo acceder de manera eficiente al evento más próximo.
public class Ejercicio17 {
    public static void main(String[] args) {
        TreeMap<LocalDate, String> eventos = new TreeMap<>();

        eventos.put(LocalDate.of(2025, 3, 15), "Conferencia de Tecnología");
        eventos.put(LocalDate.of(2025, 2, 10), "Reunión de Negocios");

        System.out.println("Próximo evento: " + eventos.firstEntry());
    }
}
