package co.edu.uniquindio.listadoblementeenlazada;

import java.util.Iterator;

public class ListaDoblementeEnlazada<T> implements Iterable<T> {
    private NodoDoble<T> inicial;
    private NodoDoble<T> ultimo;
    private int tamanio;

    public ListaDoblementeEnlazada() {
        this.inicial = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    public void ingresarInicio(T valor) {
        NodoDoble<T> newNodo = new NodoDoble<>(valor);
        if (inicial == null) {
            inicial = newNodo;
            ultimo = newNodo;
        } else {
            newNodo.setSiguiente(inicial);
            inicial.setAnterior(newNodo);
            inicial = newNodo;

        }
        tamanio++;
    }

    public void ingresarFinal(T valor) {
        NodoDoble<T> newNodo = new NodoDoble<>(valor);
        if (inicial == null) {
            inicial = newNodo;
            ultimo = newNodo;
        } else {
            ultimo.setSiguiente(newNodo);
            newNodo.setAnterior(ultimo);
            ultimo = newNodo;
        }
        tamanio++;
    }

//    public void insertarIndex(T valor, int index) {
//        if (index < 0 || index > tamanio) {
//            throw new IndexOutOfBoundsException("Posición fuera de rango");
//        }
//        NodoDoble<T> newNodo = new NodoDoble<>(valor);
//        if (index == 0) {
//            ingresarInicio(valor);
//            return;
//        }
//        if (index == tamanio) {
//            ingresar(valor);
//            return;
//        }
//        NodoDoble<T> actual = inicial;
//        for (int i = 0; i < index - 1; i++) {
//            actual = actual.getSiguiente();
//        }
//        newNodo.setSiguiente(actual.getSiguiente());
//        newNodo.setAnterior(actual);
//        actual.getSiguiente().setAnterior(newNodo);
//        actual.setSiguiente(newNodo);
//        tamanio++;
//    }

    public boolean buscar(T valor) {
        NodoDoble<T> actual = inicial;
        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public int encontrar(T valor) {
        NodoDoble<T> actual = inicial;
        int index = 0;
        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                return index;
            }
            actual = actual.getSiguiente();
            index++;
        }
        return -1;
    }

    public boolean eliminar(T valor) {
        if (inicial == null) return false;

        if (inicial.getValor().equals(valor)) {

            inicial = inicial.getSiguiente();
            if (inicial != null) {
                inicial.setAnterior(null);
            } else {
                ultimo = null;
            }
            tamanio--;
            return true;
        }

        NodoDoble<T> actual = inicial;
        while (actual != null && !actual.getValor().equals(valor)) {
            actual = actual.getSiguiente();
        }

        if (actual == ultimo) {
            ultimo = actual.getAnterior();
            ultimo.setSiguiente(null);
        } else {
            actual.getAnterior().setSiguiente(actual.getSiguiente());
            actual.getSiguiente().setAnterior(actual.getAnterior());
        }

        tamanio--;
        return true;
    }

    public void mostrar() {
        NodoDoble<T> actual = inicial;
        StringBuilder cadena = new StringBuilder();
        while (actual != null) {
            cadena.append(actual.getValor());
            if (actual.getSiguiente() != null) {
                cadena.append(" <-> ");
            }
            actual = actual.getSiguiente();
        }
        System.out.println(cadena.toString());
    }

    public int tamanio() {
        return tamanio;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaDoble (inicial);
    }
    

protected class IteradorListaDoble implements Iterator<T>{

    private NodoDoble<T> nodo;
    private int posicion;

    /**
     * Constructor de la clase Iterador
     * @param {aux} Primer Nodo de la lista
     */
    public IteradorListaDoble(NodoDoble<T> nodo) {
        this.nodo = nodo;
        this.posicion = 0;
    }

    @Override
    public boolean hasNext() {
        return nodo!=null;
    }

    @Override
    public T next() {
        T valor = nodo.getValor();
        nodo = nodo.getSiguiente();
        posicion++;
        return valor;
    }

    public boolean hasPrevious() {
        return nodo!=null;
    }


    public T previous() {
        T aux = nodo.getValor();
        nodo = nodo.getSiguiente();
        posicion--;
        return aux;
    }

    public int nextIndex() {
        return posicion;
    }

    public int previousIndex() {
        return posicion-1;
    }

//    public void remove() {
//        if(nodo!=null) {
//            eliminar(nodo.getValor());
//        }
//    }

    /**
     * Posici�n actual de la lista
     * @return posici�n
     */
    public int getPosicion() {
        return posicion;
    }

}
}