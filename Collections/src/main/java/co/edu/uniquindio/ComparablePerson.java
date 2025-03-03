package co.edu.uniquindio;

import java.util.Objects;

public class ComparablePerson implements Comparable<ComparablePerson>{
    private String nombre;
    private int edad;

    public ComparablePerson(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(ComparablePerson person) {
        return this.edad - person.edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComparablePerson that = (ComparablePerson) o;
        return edad == that.edad && Objects.equals(nombre, that.nombre);
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
