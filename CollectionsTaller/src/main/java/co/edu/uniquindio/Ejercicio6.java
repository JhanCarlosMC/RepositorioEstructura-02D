package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.Comparator;

//En una tienda se necesita una aplicación para gestionar el inventario de productos(codigo, nombre, precio),
// permitiendo agregar nuevos artículos, eliminar los que están agotados,
// buscar productos específicos y listar todo el inventario en orden alfabético y por orden de precio.
//  Para ello, se utilizará una ArrayList, que ofrece acceso rápido a los elementos y permite su manipulación de manera eficiente.
public class Ejercicio6 {
    public static void main(String[] args) {
        ArrayList<ProductoInventario> productos = new ArrayList<>();
        productos.add(new ProductoInventario("A002", "Mouse", 20.5));
        productos.add(new ProductoInventario("A001", "Laptop", 1500));
        productos.add(new ProductoInventario("A003", "Teclado", 30));

        productos.sort(Comparator.comparing(p -> p.nombre));
        System.out.println("Ordenado por nombre: " + productos);

        productos.sort(Comparator.comparingDouble(p -> p.precio));
        System.out.println("Ordenado por precio: " + productos);
    }
}

class ProductoInventario {
    String codigo;
    String nombre;
    double precio;

    public ProductoInventario(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " - $" + precio;
    }
}