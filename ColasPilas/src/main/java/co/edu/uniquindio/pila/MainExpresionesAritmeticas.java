package co.edu.uniquindio.pila;

import java.util.HashMap;
import java.util.Stack;

public class MainExpresionesAritmeticas {

    public static void main(String[] args) {
        String infija = "(A+B)*(C-D)";
//        String infija = "A+B+C+D";

        String postfija = infijaAPostfija(infija);
        String prefija = infijaAPrefija(infija);
        String prefijaDirecta = infijaAPrefijaDirecta(infija);

        System.out.println("Infija:   " + infija); // (A+B)*(C-D)
        System.out.println("Postfija: " + postfija); // AB+CD-*
        System.out.println("Prefija:  " + prefija); // *+AB-CD
        System.out.println("PrefijaDirecta:  " + prefijaDirecta); // *+AB-CD


        // Asignar valores a A, B, C, D
        HashMap<Character, Integer> valores = new HashMap<>();
        valores.put('A', 5);
        valores.put('B', 3);
        valores.put('C', 10);
        valores.put('D', 2);

        // Evaluar postfija
        int resultado = evaluarPostfijaConVariables(postfija, valores);
        System.out.println("Resultado postfija evaluada: " + resultado); // (5+3)*(10-2) = 8*8 = 64
    }

    //Convertir Infija a Prefija
    public static String infijaAPrefija(String expresion) {
        // 1. Invertir la expresión
        StringBuilder exp = new StringBuilder(expresion).reverse();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                exp.setCharAt(i, ')');
            } else if (exp.charAt(i) == ')') {
                exp.setCharAt(i, '(');
            }
        }

        // 2. Convertir a postfija
        String postfija = infijaAPostfija(exp.toString());

        // 3. Invertir el resultado
        return new StringBuilder(postfija).reverse().toString();
    }


    /**
     * Convierte una expresión aritmética de notación infija a notación prefija (notación polaca).
     *
     * Esta versión implementa la conversión de forma directa, sin pasar por notación postfija.
     * Utiliza dos pilas: una para operadores y otra para operandos. A medida que se recorren los
     * caracteres de la expresión, se aplican las reglas de precedencia y asociación para construir
     * la expresión prefija final.
     *
     * @param expresion Cadena que representa la expresión en notación infija (sin espacios innecesarios)
     * @return Cadena con la expresión convertida a notación prefija
     */
    public static String infijaAPrefijaDirecta(String expresion) {
        Stack<String> operandos = new Stack<>();     // Pila para almacenar operandos y subexpresiones prefijas
        Stack<Character> operadores = new Stack<>(); // Pila para almacenar operadores y paréntesis

        // Recorre cada carácter de la expresión de izquierda a derecha
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Ignora los espacios en blanco
            if (c == ' ') continue;

            // Si el carácter es una letra o dígito (es un operando), lo apila como cadena
            if (Character.isLetterOrDigit(c)) {
                operandos.push(String.valueOf(c));
            }

            // Si es un paréntesis de apertura, se apila directamente
            else if (c == '(') {
                operadores.push(c);
            }

            // Si es un paréntesis de cierre, se desapilan operadores hasta encontrar el paréntesis de apertura
            else if (c == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    combinarOperadores(operandos, operadores.pop());
                }
                operadores.pop(); // Elimina el '(' de la pila
            }

            // Si es un operador (+, -, *, /, ^), aplica reglas de precedencia
            else if (esOperador(c)) {
                // Mientras haya operadores en la pila con mayor o igual precedencia,
                // se aplican antes que el operador actual
                while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(c)) {
                    combinarOperadores(operandos, operadores.pop());
                }
                operadores.push(c); // Apila el operador actual
            }
        }

        // Procesa los operadores restantes en la pila
        while (!operadores.isEmpty()) {
            combinarOperadores(operandos, operadores.pop());
        }

        // El último elemento en la pila de operandos es la expresión prefija completa
        return operandos.pop();
    }

    // Combina los dos últimos operandos con el operador dado, y empuja el resultado a la pila de operandos
    private static void combinarOperadores(Stack<String> operandos, char operador) {
        String op2 = operandos.pop();
        String op1 = operandos.pop();
        String expresion = operador + op1 + op2;
        operandos.push(expresion);
    }

    //Convertir Infija a Postfija

    /**
     * Convierte una expresión en notación infija a notación postfija (notación polaca inversa).
     * Utiliza el algoritmo de Shunting Yard desarrollado por Edsger Dijkstra.

     * @param expresion Cadena que representa la expresión en notación infija (sin espacios).
     * @return Cadena con la expresión convertida a notación postfija.
     */
    public static String infijaAPostfija(String expresion) {
        StringBuilder resultado = new StringBuilder();  // Almacena el resultado final en notación postfija
        Pila<Character> pila = new Pila<>();          // Pila para operadores y paréntesis

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si el carácter es letra o dígito, se agrega directamente al resultado
            if (Character.isLetterOrDigit(c)) {
                resultado.append(c);
            }

            // Si el carácter es un paréntesis de apertura, se apila
            else if (c == '(') {
                pila.push(c); //Apilar
            }

            // Si es un paréntesis de cierre, desapila hasta encontrar el paréntesis de apertura
            else if (c == ')') {
                while (!pila.estaVacia() && pila.obtenerCima() != '(') {
                    resultado.append(pila.pop()); // Añade operadores dentro de los paréntesis
                }
                pila.pop(); // Elimina el '(' de la pila (no se añade al resultado)
            }

            // Si es un operador (+, -, *, /, ^)
            else if (esOperador(c)) {
                // Mientras haya operadores en la pila con mayor o igual precedencia,
                // se desapilan y se añaden al resultado
                while (!pila.estaVacia() && precedencia(c) <= precedencia(pila.obtenerCima())) {
                    resultado.append(pila.pop());
                }
                pila.push(c); // Se apila el operador actual
            }
        }

        // Al final, se vacía la pila y se añaden los operadores restantes al resultado
        while (!pila.estaVacia()) {
            resultado.append(pila.pop());
        }

        return resultado.toString(); // Devuelve la expresión en notación postfija
    }


    //Metodos auxiliares
    public static int precedencia(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }


    /**
     * Evalúa una expresión aritmética en notación postfija (notación polaca inversa)
     * utilizando variables representadas por letras (como A, B, C...) y una tabla de valores.
     *
     * @param expresionPostfija Expresión en notación postfija
     * @param valores Mapa que asocia cada variable (carácter) con su valor entero
     * @return Resultado de la evaluación como número entero
     */
    public static int evaluarPostfijaConVariables(String expresionPostfija, HashMap<Character, Integer> valores) {
        Pila<Integer> pila = new Pila<>();  // Pila para almacenar operandos durante la evaluación

        // Recorre cada carácter de la expresión postfija
        for (int i = 0; i < expresionPostfija.length(); i++) {
            char token = expresionPostfija.charAt(i);

            // Si el token es una letra (una variable), se busca su valor y se apila
            if (Character.isLetter(token)) {
                if (!valores.containsKey(token)) {
                    throw new IllegalArgumentException("Falta valor para la variable: " + token);
                }
                pila.push(valores.get(token));
            }

            // Si el token es un operador (+, -, *, /, ^), se desapilan dos operandos y se aplica la operación
            else if (esOperador(token)) {
                int b = pila.pop(); // Segundo operando (en la cima de la pila)
                int a = pila.pop(); // Primer operando

                switch (token) {
                    case '+':
                        pila.push(a + b);
                        break;
                    case '-':
                        pila.push(a - b);
                        break;
                    case '*':
                        pila.push(a * b);
                        break;
                    case '/':
                        pila.push(a / b);
                        break;
                    case '^':
                        pila.push((int) Math.pow(a, b));
                        break;
                }
            }
        }

        // El resultado final queda en la cima de la pila
        return pila.pop();
    }
}
