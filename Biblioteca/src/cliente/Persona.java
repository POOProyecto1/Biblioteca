package cliente;

import java.util.ArrayList;
import objetos.Articulo;	//Se importa la clase Articulo, ya que una persona puede tener o no artÃ­culos en prÃ©stamo
import java.io.Serializable;

import registro.Registro;


public class Persona implements Serializable {    //se implementa Serializable, ya que es necesario a la hora de guardar una instancia en un txt
	private static final long serialVersionUID = 1L;
// Los atributos están en protected para que puedan ser accedidos por las clases hijas o clases en el mismo paquete
	protected String edad;
	protected String prestamo=null;  //guarda el nombre del articulo que tiene el prestamo
	protected String nombre;
	protected String primerApellido;
	protected String segundoApellido;
	protected String telefono;
	protected String correo;
	protected boolean morosidad;
	
	//Constructor de la clase
	public Persona(String nombre,String primerApellido,String segundoApellido,
			String edad,String telefono,String correo) {
		//AsignaciÃ³n de valores a los atributos
		setEdad(edad);
		setNombre(nombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
		setTelefono(telefono);
		setCorreo(correo);
		setMorosidad(false); 
		}
	

	//Set y get de todos los atributos
	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad=edad;
	}


	
	public String getPrestamo() {
		return prestamo;
	}

	//Agrega un nuevo artÃ­culo a los que tiene el usuario actualmente en prÃ©stamo.
	public void setPrestamo(String prestamo) {
		this.prestamo=prestamo;			
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
	
	public boolean getMorosidad(){
		return morosidad;
	}
	

	//Funcion verificar correo: analiza el correo ingresado para evitar problemas a la hora de enviar notificaciones.
	//Se crea static, ya que es necesario 
	public static boolean verificarCorreo(String correo){   
		if(correo.contains("@")){     //busca que el correo contenga un "@"
			String[] temp=correo.split("@");	//separa el correo en dos partes mediante el "@"
			if(temp[0].length()!=0){			//si esta condición se cumple significa que existe un nombre de usuario antes del "@"
				if (temp[1].contains(".")){		//verifica que exista un "." al lado derecho del "@"
					if (temp[1].startsWith(".")){ //si esta condición se cumple significa que no existe nada entre "@" y "."
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
		ArrayList<Object> biblioteca=Registro.articulos;
		if (getPrestamo()!=null){
			String nombre =getPrestamo();
			for (int i=0;i<biblioteca.size();i++) {
				if (((Articulo)biblioteca.get(i)).getTitulo().equals(nombre)){
					if(((Articulo)biblioteca.get(i)).isVencido()){
						setMorosidad(true);
						return true;
					}
				}
			}
			return false;
		}
		else{
			return false;
		}
	}
	
	public String toString() { // ImpresiÃ³n de toda la informaciÃ³n personal del prestatario
		String msg = "";
		
		msg = "Nombre Completo: " + getNombre() +" "+ getPrimerApellido() +" "+ getSegundoApellido() + "\n";
		msg += "Edad: " + getEdad() + "\n";
		msg += "Teléfono: " + getTelefono() + "\n";
		msg += "Email de contacto: " + getCorreo() + "\n";
		msg += "Moroso :" + getMorosidad() + "\n";
		return msg;
	}



}
