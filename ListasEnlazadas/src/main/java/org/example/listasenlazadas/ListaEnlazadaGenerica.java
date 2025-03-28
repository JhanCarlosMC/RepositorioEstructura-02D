package co.edu.uniquindio.listasenlazadas;

import java.util.Iterator;

public class ListaEnlazadaGenerica <T> implements Iterable<T> {
    private NodoGenerico<T> inicial;
    private int tamanio;

    public ListaEnlazadaGenerica() {
        this.inicial = null;
        this.tamanio = 0;
    }

    public void ingresar(T valor) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(valor);
        if (inicial == null) {
            inicial = newNodo;
        } else {
            NodoGenerico<T> actual = inicial;
            while (actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
        }
        tamanio++;
    }

    public void ingresarInicio(T valor) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(valor);
        newNodo.setProximo(inicial);
        inicial = newNodo;
        tamanio++;
    }

    public void insertarIndex(T valor, int index) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(valor);

        if (index == 0) {
            newNodo.setProximo(inicial);
            inicial = newNodo;
            tamanio++;
            return;
        }

        NodoGenerico<T> actual = inicial;
        int cont = 0;

        while (actual != null && cont < index - 1) {
            actual = actual.getProximo();
            cont++;
        }

        if (actual == null) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }

        newNodo.setProximo(actual.getProximo());
        actual.setProximo(newNodo);
        tamanio++;
    }

    public boolean buscar(T valor) {
        NodoGenerico<T> actual = inicial;
        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                return true;
            }
            actual = actual.getProximo();
        }
        return false;
    }

    public int encontrar(T valor) {
        NodoGenerico<T> actual = inicial;
        int index = 0;
        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                return index;
            }
            actual = actual.getProximo();
            index++;
        }
        return -1;
    }

    public boolean eliminar(T valor) {
        if (inicial == null) return false;

        if (inicial.getValor().equals(valor)) {
            inicial = inicial.getProximo();
            tamanio--;
            return true;
        }

        NodoGenerico<T> actual = inicial;
        while (actual.getProximo() != null && !actual.getProximo().getValor().equals(valor)) {
            actual = actual.getProximo();
        }

        if (actual.getProximo() != null) {
            actual.setProximo(actual.getProximo().getProximo());
            tamanio--;
            return true;
        }

        return false;
    }

    public void mostrar() {
        NodoGenerico<T> actual = inicial;
        StringBuilder cadena = new StringBuilder();

        while (actual != null) {
            cadena.append(actual.getValor());
            if (actual.getProximo() != null) {
                cadena.append(" -> ");
            }
            actual = actual.getProximo();
        }

        System.out.println(cadena.toString());
    }

    public int tamanio() {
        return tamanio;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaSimple(inicial);
    }


    protected class IteradorListaSimple implements Iterator<T>{

        private NodoGenerico<T> nodo;
        private int posicion;

        /**
         * Constructor de la clase Iterador
         * @param {aux} Primer Nodo de la lista
         */
        public IteradorListaSimple(NodoGenerico<T> nodo) {
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
            nodo = nodo.getProximo();
            posicion++;
            return valor;
        }

        public int getPosicion() {
            return posicion;
        }

    }

}

