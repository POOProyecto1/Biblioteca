package cliente;


public class Estudiante extends Persona {
	private String carn�;
	private String lugarEstudio;
	private String carrera;
	
	//Constructor de la clase
	public Estudiante(String nombre,String primerApellido,String segundoApellido,
						String edad,String direccion,String telefono,String correo,
						String carn�,String lugarEstudio,String carrera) {
		super(nombre,primerApellido,segundoApellido,edad,direccion,telefono,correo);
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
	
	public String toString() { // Impresi�n de toda la informaci�n personal del prestatario
		String msg = "";
		msg = "Nombre Completo: " + getNombre() +" "+ getPrimerApellido() +" "+ getSegundoApellido() + "\n";
		msg += "Edad: " + getEdad() + "\n";
		msg += "Direcci�n exacta: " + getDireccion() + "\n";
		msg += "Tel�fono: " + getTelefono() + "\n";
		msg += "Email de contacto: " + getCorreo() + "\n";
		msg += "Moroso :" + verificarMorosidad() + "\n";
		msg+="Carn�: "+getCarn�()+"\n";
		msg+="Lugar de Estudio: "+getLugarEstudio()+"\n";
		msg+="Carrera: "+getCarrera()+"\n";
		return msg;
	}
}
