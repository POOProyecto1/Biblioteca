package objetos;
import java.util.ArrayList;
import cliente.Persona;	//Se importa la clase Persona, ya que una pelicula puede o no estar prestado a una Persona

public class Pelicula extends Articulo {
	protected String compania;
	
	public Pelicula(String titulo, String imagen, int annio, String compania) {
		super(titulo, imagen, annio);
		setCompania(compania);
	}

	
	//setters y getters
	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}


	
	public String toString() {
		String respuesta;
		respuesta=compania+"*"+titulo+"*"+imagen+"*"+calificacion+"*"+annio+"*"+codigo+"*"+prestatario+"*"+diasPrestado+"*";
		int longitud=fechaPrestamos.length();
		int contador=0;
		while(contador!=longitud) {
			respuesta+=","+fechaPrestamos[i];
			contador+=1;
		}
	}
}