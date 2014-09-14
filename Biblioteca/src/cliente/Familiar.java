package cliente;

public class Familiar extends Persona {
	private String parentesco;
	
	public Familiar(String nombre, String primerApellido,
			String segundoApellido, String edad, String direccion,
			String telefono, String correo,String parentesco,String cedula) {
		super(nombre, primerApellido, segundoApellido, edad, direccion, telefono,
				correo,cedula);
		setParentesco(parentesco);
	}
	
	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String toString() {
		String msg=super.toString();
		msg+="Parentesco: "+getParentesco()+"\n";
		return msg;
	}
}
