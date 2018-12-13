package djsktra;
import java.util.*;

import java.util.Scanner;

public class app {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_Nodos, num_Enlaces, salida, entrada, peso,k=0, r;

       
        //Numero de nodos
        num_Nodos = sc.nextInt();

        //Numero de enlaces
        num_Enlaces = sc.nextInt();

        grafoD matriz = new grafoD(num_Nodos);

        while(k < num_Enlaces){

            salida = sc.nextInt();
            entrada = sc.nextInt();
            peso = sc.nextInt();
            matriz.addEnlace(salida,entrada,peso);
            k++;
        }
   
    
  }
}

class grafoD {
    public int[][] adjM;
    public int numVertices;

    public grafoD(int numVertices){
        this.numVertices = numVertices;
        adjM = new int[numVertices][numVertices];

    }

    public void addEnlace(int N_inicial, int N_final, int peso){
        adjM[N_inicial][N_final] = peso;
        adjM[N_final][N_inicial] = peso;
    }

    public int getEnlace(int i, int j) {
        return adjM[i][j];

    }
