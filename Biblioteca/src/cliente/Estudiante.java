package cliente;


public class Estudiante extends Persona {
	private static final long serialVersionUID = 1L;
	private String carné;
	private String lugarEstudio;
	private String carrera;
	private String tipo = "estudiante";
	
	//Constructor de la clase
	public Estudiante(String nombre,String primerApellido,String segundoApellido,
						String edad,String direccion,String telefono,String correo,
						String carné,String lugarEstudio,String carrera,String cedula) {
		super(nombre,primerApellido,segundoApellido,edad,direccion,telefono,correo,cedula);
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
	
	public String getTipo(){
		return tipo;
	}
	
	public String toString() { // Impresión de toda la información personal del prestatario
		String msg = super.toString();
		msg+="Carné: "+getCarné()+"\n";
		msg+="Lugar de Estudio: "+getLugarEstudio()+"\n";
		msg+="Carrera: "+getCarrera()+"\n";
		return msg;
	}
}
