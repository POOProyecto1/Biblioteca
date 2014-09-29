package cliente;

//se importan los elementos necesarios para el correcto funcionamiento de la clase
import java.util.ArrayList;
import objetos.Articulo;	//Se importa la clase Articulo, ya que una persona puede tener o no artÃ­culos en prÃ©stamo
import java.io.Serializable;	//necesaria para poder guardar valores de la clase en un .txt

import registro.Registro;//se importa la clase registro

//Clase persona, implementa Serializable para poder guardar sus valores en un .txt
//Funciona como superclase de Estudiante,Familiar,Colega
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
	protected boolean morosidad;		//true si el articulo que tiene a prestamo está vencido, false si no.
	
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
	
	//funcion que retorna el valor del atributo edad
	public String getEdad() {
		return edad;
	}

	//método que establece un valor al atributo edad
	public void setEdad(String edad) {
		this.edad=edad;
	}


	//funcion que retorna el valor del atributo prestamo
	public String getPrestamo() {
		return prestamo;
	}

	//Guarda el nombre del artículo que tiene la persona a préstamo.
	public void setPrestamo(String prestamo) {
		this.prestamo=prestamo;			
	}

	//funcion que retorna el valor del atributo nombre
	public String getNombre() {
		return nombre;
	}

	//método que establece un valor al atributo nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//funcion que retorna el valor del atributo primerApellido
	public String getPrimerApellido() {
		return primerApellido;
	}

	//método que establece un valor al atributo primerApellido
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	//funcion que retorna el valor del atributo segundoApellido
	public String getSegundoApellido() {
		return segundoApellido;
	}

	//método que establece un valor al atributo segundoApellido
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	//funcion que retorna el valor del atributo telefono
	public String getTelefono() {
		return telefono;
	}

	//método que establece un valor al atributo telefono
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	//funcion que retorna el valor del atributo correo 
	public String getCorreo() {
		return correo;
	}

	//método que establece un valor al atributo correo
	//recibe string
	//retorna boolean
	public boolean setCorreo(String correo) {
		if(verificarCorreo(correo)){
			this.correo = correo;
			return true;
		}
		else{
			return false;
		}
	}
	//método que establece un valor al atributo morosidad
	public void setMorosidad(boolean morosidad) {
		this.morosidad = morosidad;
	}
	
	//funcion que retorna el valor del atributo morosidad
	public boolean getMorosidad(){
		return morosidad;
	}
	

	/*Funcion verificar correo: analiza el correo ingresado para evitar problemas a la hora de enviar notificaciones.
	Recibe un correo en forma de string
	retorna un boolean
	Se crea static, ya que es necesario utilizarla sin una instancia de Pesona
	*/
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
	
	/* función verificarMorosidad
	se encarga de verificar si articulo que se tiene a prestamo se encuentra vencido
	no recibe parámetros
	retorna boolean
	*/
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
