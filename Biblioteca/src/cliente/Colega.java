package cliente;

public class Colega extends Persona {
	private static final long serialVersionUID = 1L;
	private String puesto;
	private String lugarTrabajo;
	private String tipo = "colega";
	
	public Colega(String nombre,String primerApellido,String segundoApellido,
			String edad,String direccion,String telefono,String correo,String puesto,String lugarTrabajo,String cedula) {
		super( nombre, primerApellido, segundoApellido,
			 edad, direccion, telefono, correo,cedula);
		setPuesto(puesto);
		setLugarTrabajo(lugarTrabajo);
	}
		
	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getLugarTrabajo() {
		return lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public String toString() {
		String msg=super.toString();
		msg+="Lugar de Trabajo: "+getLugarTrabajo()+"\n";
		msg+="Puesto: "+getPuesto()+"\n";
		return msg;
	}
}
