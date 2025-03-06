package co.edu.uniquindio;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

//En un supermercado, se desea registrar los productos comprados
// en el orden en que fueron escaneados y calcular el total de la compra.
// Para lograr esto, se empleará un LinkedHashMap, asegurando que los
// productos y sus precios se almacenen en el mismo orden en que se añadieron,
// facilitando el procesamiento de la factura final.
public class Ejercicio16 {
    public static void main(String[] args) {
        LinkedHashMap<String, Double> compras = new LinkedHashMap<>();

        // Agregar productos
        compras.put("Leche", 3.50);
        compras.put("Pan", 2.00);
        compras.put("Huevos", 4.75);

        //Calcular total
        double total = 0.0;
        Iterator<Map.Entry<String, Double>> iterator = compras.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            total += entry.getValue();
        }

        System.out.println("Total a pagar: " + total);
    }
}
