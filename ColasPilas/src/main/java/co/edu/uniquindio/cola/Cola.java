package co.edu.uniquindio.cola;

public class Cola <T>{
    protected Nodo<T> inicial;
    protected Nodo<T>fin;
    protected int tamanio;

    public Cola() {
        inicial = fin = null;
        tamanio = 0;
    }

    //Insertar - Metodo para agergar un elemento al finadel de la cola
    public void encolar(T valor) {
        Nodo<T> newNodo = new Nodo<>(valor);

        if (isVacia()) {
            inicial = newNodo;
            fin = newNodo;
        } else {
            fin.setSiguiente(newNodo);
            fin = newNodo;
        }
        tamanio++;
    }

    //Eliminar - Metodo para eliminar
    // la cabeza(primer elemento) de la cola
    public void desencolar() {

//        if(isVacia()) {
//            return;
//        }else{
//            inicial = inicial.getSiguiente();
//            tamanio--;
//        }

        if(!isVacia()) {
            inicial = inicial.getSiguiente();
            tamanio--;
        }
    }

    //IsEmpty -
    public boolean isVacia(){
        return inicial == null;
    }

    public Nodo<T> getInicial() {
        return inicial;
    }

    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    public Nodo<T> getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}
