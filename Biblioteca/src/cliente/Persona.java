package cliente;

import java.util.ArrayList;
import objetos.Articulo;	//Se importa la clase Articulo, ya que una persona puede tener o no artículos en préstamo


public class Persona {
	private int edad;
	private String direccion;
	ArrayList<Articulo> prestamos;  //guarda el código de los articulos perstados
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String telefono;
	private String correo;
	private boolean morosidad;
	
	//Constructor de la clase
	public Persona(String nombre,String primerApellido,String segundoApellido,
			String edad,String direccion,String telefono,String correo) {
		//Asignación de valores a los atributos
		setEdad(edad);
		setDireccion(direccion);
		prestamos=new ArrayList<Articulo>();
		setNombre(nombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
		setTelefono(telefono);
		setCorreo(correo);
		setMorosidad(false);
	}
	

	//Set y get de todos los atributos
	public int getEdad() {
		return edad;
	}


	public boolean setEdad(String edad) {
		try {
			this.edad =Integer.parseInt(edad);
			return true;
		} catch (java.lang.NumberFormatException e) {
			return false;
		}
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Articulo> getPrestamos() {
		return prestamos;
	}

	//Agrega un nuevo artículo a los que tiene el usuario actualmente en préstamo.
	public void setPrestamos(Articulo prestamo) {
		prestamos.add(prestamo);			
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPrimerApellido() {
		return primerApellido;
	}


	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}


	public String getSegundoApellido() {
		return segundoApellido;
	}


	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public boolean setCorreo(String correo) {
		if(verificarCorreo(correo)){
			this.correo = correo;
			return true;
		}
		else{
			return false;
		}
	}


	public boolean isMorosidad() {
		return morosidad;
	}


	public void setMorosidad(boolean morosidad) {
		this.morosidad = morosidad;
	}

	
	private boolean verificarCorreo(String correo){
		if(correo.contains("@")){
			String[] temp=correo.split("@");
			if (temp[1].contains(".")){
				return true;
			}
			else{
				return false;
			}
		}else{
			return false;	
		}
	}
	
	public boolean verificarMorosidad() {
	 //TODO
	}
	
	public ArrayList verArticulosVencidos() {
	//TODO
	}
	
	public String toString() {
	//TODO
	}*/
}
