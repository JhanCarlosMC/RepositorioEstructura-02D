package co.edu.uniquindio.listasenlazadas;

public class NodoGenerico<T> {
    private T valor;
    private NodoGenerico<T> proximo;

    public NodoGenerico(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoGenerico<T> getProximo() {
        return proximo;
    }

    public void setProximo(NodoGenerico<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "NodoGenerico{" +
                "valor=" + valor +
                ", proximo=" + proximo +
                '}';
    }
}
