
public class grafo {
    public int[][] adjM;
    public int numVertices;

    public grafo(int numVertices){
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

    public void ObtenerCaminoMenor(int NodoOrigen, int NodoDestino){

        int actual = 0, t = 0,k = 0, inf = 99999, pesoTemporal = inf;
        int destino, origen, cuenta = 0;

        caja[] colaDePrioridad = new caja[numVertices];
        for(int i=0; i<numVertices; i++){
            colaDePrioridad[i] = new caja(i, inf);
        }

        //ArrayList<> ruta = new ArrayList<>();  Busco crear un arrayList para almacenar el cmaino he irlo acrualizando sin
        //ncesidad de definir su dimención.
       

        while(colaDePrioridad[numVertices-1].getVertice() != numVertices){ //Revisa si no esta "vacía" la cola de prioridad

            for(int i=0; i < numVertices; i++){ //Visita a los vecinos de actual

                if(adjM[actual][i] != 0){ //evaluara solo los que tengan conección

                    for(int j=0; j < numVertices; j++){ 
                        if(i == colaDePrioridad[j].getVertice()){//Revisa si el vecino está en la cola de prioridad.

                            if(colaDePrioridad[j].getPeso() > (getEnlace(actual,i) + t)){ //Compara los pesos.
                                colaDePrioridad[j].setPeso(getEnlace(actual,i) + t); //Cambia el valor del peso al mas pequeño.
                                
                            }else{
                                continue;
                            }


                        }else{
                            continue;
                        }
                    }
                }else{
                    continue;
                }

            }
            //Termina de visitar a los vecinos
            for(int z=0; z<numVertices; z++){
                if(colaDePrioridad[z].getPeso() < pesoTemporal){ //Busca el peso menor dentro de la cola de prioridad.
                    pesoTemporal = colaDePrioridad[z].getPeso();
                    actual = colaDePrioridad[z].getVertice(); //Vertice cuyo peso es el menor
                }
            }
            pesoTemporal = inf;
            t = t + colaDePrioridad[actual].getPeso();
            colaDePrioridad[actual].setVertice(numVertices); //La manera como se saca de la lista

        }

        destino = NodoDestino;
        origen = NodoOrigen;

        while (destino != origen){
            for(int i=0; i<numVertices; i++){
                if(camino[i][0] == destino){
                    cuenta = cuenta + getEnlace(destino, camino[i][1]);
                    destino = camino[i][1];
                }
            }
        }

        System.out.println("Camino mas corto: " + camino);

    }


}

