package Tarea;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_Nodos, num_Enlaces, k=0, salida, entrada, peso;

        num_Nodos = 6;
        grafo M = new grafo(num_Nodos);

        M.addEnlace(0,1,5);
        M.addEnlace(0,2,10);
        M.addEnlace(1,2,15);
        M.addEnlace(1,3,7);
        M.addEnlace(2,4,3);
        M.addEnlace(3,4,8);
        M.addEnlace(3,5,9);
        M.addEnlace(4,5,11);


/*
        //Numero de nodos
        num_Nodos = sc.nextInt();

        //Numero de enlaces
        num_Enlaces = sc.nextInt();

        grafo M = new grafo(num_Nodos);

        while(k < num_Enlaces){

            salida = sc.nextInt();
            entrada = sc.nextInt();
            peso = sc.nextInt();
            M.addEnlace(salida,entrada,peso);
            k++;
        }
    */
        //imprime la matriz
        for (int i = 0; i <num_Nodos; i++){
            System.out.print(i + " ");
            for (int j=0; j <num_Nodos; j++){
                System.out.print(M.getEnlace(i, j) + "-");
            }

            System.out.println();

        }

        M.ObtenerCaminoMenor(0,5);

    }
}
