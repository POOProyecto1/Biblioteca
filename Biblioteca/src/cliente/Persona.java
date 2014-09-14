package cliente;

import java.util.ArrayList;
import objetos.Articulo;	//Se importa la clase Articulo, ya que una persona puede tener o no art√≠culos en pr√©stamo


public class Persona { // Los atributos est·n en protected para que puedan ser accedidos por las clases hijas o clases en el mismo paquete
	protected int edad;
	protected String direccion;
	protected ArrayList<Articulo> prestamos;  //guarda el cÛdigo de los articulos prestados
	protected String nombre;
	protected String primerApellido;
	protected String segundoApellido;
	protected String telefono;
	protected String correo;
	protected boolean morosidad;
	
	//Constructor de la clase
	public Persona(String nombre,String primerApellido,String segundoApellido,
			String edad,String direccion,String telefono,String correo) {
		//Asignaci√≥n de valores a los atributos
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

	//Agrega un nuevo art√≠culo a los que tiene el usuario actualmente en pr√©stamo.
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


	public void setMorosidad(boolean morosidad) {
		this.morosidad = morosidad;
	}

	
	private boolean verificarCorreo(String correo){
		if(correo.contains("@")){
			String[] temp=correo.split("@");
			if (temp[1].contains(".")){
				return true;
			}
			else {
				return false;
			}
		} else {
			return false;	
		}
	}
	
	public boolean verificarMorosidad() {
		for (int i=0;i<prestamos.size();i++) {
			 if(prestamos.get(i).isVencido()){
				 return true;
			 }
		}
		return false;
	}
	
	//public ArrayList<Articulo> verArticulosVencidos() {
	//TODO
	//}
	
	public String toString() { // Impresi√≥n de toda la informaci√≥n personal del prestatario
		String msg = "";
		
		msg = "Nombre Completo: " + getNombre() + getPrimerApellido() + getSegundoApellido() + "\n";
		msg += "Edad: " + getEdad() + "\n";
		msg += "DirecciÛn exacta: " + getDireccion() + "\n";
		msg += "TelÈfono: " + getTelefono() + "\n";
		msg += "Email de contacto: " + getCorreo() + "\n";
		msg += "Moroso :" + verificarMorosidad() + "\n";
		return msg;
	}
}
