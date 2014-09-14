package cliente;


public class Estudiante extends Persona {
	private String carné;
	private String lugarEstudio;
	private String carrera;
	
	//Constructor de la clase
	public Estudiante(String nombre,String primerApellido,String segundoApellido,
						String edad,String direccion,String telefono,String correo,
						String carné,String lugarEstudio,String carrera) {
		super(nombre,primerApellido,segundoApellido,edad,direccion,telefono,correo);
		setCarné(carné);
		setLugarEstudio(lugarEstudio);
		setCarrera(carrera);
	}
	
	public String getCarné() {
		return carné;
	}

	public void setCarné(String carné) {
		this.carné = carné;
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
	
	public String toString() { // Impresión de toda la información personal del prestatario
		String msg = "";
		msg = "Nombre Completo: " + getNombre() +" "+ getPrimerApellido() +" "+ getSegundoApellido() + "\n";
		msg += "Edad: " + getEdad() + "\n";
		msg += "Dirección exacta: " + getDireccion() + "\n";
		msg += "Teléfono: " + getTelefono() + "\n";
		msg += "Email de contacto: " + getCorreo() + "\n";
		msg += "Moroso :" + verificarMorosidad() + "\n";
		msg+="Carné: "+getCarné()+"\n";
		msg+="Lugar de Estudio: "+getLugarEstudio()+"\n";
		msg+="Carrera: "+getCarrera()+"\n";
		return msg;
	}
}
