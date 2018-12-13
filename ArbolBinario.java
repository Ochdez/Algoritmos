
public class ArbolBinario {

	public static void main(String[] args) {
		
		Arbol arbol = new Arbol();
		arbol.agregar(45);
		arbol.agregar(10);
		arbol.agregar(15);
		arbol.agregar(52);
		arbol.agregar(27);
		arbol.agregar(20);
		arbol.agregar(41);
		arbol.agregar(29);
		arbol.agregar(42);
		
				
		System.out.println(arbol.borrar(20));
		
		
		arbol.InOrden();
		System.out.println();
		arbol.PreOrden();
		System.out.println();
		arbol.PostOrden();


	}

}

class Arbol {
	
Nodo raiz = null;
	
	public void agregar(int dato) {
		
		Nodo nuevoNodo = new Nodo(dato);
		
		if(raiz == null) {
			raiz = nuevoNodo;
		}
		else {
			Nodo actual = raiz;
			Nodo padre;
			
			while(true) {
				padre = actual;
				if(dato < actual.dato) {
					actual = actual.izquierda; 
					if(actual == null) {   
						padre.izquierda = nuevoNodo;
						return;
					}
				}else {
					actual = actual.derecha;
					if(actual == null) {
						padre.derecha = nuevoNodo;
						return;
					}
				}
			}
		}
	}
	
		
	public String borrar(int dato) {
				
		Nodo a = raiz;
		Nodo padre = raiz;
		boolean a_laizquierda = false; //para saber si el dato a eliminar está a la izquierda o no.
		
		while(a.dato != dato) {
			padre = a;
			if(dato < a.dato) {
				a_laizquierda = true;
				a = a.izquierda; 
				
			}else {
				a = a.derecha;
				a_laizquierda = false;
			}
			if(a == null) {
				
				return "No se encuentra el dato";
			}
		}
		
		Nodo nodoAeliminar = a;
				
		if(nodoAeliminar.izquierda ==null && nodoAeliminar.derecha == null) {
			
			if(nodoAeliminar == raiz) {
				raiz = null;
			}else if(a_laizquierda) {
				padre.izquierda = null;
			}else {
				padre.derecha = null;
			}
		}
		
		else if(nodoAeliminar.derecha == null) {
			
			if(nodoAeliminar == raiz) {
				raiz = nodoAeliminar.izquierda;
			}else if(a_laizquierda) {
				padre.izquierda = nodoAeliminar.izquierda;				
			}else {
				padre.derecha = nodoAeliminar.izquierda;
			}
		}
		
		else if(nodoAeliminar.izquierda == null) {
			if(nodoAeliminar == raiz) {
				raiz = nodoAeliminar.derecha;
			}else if(a_laizquierda) {
				padre.izquierda = nodoAeliminar.derecha;				
			}else {
				padre.derecha = nodoAeliminar.derecha;
			}
		}
				
		
		
		else {
			
			Nodo sucesor = getSucesor(nodoAeliminar);
			
			
			if(nodoAeliminar == raiz) {
				raiz = sucesor;
			}else if(a_laizquierda) {
				padre.izquierda = sucesor;
			}else {
				padre.derecha = sucesor;
			}
		
		
		sucesor.izquierda = nodoAeliminar.izquierda; 
		}
		
		return "Se ha eliminado el numero: " + nodoAeliminar.dato;
		
		 
	}
	
	private Nodo getSucesor(Nodo nodoAeliminar) {
		Nodo sucesorPadre = nodoAeliminar;
		Nodo sucesor = nodoAeliminar;
		Nodo a = nodoAeliminar.derecha; 
		
		while(a != null) {
			sucesorPadre = sucesor;
			sucesor = a;
			a = a.izquierda;
		}
		
		if(sucesor != nodoAeliminar.derecha ) {
			sucesorPadre.izquierda = sucesor.derecha; 
			sucesor.derecha = nodoAeliminar.derecha;
		}
		return sucesor;
	}
	
	//In-orden
	public void InOrden() {
		if(raiz != null) {
			raiz.orden();
		}
	}
	
	//Pre-orden
	public void PreOrden() {
		if(raiz != null) {
			raiz.preorden();
		}
	}
	
	//Post-orden
	public void PostOrden() {
		if(raiz != null) {
			raiz.postorden();
		}
	}
	
	

}

class Nodo {
	
	int dato;
	Nodo izquierda, derecha;
	
	public Nodo(int dato) {
		this.dato = dato;
		
	}
	
	public void orden() {
		if(izquierda != null) {
			izquierda.orden();
		}
		System.out.print(dato + " ");
		if (derecha != null) {
			derecha.orden();
		}
	}
	
	public void preorden() {
		
		System.out.print(dato + " ");
		if(izquierda != null) {
			izquierda.preorden();
		}
		if(derecha != null) {
			derecha.preorden();
		}		
	}
	
	public void postorden() {
		if(izquierda != null) {
			izquierda.postorden();
			
		}
			
		if(derecha != null) {
			derecha.postorden();
		}
		System.out.print(dato + " ");
		
	}
}

