package org.example;

import org.example.listasimplementeenlazada.ListaSimplementeEnlazada;

public class Main {
    public static void main(String[] args) {
        ListaSimplementeEnlazada miLista = new ListaSimplementeEnlazada();
//        miLista.insertarInicio("false");
//        miLista.insertarInicio("true");

        miLista.insertarFinal(50);
        miLista.insertarFinal(100);
//        miLista.mostrar();
        miLista.eliminar(50);
//        miLista.eliminar(30);
//
//        System.out.println(miLista.buscar(30));
//        System.out.println(miLista.buscar(50));
//        System.out.println(miLista.localizar(20));
//        System.out.println(miLista.localizar(100));

        miLista.mostrar();
    }
}