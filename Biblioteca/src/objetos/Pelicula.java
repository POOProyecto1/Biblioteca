package objetos;


public class Pelicula extends Articulo {
	private String compania;
	
	public Pelicula(String titulo, String imagen, String annio, double calificacion, String compania) {
		super(titulo, imagen, calificacion, annio);
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
		respuesta = compania+"*"+titulo+"*"+imagen+"*"+calificacion+"*"+annio+"*"+prestatario+"*"+diasPrestado+"\n";
		int longitud = fechaPrestamos.size();;
		int contador = 0;
		while(contador != longitud) {
			respuesta += "," + fechaPrestamos.get(contador);
			contador += 1;
		}
		return respuesta;
	}
}
