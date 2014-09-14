package objetos;

import java.util.ArrayList;
import cliente.Persona;

public class Articulo {
	protected String titulo;
	protected String imagen;
	protected float calificacion;
	protected int annio;		
	protected String codigo;       
	protected Persona prestatario = null; //Persona que lo tiene en préstamo.
	protected int diasPrestado; //Lleva la cuenta de los dias que lleva prestado a un cliente
	protected boolean prestado; //Contiene el estado del artículo, true si alguna persona lo tiene,false si está disponible
	protected ArrayList<int[]>fechaPrestamos; //contiene la frecuencia de prestamos por mes.(Cada casilla es un mes)
	protected static int diasD;  //valor estandar de días de prestamo
	protected static int diasN;	//valor de dias de tolerancia
	protected static int diasM;   //valor de dias extra de tolerancia
	protected String estado; //Almacena el estado del libro en : verde, amarillo y rojo
	
	//Constructores de la clase
	
	//Constructor para artÃ­culos nuevos
	public Articulo(String titulo, String imagen, float calificacion, int annio, String codigo) {
		setTitulo(titulo);
		setImagen(imagen);
		setCalificacion(calificacion);
		setAnnio(annio);
		setCodigo(codigo);
		setDiasPrestado(0);
		setPrestado(false);	
	}
	
	//Constructor para cargar artÃ­culos existentes
	public Articulo(String titulo,String imagen,float calificacion,int annio,String codigo,
			int diasPrestado,boolean prestado,ArrayList<int[]> fechaPrestamos) {
	
		setTitulo(titulo);
		setImagen(imagen);
		setCalificacion(calificacion);
		setAnnio(annio);
		setCodigo(codigo);
		setDiasPrestado(0);
		setPrestado(false);	
		setDiasPrestado(diasPrestado);
		setPrestado(prestado);
		setFechaPrestamos(fechaPrestamos);
	}
	
	
	/////////////////////////
	//Funciones de la clase//
	/////////////////////////

	public boolean isVencido(){
		if(diasPrestado>diasD){
			setEstado("Amarillo");
			if(diasPrestado>diasN){
				setEstado("Rojo");
			}
			return true;
		}
		else{
			return false;
		}
	}
	//Agrega una solicitud de prestamos para llevar el conteo del "top libros"
	//public void addFechaPrestamos() {
	//TODO
	//}
		
	
	//retorna un string con la informaciÃ³n de la clase
	
	//public String toString() {
	//TODO
	//}
	
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

	
	public ArrayList<int[]> getFechaPrestamos() {
		return fechaPrestamos;
	}

	public void setFechaPrestamos(ArrayList<int[]> fechaPrestamos) {
		this.fechaPrestamos = fechaPrestamos;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;	
	}

	public static int getDiasD() {
		return diasD;
	}

	public static void setDiasD(int diasD) {
		Articulo.diasD = diasD;
	}

	public static int getDiasN() {
		return diasN;
	}

	public static void setDiasN(int diasN) {
		Articulo.diasN = diasN;
	}

	public static int getDiasM() {
		return diasM;
	}

	public static void setDiasM(int diasM) {
		Articulo.diasM = diasM;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
