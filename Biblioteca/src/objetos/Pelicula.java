package objetos;

//Clase Pelicula, hereda de la clase Articulo
public class Pelicula extends Articulo {
	private static final long serialVersionUID = 1L;  //serial identificador de version la clase
	private String compania;
	
        //constructor
	public Pelicula(String titulo, String imagen, int calificacion, String compania) {
		super(titulo, imagen, calificacion);
		setCompania(compania);
	}


	
	//setters y getters
	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}


	//retorna los datos del objeto en forma de String
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
