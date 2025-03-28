package co.edu.uniquindio.listacirculardoblementeenlazada;

public class ListaCircularDoblementeEnlazada<T> {
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamanio;

    public ListaCircularDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    /**
     * Inserta un elemento al inicio de la lista circular doblemente enlazada.
     */
    public void ingresarInicio(T valor) {
        NodoDoble<T> newNodo = new NodoDoble<>(valor);
        if (cabeza == null) {
            cabeza = cola = newNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            newNodo.setSiguiente(cabeza);
            newNodo.setAnterior(cola);
            cabeza.setAnterior(newNodo);
            cola.setSiguiente(newNodo);
            cabeza = newNodo;
        }
        tamanio++;
    }

    /**
     * Inserta un elemento al final de la lista circular doblemente enlazada.
     */
    public void ingresarFinal(T valor) {
        NodoDoble<T> newNodo = new NodoDoble<>(valor);
        if (cabeza == null) {
            cabeza = cola = newNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            cola.setSiguiente(newNodo);
            newNodo.setAnterior(cola);
            newNodo.setSiguiente(cabeza);
            cabeza.setAnterior(newNodo);
            cola = newNodo;
        }
        tamanio++;
    }

    /**
     * Elimina un nodo con un valor específico.
     */
    public boolean eliminar(T valor) {
        if (cabeza == null) return false;

        NodoDoble<T> actual = cabeza;

        do {
            if (actual.getValor().equals(valor)) {
                if (actual == cabeza) { // Eliminar la cabeza
                    if (cabeza == cola) { // Si es el único nodo
                        cabeza = null;
                        cola = null;
                    } else {
                        cabeza = cabeza.getSiguiente();
                        cabeza.setAnterior(cola);
                        cola.setSiguiente(cabeza);
                    }
                } else if (actual == cola) { // Eliminar la cola
                    cola = cola.getAnterior();
                    cola.setSiguiente(cabeza);
                    cabeza.setAnterior(cola);
                } else { // Eliminar un nodo intermedio
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                tamanio--;
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        return false;
    }

    /**
     * Muestra los elementos de la lista circular doblemente enlazada.
     */
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        NodoDoble<T> actual = cabeza;
        do {
            System.out.print(actual.getValor() + " <-> ");
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        System.out.println("(circular)");
    }

    /**
     * Retorna el tamaño de la lista.
     */
    public int tamanio() {
        return tamanio;
    }
}
