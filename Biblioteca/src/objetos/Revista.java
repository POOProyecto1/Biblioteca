package objetos;

import java.util.ArrayList;
import cliente.Persona;	//Se importa la clase Persona, ya que una revista puede o no estar prestado a una Persona

public class Revista extends Articulo {
	private String edicion;
	private String editorial;
	
	public Revista(String titulo, String imagen, int annio, float calificacion, String codigo, String edicion, String editorial, Persona prestatario) {
		super(titulo, imagen, calificacion, annio, codigo, prestatario);
		setEdicion(edicion);
		setEditorial(editorial);
	}

	
	//setters y getters
	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	
	public String toString() {
		String respuesta;
		respuesta = edicion+"*"+editorial+"*"+titulo+"*"+imagen+"*"+calificacion+"*"+annio+"*"+codigo+"*"+prestatario+"*"+diasPrestado+"*";
		int longitud = ((CharSequence) fechaPrestamos).length();
		int contador = 0;
		while(contador != longitud) {
			respuesta += "," + fechaPrestamos[i];
			contador += 1;
		}
	}
}
