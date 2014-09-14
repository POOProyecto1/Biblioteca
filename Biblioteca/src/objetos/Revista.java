 package objetos;

public class Revista extends Articulo {
	private String edicion;
	private String editorial;
	
	public Revista(String titulo, String imagen, String annio, double calificacion, String codigo, String edicion, String editorial) {
		super(titulo, imagen, calificacion, annio, codigo);
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
		respuesta = edicion+"*"+editorial+"*"+titulo+"*"+imagen+"*"+calificacion+"*"+annio+"*"+codigo+"*"+prestatario+"*"+diasPrestado+"\n";
		int longitud = fechaPrestamos.size();
		int contador = 0;
		while(contador != longitud) {
			respuesta += "," + fechaPrestamos.get(contador);
			contador += 1;
		}
		return respuesta;
	}
}
