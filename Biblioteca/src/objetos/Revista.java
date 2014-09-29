 package objetos;
//Clase Revista, hereda de la clase Artículo
public class Revista extends Articulo {
	private static final long serialVersionUID = 1L; // serial identificador de la clase
	private String edicion;
	private String editorial;
	
	//Constructor
	public Revista(String titulo, String imagen, int calificacion, String edicion, String editorial) {
		super(titulo, imagen, calificacion);
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

	//retorna la datos del objeto, en forma de string
	public String toString() {
		String respuesta;
		respuesta = edicion+"*"+editorial+"*"+titulo+"*"+imagen+"*"+calificacion+"*"+annio+"*"+prestatario+"*"+diasPrestado+"\n";
		int longitud = fechaPrestamos.size();
		int contador = 0;
		while(contador != longitud) {
			respuesta += "," + fechaPrestamos.get(contador);
			contador += 1;
		}
		return respuesta;
	}
}
