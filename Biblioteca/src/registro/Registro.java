package registro;

import java.util.ArrayList;

import almacenamientoDatos.Almacenamiento;

public class Registro {
	ArrayList<Object> personas=new ArrayList<Object>();
	ArrayList<Object> articulos=new ArrayList<Object>();
	Almacenamiento datos=new Almacenamiento();
	
	
	public Registro() {
		leer();
	}
	
	public boolean guardar(){
		boolean resultadoP= datos.guardar(getPersonas(), "Personas");
		boolean resultadoA=datos.guardar(getArticulos(), "Articulos");
		if(resultadoP==true&&resultadoA==true){
			return true;
		}else{
			return false;
		}
	}
	
	public void leer(){
		setArticulos(datos.cargar("Articulos"));
		setPersonas(datos.cargar("Personas"));		
	}

	public ArrayList<Object> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Object> personas) {
		this.personas = personas;
	}

	public ArrayList<Object> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Object> articulos) {
		this.articulos = articulos;
	}
	
	

}
