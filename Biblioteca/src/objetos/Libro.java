package objetos;


public class Libro extends Articulo {
	private String edicion;
	private String editorial;
	private String autor;
	
	public Libro(String titulo, String imagen, int annio, float calificacion, String codigo, String edicion, String editorial, String autor) {
		super(titulo, imagen, calificacion, annio, codigo);
		setEdicion(edicion);
		setEditorial(editorial);
		setAutor(autor);
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String toString() {
		String respuesta;
		respuesta = edicion + "*" + editorial + "*" + autor +"*" + titulo + "*" + imagen + "*" + calificacion +"*" + annio + "*" + codigo + "*" + prestatario + "*" + diasPrestado + "*";
		int longitud = ((CharSequence) fechaPrestamos).length();
		int contador = 0;
		while(contador != longitud) {
			respuesta += "," + fechaPrestamos.get(contador);
			contador += 1;
		}
		return respuesta;
	}
}
