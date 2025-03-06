package co.edu.uniquindio;

import java.util.PriorityQueue;

//En un hospital, los pacientes deben ser atendidos según la gravedad de su condición,
// con los más urgentes siendo tratados primero. Para manejar esto,
// se implementará una PriorityQueue, donde cada paciente será ingresado
// con un nivel de prioridad y el sistema garantizará que aquellos con mayor urgencia sean atendidos antes que los demás.
public class Ejercicio13 {
    public static void main(String[] args) {
        PriorityQueue<Paciente> pacientes = new PriorityQueue<>();

        pacientes.add(new Paciente("Juan", 3));
        pacientes.add(new Paciente("María", 5));
        pacientes.add(new Paciente("Pedro", 1));

        System.out.println("Atendiendo a: " + pacientes.poll());
    }
}

class Paciente implements Comparable<Paciente> {
    String nombre;
    int gravedad;

    public Paciente(String nombre, int gravedad) {
        this.nombre = nombre;
        this.gravedad = gravedad;
    }

    @Override
    public int compareTo(Paciente otro) {
        return Integer.compare(otro.gravedad, this.gravedad);
    }

    public String toString() {
        return nombre + " (Gravedad: " + gravedad + ")";
    }
}