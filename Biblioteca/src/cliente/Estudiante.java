package cliente;


public class Estudiante extends Persona {
	private static final long serialVersionUID = 1L;
	private String carn�;
	private String lugarEstudio;
	private String carrera;
	private String tipo = "estudiante";
	
	//Constructor de la clase
	public Estudiante(String nombre,String primerApellido,String segundoApellido,
						String edad,String direccion,String telefono,String correo,
						String carn�,String lugarEstudio,String carrera,String cedula) {
		super(nombre,primerApellido,segundoApellido,edad,direccion,telefono,correo,cedula);
		setCarn�(carn�);
		setLugarEstudio(lugarEstudio);
		setCarrera(carrera);
	}
	
	public String getCarn�() {
		return carn�;
	}

	public void setCarn�(String carn�) {
		this.carn� = carn�;
	}

	public String getLugarEstudio() {
		return lugarEstudio;
	}

	public void setLugarEstudio(String lugarEstudio) {
		this.lugarEstudio = lugarEstudio;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public String toString() { // Impresi�n de toda la informaci�n personal del prestatario
		String msg = super.toString();
		msg+="Carn�: "+getCarn�()+"\n";
		msg+="Lugar de Estudio: "+getLugarEstudio()+"\n";
		msg+="Carrera: "+getCarrera()+"\n";
		return msg;
	}
}
