package objetos;

import java.util.ArrayList;

public class Pelicula extends Articulo {
	private String compania;
	
	public Pelicula(String titulo, String imagen, int annio, float calificacion, String codigo, String compania) {
		super(titulo, imagen, calificacion, annio, codigo);
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
		respuesta = compania+"*"+titulo+"*"+imagen+"*"+calificacion+"*"+annio+"*"+codigo+"*"+prestatario+"*"+diasPrestado+"*";
		int longitud = ((CharSequence) fechaPrestamos).length();
		int contador = 0;
		while(contador != longitud) {
			respuesta += "," + fechaPrestamos.get(contador);
			contador += 1;
		}
		return respuesta;
	}
}
