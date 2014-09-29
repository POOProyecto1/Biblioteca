package cliente;

//Clase publica colega que hereda atributos y métodos de la clase Persona
public class Colega extends Persona {
	private static final long serialVersionUID = 1L;    //codigo de identificaión
	private String puesto;				//puesto del colega
	private String lugarTrabajo;			//lugar en donde labora
	private String tipo = "colega";			
	
	//Constructor
	public Colega(String nombre,String primerApellido,String segundoApellido,
			String telefono,String correo) {
		super( nombre, primerApellido, segundoApellido,
			 telefono, correo);
	}

		
	//funcion que retorna el puesto del colega	
	public String getPuesto() {
		return puesto;
	}
	//método que le esteblece un valor al atributo puesto 
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	//funcion que retorna el lugar de trabajo
	public String getLugarTrabajo() {
		return lugarTrabajo;
	}
	//método que le esteblece un valor al atributo lugarTrabajo
	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}
	//funcion que retorna el tipo de la clase
	public String getTipo(){
		return tipo;
	}
	//funcion que retorna el objeto en forma de String
	public String toString() {
		String msg=super.toString();
		msg+="Lugar de Trabajo: "+getLugarTrabajo()+"\n";
		msg+="Puesto: "+getPuesto()+"\n";
		return msg;
	}
}
