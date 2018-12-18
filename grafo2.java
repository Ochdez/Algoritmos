import java.util.Scanner;
import java.util.Arrays;
//Posdata voy a requerir 3 arreglos uno para meter todos los caminos, otro para verificar que no hayan loops y el último para guardar la sol. todos de dist tam.
public class grafo
{
       metodo m =new metodo();
    int ini;
    int fin;
    int peso;
    
    grafo(int a, int b, int c)
    {
        ini=a;
        fin=b;
        peso=c;
    }
    grafo()
    {
        ini=0;
        fin=0;
        peso=0;
    }


    public void ordenar(grafo A[], grafo ayuda, int i)
    {
        for(i=i+1 ; i<A.length; i++) //recorre la lista donde estan los pesos.
        {
            if(A[i].peso<A[i-1].peso)
            {
                ayuda = A[i]; //ordena la lista.
                A[i]= A[i-1];
                A[i-1] = ayuda;
                i = i-1;
                ordenar(A, ayuda, i);
            }
        }
    }

    


    public grafo [] leer(int Matriz[][], int numnodos, int numcaminos)
    {
//este va a ser el arreglo donde meto todos los caminos con los pesos por obvias razones debe ser del tamaño de los caminos
        grafo todos[] = new grafo[numcaminos];
        grafo ayuda = new grafo();
        int k;
        k=0;
        for(int i=0; i<numnodos; i++)
        {            
            for(int j=0; j<=i; j++)
            {
                if(i!=j && Matriz[i][j]!=0)
                {
                    todos[k]= new grafo(i,j,Matriz[i][j]); //Guarda los pesos en una lista de "grafos" que tiene inicio, fin y peso.
                    k++;
                }
            }            
        }

                

        ordenar(todos,ayuda, 0);
//        m.imprimir(todos);
        System.out.println();
        return todos;   
    }


}



class metodo
{
//esta función me ayuda a ver si ya metí un nodo o así para no meterlo en la sol. así como que no se cicle     
    

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int existencia(grafo comp, int ayuda[])
    {
        int cont = 0;
        for(int i=0; i<ayuda.length; i++)
        {
            if(ayuda[i]== 1)
            {                
                if(i==comp.ini)
                {
                        for(int j=0; j<ayuda.length; j++)
                        {
                            if(ayuda[j]== 1)
                            {                
                                if(j==comp.fin)
                                {
                                return 0;
                                }
                            }
                        }
                }
            }
        }
        for(int i=0; i<ayuda.length; i++)
        {
            if(ayuda[i] == 1)
            {
                cont=+1;
            }
        }        
        if(cont==ayuda.length)
        {
            return 0;
        }

                
        return 1;
    }



    public void camino( grafo todos[], int numnodos, int numcaminos, grafo sol[])
    {
        int loop[] = new int[numnodos];

        int ayuda;
        int k;
        k=0;
        for(int i=0; i<numcaminos; i++)
        {
            ayuda= existencia(todos[i], loop);
            if(ayuda!=0 && k<numnodos-1)
            {
                sol[k] = todos[i];
                loop[todos[i].ini]=1;
                loop[todos[i].fin]=1;
                k++;
            }
        }
        for(int i=0; i<loop.length; i++)
        {
        System.out.print(loop[i]);
        }    
    }



/////////////////////////////////////////////////////////////////////////////Imprimir


    public void imprimir(grafo algo[])
    {
        for(int i=0; i<algo.length; i++)
        {
            System.out.println("Del nodo " +(algo[i].ini+1) +" al nodo " +(algo[i].fin+1) +" con peso " +algo[i].peso) ;
        }
    }
//////////////////////////////////////////////////////////////////////////Main
    public static void main(String[] Args)
    {
        int numnodos;
        int numcaminos;
        int matriz[][];
        grafo todos[];
        grafo sol[];
        
//sólo para llamar los metodos de grafo
        grafo myclase = new grafo();
        metodo myclase2 = new metodo();

        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dame el número de nodos");
        numnodos = sc.nextInt();
        System.out.println("Dame el número de caminos");
        numcaminos = sc.nextInt();
       
    
        matriz = new int[numnodos][numnodos];
        todos = new grafo[numcaminos];
        sol =new grafo[numnodos-1];

        for(int i=0; i<numnodos; i++)
        {
            for(int j=0; j<numnodos; j++)
            {
                System.out.println("Dame la posición " +i +j + " de la matriz");
                matriz[i][j] = sc.nextInt();
            }
        }
        
//LLamo los métodos que cree
        todos = myclase.leer(matriz, numnodos, numcaminos);
        myclase2.camino(todos, numnodos, numcaminos,sol);
        myclase2.imprimir(sol);
        System.out.println("fortran es mejor que java");
//        myclase2.imprimir(todos);

    }

    
}
