package cliente;

import java.util.ArrayList;
import objetos.Articulo;	//Se importa la clase Articulo, ya que una persona puede tener o no art√≠culos en pr√©stamo
import java.io.Serializable;


public class Persona implements Serializable {    //se implementa Serializable, ya que es necesario a la hora de guardar una instancia en un txt
	private static final long serialVersionUID = 1L;
// Los atributos est·n en protected para que puedan ser accedidos por las clases hijas o clases en el mismo paquete
	protected String edad;
	protected String direccion;
	protected ArrayList<Articulo> prestamos;  //guarda el cÛdigo de los articulos prestados
	protected String nombre;
	protected String primerApellido;
	protected String segundoApellido;
	protected String telefono;
	protected String correo;
	protected boolean morosidad;
	protected String cedula;
	
	//Constructor de la clase
	public Persona(String nombre,String primerApellido,String segundoApellido,
			String edad,String direccion,String telefono,String correo,String cedula) {
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
		setCedula(cedula);
	}
	

	//Set y get de todos los atributos
	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad=edad;
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
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	//Funcion verificar correo: analiza el correo ingresado para evitar problemas a la hora de enviar notificaciones.
	//Se crea static, ya que es necesario 
	public static boolean verificarCorreo(String correo){   
		if(correo.contains("@")){     //busca que el correo contenga un "@"
			String[] temp=correo.split("@");	//separa el correo en dos partes mediante el "@"
			if(temp[0].length()!=0){			//si esta condiciÛn se cumple significa que existe un nombre de usuario antes del "@"
				if (temp[1].contains(".")){		//verifica que exista un "." al lado derecho del "@"
					if (temp[1].startsWith(".")){ //si esta condiciÛn se cumple significa que no existe nada entre "@" y "."
						return false;
					}
					else{						//si existe un dominio entre "@" y "."
						if (temp[1].endsWith(".")){
							return false;
						}
						else{
							return true;
						}
					}
				}
				else {
					return false;
				}
			}else {
				return false;	
				}
			}
		else{
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
		
		msg = "Nombre Completo: " + getNombre() +" "+ getPrimerApellido() +" "+ getSegundoApellido() + "\n";
		msg += "Edad: " + getEdad() + "\n";
		msg += "DirecciÛn exacta: " + getDireccion() + "\n";
		msg += "TelÈfono: " + getTelefono() + "\n";
		msg += "Email de contacto: " + getCorreo() + "\n";
		msg += "Moroso :" + verificarMorosidad() + "\n";
		return msg;
	}



}
