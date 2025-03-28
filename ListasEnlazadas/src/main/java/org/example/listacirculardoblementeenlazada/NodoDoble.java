package co.edu.uniquindio.listacirculardoblementeenlazada;

public class NodoDoble<T> {
    private T valor;
    private NodoDoble<T> anterior, siguiente;

    public NodoDoble(T valor) {
        this.valor = valor;
        this.anterior = this.siguiente = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }
}
