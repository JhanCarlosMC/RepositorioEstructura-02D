package co.edu.uniquindio.cola;

public class BiCola <T> extends Cola {

    public BiCola() {}

    //AgregarAlFrente - Metodo para agregar un elemento
    //alfrente de la cola
    public void encolarInicio(T valor) {
        Nodo<T> newNodo = new Nodo<>(valor);

        if (isVacia()){
            inicial = newNodo;
            fin = newNodo;
        }else{
            newNodo.setSiguiente(inicial);
            inicial = newNodo;
        }
        tamanio++;
    }

    //EliminarFin - Metodo para eliminar al final de la BiCola
    public void desencolarFinal(){

        if(!isVacia()){

            if(inicial == fin){
                fin = inicial = null;
            }else{
                Nodo<T> nodoRecorrer = inicial;

                while(nodoRecorrer.getSiguiente() != fin){
                    nodoRecorrer = nodoRecorrer.getSiguiente();
                }
                nodoRecorrer.setSiguiente(null);
                fin = nodoRecorrer;
            }
            tamanio--;
        }
    }
}
