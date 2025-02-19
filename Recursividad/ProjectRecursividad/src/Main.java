public class Main {
    public static void main(String[] args) {

//    matrushkaRecursiva(5);

//    System.out.println(sumaA(5));
//    System.out.println(sumaTail(5,0));

//    int[] arreglo = {1,2,3,4,5,6,7,8,9};
//    recorrerArreglo(arreglo, 0);

        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        recorrerMatriz(matriz, 0, 0);
//        System.out.println("");
//        recorrerMatrizCasoDos(matriz, 0, 0);

        recorrerMatrizCasoTres(matriz,0);
    }

    public static void recorrerArreglo(int[] arreglo, int n) {
        //CASO BASE
        if (n == arreglo.length) return;

        System.out.print(arreglo[n]);
        recorrerArreglo(arreglo, n + 1);
    }

    public static void recorrerMatriz(int[][] matriz, int fila, int columna) {
        //Caso Base
        if (fila == matriz.length) return;

        if (columna == matriz[0].length) {
            System.out.println("");
            recorrerMatriz(matriz, fila + 1, 0);
        } else {
            System.out.print(matriz[fila][columna]+" ");
            recorrerMatriz(matriz, fila, columna + 1);
        }
    }

    public static void recorrerMatrizCasoDos(int[][] matriz, int fila, int columna) {
        //Caso Base
        if (columna == matriz[0].length) return;

        if (fila == matriz.length) {
            System.out.println("");
            recorrerMatrizCasoDos(matriz, 0, columna + 1);
        } else {
            System.out.print(matriz[fila][columna]+" ");
            recorrerMatrizCasoDos(matriz, fila + 1, columna);
        }
    }

    public static void recorrerMatrizCasoTres(int[][] matriz, int a) {
        //Caso Base
        if (a == matriz.length) return;

            System.out.print(matriz[a][a]+" ");
        recorrerMatrizCasoTres(matriz, a + 1);
    }

//  public static void recorrerMatrizDOS(int[][]matriz, int columna, int fila) {
//    //Caso Base
//    if(fila == matriz.length) return;
//
//    //Option 2
//    for(int i = 0; fila >= matriz[0].length; i++){
//
//    }
//
//
//  }


    public static void matrushkaRecursiva(int cant) {

        if (cant == 0) {
            System.out.println("Ultima muñeca");
            return; //Caso Base
        }

        System.out.println("Abriendo muñeca " + cant);
        matrushkaRecursiva(cant - 1);//Caso recursivo
        System.out.println("Cerrando muñeca " + cant);

    }

    public static int sumaTail(int a, int acumulador) {
        if (a == 0) {
            return acumulador;
        }
        return sumaTail(a - 1, acumulador + a);
    }


    public static int sumaA(int a) {
        if (a == 0) {
            return 0;
        }
        return a + sumaB(a - 1);
    }

    public static int sumaB(int a) {
        if (a == 0) {
            return 0;
        }
        return sumaA(a);
    }
}