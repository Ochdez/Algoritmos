
public class camino {
	int padre;
	int hijo;
	
	public camino(int padre, int hijo){
		this.padre = padre;
		this.hijo = hijo;
	}
	
	public void setCamino(int a, int b){
		
		if(hijo == a){
			padre = b;
		}
		else{
			hijo = a;
			padre = b;
		}
		
	}

}
