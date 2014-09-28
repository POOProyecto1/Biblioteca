package cliente;

public class Familiar extends Persona {
	private static final long serialVersionUID = 1L;
	private String parentesco;
	private String tipo = "familiar";
	
	public Familiar(String nombre, String primerApellido,
			String segundoApellido, String edad,
			String telefono, String correo,String parentesco) {
		super(nombre, primerApellido, segundoApellido, edad, telefono,
				correo);
		setParentesco(parentesco);
	}
	
	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	public String getTipo(){
		return tipo;
	}

	public String toString() {
		String msg=super.toString();
		msg+="Parentesco: "+getParentesco()+"\n";
		return msg;
	}
}
