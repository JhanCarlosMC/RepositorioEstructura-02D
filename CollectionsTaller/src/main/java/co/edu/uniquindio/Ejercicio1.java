package co.edu.uniquindio;

import java.util.TreeSet;

//Crear la lista de productos en una clase empresa utilizando treeset,
// se debe realizar un método que busque un producto por su código.
public class Ejercicio1 {
    public static void main(String[] args) {
        Empresa newEmpresa = new Empresa();
        Producto newProducto = new Producto("1010", "Cepillo", 100.00);

        newEmpresa.agregarProducto(newProducto);
        Producto productoEncontrado = newEmpresa.buscarProducto("1010");
        System.out.println(productoEncontrado);
    }
}
// Clase Producto
class Producto implements Comparable<Producto> {
    String codigo;
    String nombre;
    double precio;

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public int compareTo(Producto otro) {
        return this.codigo.compareTo(otro.codigo);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

// Clase Empresa con TreeSet
class Empresa {
    TreeSet<Producto> productos = new TreeSet<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.codigo.equals(codigo)) {
                return p;
            }
        }
        return null;
    }
}