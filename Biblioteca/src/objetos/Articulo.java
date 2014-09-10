package objetos;
import java.util.ArrayList;

import cliente.Persona;

public class Articulo {
	private String titulo;
	private String imagen;
	private float calificacion;
	private int annio;
	private String codigo;
	private Persona prestatario; 
	private int diasPrestado;
	private boolean prestado;
	private ArrayList<Articulo>fechaPrestamos;
	
	//Constructores
	
	//Constructor para artículos nuevos
	public Articulo(String titulo,String imagen,float calificacion,int annio,String codigo,Persona prestatario
			) {
	
		setTitulo(titulo);
		setImagen(imagen);
		setCalificacion(calificacion);
		setAnnio(annio);
		setCodigo(codigo);
		setPrestatario(prestatario);
		setDiasPrestado(0);
		setPrestado(false);	
	}
	
	//Constructor para cargar artículos existentes
	public Articulo(String titulo,String imagen,float calificacion,int annio,String codigo,Persona prestatario
			,int diasPrestado,boolean prestado,ArrayList<Articulo> fechaPrestamos) {
	
		setTitulo(titulo);
		setImagen(imagen);
		setCalificacion(calificacion);
		setAnnio(annio);
		setCodigo(codigo);
		setPrestatario(prestatario);
		setDiasPrestado(0);
		setPrestado(false);	
		setDiasPrestado(diasPrestado);
		setPrestado(prestado);
		setFechaPrestamos(fechaPrestamos);
	}
	
	
	/////////////////////////
	//Funciones de la clase//
	/////////////////////////

	
	//Agrega una solicitud de prestamos para llevar el conteo del "top libros"
	public void addFechaPrestamos() {
	
	}
		
	
	//retorna un string con la información de la clase
	public String toString() {
	
	}
	
	//////////////////////////
	/////Setter y getters/////
	//////////////////////////
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public int getAnnio() {
		return annio;
	}

	public void setAnnio(int annio) {
		this.annio = annio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Persona getPrestatario() {
		return prestatario;
	}

	public void setPrestatario(Persona prestatario) {
		this.prestatario = prestatario;
	}

	public int getDiasPrestado() {
		return diasPrestado;
	}

	public void setDiasPrestado(int diasPrestado) {
		this.diasPrestado = diasPrestado;
	}

	
	public ArrayList<Articulo> getFechaPrestamos() {
		return fechaPrestamos;
	}

	public void setFechaPrestamos(ArrayList<Articulo> fechaPrestamos) {
		this.fechaPrestamos = fechaPrestamos;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
}
