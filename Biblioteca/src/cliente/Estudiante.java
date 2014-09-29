package cliente;

//clase Cliente que hereda de la clase Persona
public class Estudiante extends Persona {
	private static final long serialVersionUID = 1L;  //identiifcador de la clase, necesario para guardarlo en un .txt
	private String carne;			//numero de carné
	private String lugarEstudio;		
	private String carrera;			//carrera del estudiante
	private String tipo = "estudiante";	//tipo de la clase
	
	//Constructor de la clase
		public Estudiante(String nombre,String primerApellido,String segundoApellido,
						String telefono,String correo) {
		super(nombre,primerApellido,segundoApellido,telefono,correo);
	}

	 
	//funcion que retorna el valor del atributo carne
	public String getCarne() {
		return carne;
	}
	//método que le esteblece un valor al atributo carne
	public void setCarne(String carne) {
		this.carne = carne;
	}
	
	//funcion que retorna el valor del atributo lugarEstudio
	public String getLugarEstudio() {
		return lugarEstudio;
	}
	//método que le esteblece un valor al atributo lugarEstudio
	public void setLugarEstudio(String lugarEstudio) {
		this.lugarEstudio = lugarEstudio;
	}
	//funcion que retorna el valor del atributo carrera
	public String getCarrera() {
		return carrera;
	}
	//método que le esteblece un valor al atributo carrera
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	//funcion que retorna el valor del atributo tipo
	public String getTipo(){
		return tipo;
	}
	
	public String toString() { // ImpresiĂłn de toda la informaciĂłn personal del prestatario
		String msg = super.toString();
		msg+="Carné: "+getCarne()+"\n";
		msg+="Lugar de Estudio: "+getLugarEstudio()+"\n";
		msg+="Carrera: "+getCarrera()+"\n";
		return msg;
	}
}

