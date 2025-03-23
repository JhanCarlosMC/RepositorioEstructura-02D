package org.example.listasimplementeenlazada;

public class ListaSimplementeEnlazada <T> {
    private Nodo<T> inicial;
    private Nodo<T> fin;
    private int tamanio;

    public ListaSimplementeEnlazada() {
        this.inicial = null;
        this.tamanio = 0;
    }


    public void insertarInicio(T valor){
        Nodo<T> nuevoNodo = new Nodo(valor);

        nuevoNodo.setSiguiente(inicial);
        inicial = nuevoNodo;
        tamanio++;
    }

    public void insertarFinal(T valor){
        Nodo<T> nuevoNodo = new Nodo(valor);
        if(inicial == null){
            inicial = nuevoNodo;
            tamanio++;
            return;
        }

        Nodo<T> nodoRecorrer = inicial;
        while(nodoRecorrer.getSiguiente() != null){
            nodoRecorrer = nodoRecorrer.getSiguiente();
        }
        nodoRecorrer.setSiguiente(nuevoNodo);
        tamanio++;
    }

    public boolean buscar(T valor){
        Nodo<T> nodoRecorrer = inicial;
        while(nodoRecorrer != null){
            if(nodoRecorrer.getValor() == valor){
                return true;
            }
            nodoRecorrer = nodoRecorrer.getSiguiente();
        }
        return false;
    }


    public int localizar(T valor){
        Nodo<T> nodoRecorrer= inicial;
        int indice= 0;
        while(nodoRecorrer!=null){
            if(nodoRecorrer.getValor()==valor){
                return indice;
            }
            indice++;
            nodoRecorrer=nodoRecorrer.getSiguiente();
        }
        return -1;
    }

    public void eliminar(T dato){
        if(inicial == null){
            return;
        }
        if(inicial.getValor() == dato){
            inicial = inicial.getSiguiente();
            tamanio--;
            return;
        }
        Nodo<T> nodoRecorrer = inicial;
        while(nodoRecorrer.getSiguiente() != null){

            if(nodoRecorrer.getSiguiente().getValor() == dato){
                nodoRecorrer.setSiguiente(nodoRecorrer.getSiguiente().getSiguiente());
                tamanio--;
                return;
            }
            nodoRecorrer = nodoRecorrer.getSiguiente();
        }

    }

    public void mostrar(){
        Nodo nodoRecorrer = inicial;
        String cadena = "";

        while (nodoRecorrer != null){
            if(nodoRecorrer.getSiguiente() != null){
                cadena += nodoRecorrer.getValor() + " -> ";
                nodoRecorrer = nodoRecorrer.getSiguiente();
            }else {
                cadena += nodoRecorrer.getValor();
                nodoRecorrer = nodoRecorrer.getSiguiente();
            }
        }

        System.out.println(cadena);
    }

    public int getTamanio() {
        return tamanio;
    }

}
