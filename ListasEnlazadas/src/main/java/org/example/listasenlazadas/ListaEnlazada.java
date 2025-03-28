package co.edu.uniquindio.listasenlazadas;

public class ListaEnlazada {
    private Nodo inicial;
    private int tamanio;

    public ListaEnlazada (){
        this.inicial = null;
        this.tamanio = 0;
    }

    public void ingresar(int valor){
        Nodo newNodo = new Nodo(valor);
        if(inicial == null){
            inicial = newNodo;
        }else{
            Nodo actual = inicial;
            while (actual.getProximo() != null){
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
        }
        tamanio++;
    }

    public void ingresarInicio(int valor){
        Nodo newNodo = new Nodo(valor);

        newNodo.setProximo(inicial);
        inicial = newNodo;
        tamanio++;
    }

    public void insertarIndex(int valor, int index){
        Nodo newNodo = new Nodo(valor);

        if (index == 0){
            newNodo.setProximo(inicial);
            inicial = newNodo;
            tamanio++;
            return;
        }

        Nodo actual = inicial;
        int cont = 0;

        while (actual!= null && cont < index-1){
            actual = actual.getProximo();
            cont ++;
        }

        if (actual == null || actual.getProximo() == null){
            throw new IndexOutOfBoundsException("Posicion fuera de rango");
        }

        newNodo.setProximo(actual.getProximo());
        actual.setProximo(newNodo);
        tamanio++;

    }

    public boolean buscar(int valor){
        Nodo actual = inicial;

        while (actual != null){
            if (actual.getValor() == valor){
                return true;
            }
            actual = actual.getProximo();
        }
        return false;
    }

    public int encontrar(int valor){
        Nodo actual = inicial;
        int index = 0;

        while (actual != null){
            if (actual.getValor() == valor){
                return index;
            }
            actual = actual.getProximo();
            index++;
        }

        return -1;
    }

    public boolean eliminar(int valor) {
        if(inicial == null) return false;

        if (inicial.getValor() == valor){
            inicial = inicial.getProximo();
            tamanio--;
            return true;
        }

        Nodo actual = inicial;
        while (actual.getProximo() != null && actual.getProximo().getValor() != valor){
            actual = actual.getProximo();
        }

        if(actual.getProximo() != null){
            actual.setProximo(actual.getProximo().getProximo());
            tamanio--;
            return true;
        }

        return false;
    }

    public void mostrar(){
        Nodo actual = inicial;
        String cadena = "";

        while (actual != null){
            if(actual.getProximo() == null){
                cadena += actual.getValor();
            }else {
                cadena += actual.getValor() + ", ";
            }
            actual = actual.getProximo();
        }

        System.out.println(cadena);
    }

    public int tamanio(){
        return tamanio;
    }
}
