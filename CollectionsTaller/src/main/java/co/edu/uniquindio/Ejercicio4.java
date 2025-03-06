package co.edu.uniquindio;

import java.util.PriorityQueue;

//Cree una cola (Queue) que almacene objetos de tipo "Tarea" que tengan una prioridad asociada.
//Implemente la cola usando un PriorityQueue y defina la prioridad de cada tarea según su importancia.
public class Ejercicio4 {
    public static void main(String[] args) {
        PriorityQueue<Tarea> cola = new PriorityQueue<>();
        cola.add(new Tarea("Revisar correo", 1));
        cola.add(new Tarea("Atender reunión", 3));
        cola.add(new Tarea("Terminar informe", 2));

        while (!cola.isEmpty()) {
            System.out.println("Ejecutando: " + cola.poll());
        }
    }
}

class Tarea implements Comparable<Tarea> {
    String descripcion;
    int prioridad;

    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(otra.prioridad, this.prioridad);
    }

    @Override
    public String toString() {
        return "Tarea: " + descripcion + " (Prioridad: " + prioridad + ")";
    }
}