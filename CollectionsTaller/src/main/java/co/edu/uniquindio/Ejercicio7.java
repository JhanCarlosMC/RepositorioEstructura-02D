package co.edu.uniquindio;

import java.util.LinkedList;

//En un banco, el sistema de atención al cliente debe manejar los turnos de manera ordenada.
//Para lograrlo, se empleará una LinkedList (String), la cual permitirá agregar clientes en la cola de espera,
// atender al primero en la lista y ofrecer una funcionalidad especial para insertar clientes
// con urgencia al inicio de la cola sin afectar el rendimiento.
public class Ejercicio7 {

    public static void main(String[] args) {
        LinkedList<String> clientes = new LinkedList<>();

        // Agregar clientes
        clientes.add("Cliente 1");
        clientes.add("Cliente 2");
        clientes.add("Cliente 3");

        // Atender al primer cliente
        System.out.println("Atendiendo a: " + clientes.poll());

        // Insertar cliente prioritario al inicio
        clientes.addFirst("Cliente VIP");

        System.out.println("Clientes en espera: " + clientes);
    }

}

