package cliente;

public class Colega extends Persona {
	private String puesto;
	private String lugarTrabajo;
	public Colega(String nombre,String primerApellido,String segundoApellido,
			String edad,String direccion,String telefono,String correo,String puesto,String lugarTrabajo) {
		super( nombre, primerApellido, segundoApellido,
			 edad, direccion, telefono, correo);
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

	/*public static void getString() {    //Es un método static, ya que a la hora de cargar personas desde un txt,no existe ninguna persona creada
	//TODO
	}
	
	public String toString() {
	//TODO
	}*/
}
