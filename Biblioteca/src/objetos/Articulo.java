package objetos;

import java.util.ArrayList;

import cliente.Persona;

public class Articulo {
	protected String titulo;
	protected String imagen;
	protected double calificacion;
	protected String annio;		
	protected Persona prestatario = null; //Persona que lo tiene en préstamo.
	protected int diasPrestado; //Lleva la cuenta de los dias que lleva prestado a un cliente
	protected boolean prestado; //Contiene el estado del artículo, true si alguna persona lo tiene,false si está disponible
	protected ArrayList<Integer>fechaPrestamos; //contiene la frecuencia de prestamos por mes.(Cada casilla es un mes)
	protected static int diasD;  //valor estandar de días de prestamo
	protected static int diasN;	//valor de dias de tolerancia
	protected static int diasM;   //valor de dias extra de tolerancia
	protected String estado; //Almacena el estado del libro en : verde, amarillo y rojo
	protected static int casillaList;//contiene la posicion en la cual se está modificando el valor de frecuencia de prestamos dentro de fechaPrestamos 
	
	
	//Constructores de la clase
	
	//Constructor para artÃ­culos nuevos
	public Articulo(String titulo, String imagen, double calificacion, String annio) {
		setTitulo(titulo);
		setImagen(imagen);
		setCalificacion(calificacion);
		setAnnio(annio);
		setDiasPrestado(0);
		setPrestado(false);	
		fechaPrestamos=new ArrayList<Integer>();
		fechaPrestamos.add(0);
	}
	
	//Constructor para cargar artÃ­culos existentes
	public Articulo(String titulo,String imagen,double calificacion,String annio,
			int diasPrestado,boolean prestado,ArrayList<Integer> fechaPrestamos) {
	
		setTitulo(titulo);
		setImagen(imagen);
		setCalificacion(calificacion);
		setAnnio(annio);
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
	
	//adFechaPrestamos: Agrega una solicitud de prestamos para llevar el conteo del "top libros"
	public void addFechaPrestamos(int dias) {
		if (dias%30==0){
			fechaPrestamos.add(0);
			casillaList+=1;
		}
		int temp=fechaPrestamos.get(casillaList);
		fechaPrestamos.set(casillaList, temp+1);
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

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getAnnio() {
		return annio;
	}

	public void setAnnio(String annio) {
		this.annio = annio;
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

	
	public ArrayList<Integer> getFechaPrestamos() {
		return fechaPrestamos;
	}

	public void setFechaPrestamos(ArrayList<Integer> fechaPrestamos) {
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

	public static int getCasillaList() {
		return casillaList;
	}

	public static void setCasillaList(int casillaList) {
		Articulo.casillaList = casillaList;
	}

	
	
}
