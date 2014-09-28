package cliente;


public class Estudiante extends Persona {
	private static final long serialVersionUID = 1L;
	private String carne;
	private String lugarEstudio;
	private String carrera;
	private String tipo = "estudiante";
	
	//Constructor de la clase
	public Estudiante(String nombre,String primerApellido,String segundoApellido,
						String edad,String telefono,String correo,
						String carne,String lugarEstudio,String carrera) {
		super(nombre,primerApellido,segundoApellido,edad,telefono,correo);
		setCarne(carne);
		setLugarEstudio(lugarEstudio);
		setCarrera(carrera);
	}
	
	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
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
		msg+="Carn�: "+getCarne()+"\n";
		msg+="Lugar de Estudio: "+getLugarEstudio()+"\n";
		msg+="Carrera: "+getCarrera()+"\n";
		return msg;
	}
}

