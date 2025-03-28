package co.edu.uniquindio.listacircularsimplementeenlazada;

public class ListaCircularSimplementeEnlazada<T> {
    private Nodo<T> inicial;
    private Nodo<T> fin;
    private int tamanio;

    public ListaCircularSimplementeEnlazada() {
        this.inicial = null;
        this.fin = null;
        this.tamanio = 0;
    }

    public void insertarInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        if (inicial == null) {
            inicial = nuevoNodo;
            fin = nuevoNodo;
            nuevoNodo.setSiguiente(nuevoNodo);
        } else {
            nuevoNodo.setSiguiente(inicial);
            fin.setSiguiente(nuevoNodo);
            inicial = nuevoNodo;
        }
        tamanio++;
    }

    public void insertarFinal(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        if (inicial == null) {
            inicial = nuevoNodo;
            fin = nuevoNodo;
            nuevoNodo.setSiguiente(nuevoNodo);
        } else {
            fin.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(inicial);
            fin = nuevoNodo;
        }
        tamanio++;
    }


    public void eliminar(T dato) {
        if (inicial == null) return;

        if (inicial.getValor().equals(dato)) {

            if (inicial == fin) {
                inicial = null;
                fin = null;
            } else {
                inicial = inicial.getSiguiente();
                fin.setSiguiente(inicial);
            }
            tamanio--;
            return;

        }

        Nodo<T> nodoRecorrer = inicial;
        while (!(nodoRecorrer.getSiguiente().equals(inicial))) {

            if (nodoRecorrer.getSiguiente().getValor().equals(dato)) {

                if (nodoRecorrer.getSiguiente() == fin) {
                    fin = nodoRecorrer;
                }
                nodoRecorrer.setSiguiente(nodoRecorrer.getSiguiente().getSiguiente());
                tamanio--;
                return;
            }
            nodoRecorrer = nodoRecorrer.getSiguiente();
        }
    }

    public boolean buscar(T valor) {
        if (inicial == null) return false;

        Nodo<T> nodoRecorrer = inicial;
        do {
            if (nodoRecorrer.getValor().equals(valor)) {
                return true;
            }
            nodoRecorrer = nodoRecorrer.getSiguiente();
        } while (nodoRecorrer != inicial);

        return false;
    }

    public int localizar(T valor) {
        if (inicial == null) return -1;

        Nodo<T> nodoRecorrer = inicial;
        int indice = 0;

        do {
            if (nodoRecorrer.getValor().equals(valor)) {
                return indice;
            }
            nodoRecorrer = nodoRecorrer.getSiguiente();
            indice++;
        } while (nodoRecorrer != inicial);

        return -1;
    }

    public void mostrar() {
        if (inicial == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo<T> nodoRecorrer = inicial;
        StringBuilder cadena = new StringBuilder();

        do {
            cadena.append(nodoRecorrer.getValor());
            nodoRecorrer = nodoRecorrer.getSiguiente();
            if (nodoRecorrer != inicial) {
                cadena.append(" -> ");
            }
        } while (nodoRecorrer != inicial);

        System.out.println(cadena);
    }

    public int getTamanio() {
        return tamanio;
    }
}
