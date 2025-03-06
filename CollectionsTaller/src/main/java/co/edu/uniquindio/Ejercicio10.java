package co.edu.uniquindio;

import java.util.HashSet;

//En un edificio con control de acceso, los empleados deben identificarse mediante un código
// único para poder ingresar. Para gestionar estos accesos sin permitir duplicados,
// se utilizará un HashSet, donde cada ID de empleado será almacenado y verificado antes de permitir la entrada.
public class Ejercicio10 {
    public static void main(String[] args) {
        HashSet<String> empleados = new HashSet<>();

        // Agregar empleados
        empleados.add("EMP001");
        empleados.add("EMP002");
        empleados.add("EMP003");

        // Intentar agregar un duplicado
        if (!empleados.add("EMP002")) {
            System.out.println("El ID EMP002 ya existe.");
        }

        System.out.println("Lista de empleados autorizados: " + empleados);
    }
}
