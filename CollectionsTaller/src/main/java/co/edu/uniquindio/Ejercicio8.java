package co.edu.uniquindio;

import java.util.Vector;

//Un editor de texto necesita registrar los cambios recientes para que el usuario pueda
// deshacerlos cuando sea necesario. Para este caso, se utilizará un Vector,
// ya que permite almacenar los cambios de forma segura en entornos concurrentes.
// Se deberá implementar una función de "deshacer" que elimine el último cambio realizado,
// asegurando que se mantenga un historial de modificaciones.
public class Ejercicio8 {
    public static void main(String[] args) {
        Vector<String> historial = new Vector<>();

        // Agregar cambios
        historial.add("Texto inicial");
        historial.add("Texto modificado");
        historial.add("Texto final");

        // Deshacer último cambio
        historial.remove(historial.size() - 1);

        System.out.println("Última versión: " + historial.lastElement());
    }
}
