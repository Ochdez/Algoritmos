package djsktra;
import java.util.*;

public class grafo {
    public int[][] adjM;
    public int vertices;
    
    public grafo(int vertices){
        this.vertices = vertices;
        adjM = new int[vertices][vertices];
                
    }
    
    public void addEnlace(int N_inicial, int N_final, int peso){
        adjM[N_inicial][N_final] = peso;
        
    }
    
    public int getEnlace(int i, int j) {
        return adjM[i][j];

    }

    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n=5;
        grafo M = new grafo(n);
        M.addEnlace(0,1,5);
        M.addEnlace(0,3,7);
        M.addEnlace(1,0,5);
        M.addEnlace(1,2,3);
        M.addEnlace(2,1,3);
        M.addEnlace(2,3,9);
        M.addEnlace(3,0,7);
        M.addEnlace(3,2,9);
        M.addEnlace(3,4,4);
        M.addEnlace(4,2,3);
        M.addEnlace(4,3,4);
        
        System.out.println("ingrese el numero de enlaces");

         
       
        for (int i = 0; i <n; i++){ 
            System.out.print(i);
            for (int j=0; j <n; j++){
                System.out.print(M.getEnlace(i, j));
                } 

                System.out.println();

            }
 
    }
    
}
