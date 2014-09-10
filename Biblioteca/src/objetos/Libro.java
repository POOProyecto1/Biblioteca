package objetos;
import java.util.ArrayList;
import cliente.Persona;	//Se importa la clase Persona, ya que un libro puede o no estar prestado a una Persona

public class Libro extends Articulo {
	protected String edicion;
	protected String editorial;
	protected String autor;
	
	public Libro(String titulo, String imagen, int annio, String edicion, String editorial, String autor) {
		super(titulo, imagen, annio);
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
		respuesta=edicion+"*"+editorial+"*"+autor+"*"+titulo+"*"+imagen+"*"+calificacion+"*"+annio+"*"+codigo+"*"+prestatario+"*"+diasPrestado+"*";
		int longitud=fechaPrestamos.length();
		int contador=0;
		while(contador!=longitud) {
			respuesta+=","+fechaPrestamos[i];
			contador+=1;
		}
	}
}
