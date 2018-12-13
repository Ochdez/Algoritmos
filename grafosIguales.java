package examen;

import java.util.*;

public class grafosIguales {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num_Nodos, num_Enlaces, salida, entrada, peso,a=0,b=0;

     
        num_Nodos = sc.nextInt();
        num_Enlaces = sc.nextInt();

        grafo grafo1 = new grafo(num_Nodos, num_Enlaces);
        grafo grafo2 = new grafo(num_Nodos, num_Enlaces);

        while(a < num_Enlaces){

            salida = sc.nextInt();
            entrada = sc.nextInt();
            peso = sc.nextInt();
            grafo1.addEnlace(salida,entrada,peso);
            a++;
        }
        
    

        while(b < num_Enlaces){

            salida = sc.nextInt();
            entrada = sc.nextInt();
            peso = sc.nextInt();
            grafo2.addEnlace(salida,entrada,peso);
            b++;
        }
   
    
  }
}

class grafo {
    public int[][] M;
    public int numVertices;
    public int numEnlaces;

    public grafo(int numVertices, int numEnlaces){
        this.numVertices = numVertices;
        M = new int[numVertices][numVertices];

    }

    public void addEnlace(int N_inicial, int N_final, int peso){
        M[N_inicial][N_final] = peso;
        
    }

    public int getEnlace(int i, int j) {
        return M[i][j];

    }
    
    public void comparar(grafo M) { //llena una lista con los pesos y al comparar la otra matriz irà eliminando los datos
    	int c;						//Si las matrices son iguales la lista quedarà vacia.
    	
    	if(numVertices == M.numVertices && numEnlaces == M.numEnlaces) {
    		
    		int[] datos = new int[numEnlaces];
    		c = 0;
    		for(int i=0; i<numEnlaces; i++) {
    			
    			for(int j=0; j<numEnlaces; j++) {
    				
    				if(getEnlace(i,j) != 0){
    					
    					datos[c] = getEnlace(i,j); //Lena la lista con los valores de los enlaces.
    					c++;
    				}
    			}
    		}
    		
    		for(int i=0; i<numEnlaces; i++) { //Recorrer la otra matriz e ir eliminando los datops de la lista.
    			
    		}
    		
    	}
    	else {
    		System.out.print("No");
    	}
    	    

    
    }
  }
   