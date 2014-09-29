package cliente;
//Clase Familiar, hereda de la Clase Persona
public class Familiar extends Persona {
	private static final long serialVersionUID = 1L;  //identificador de la clase,necesaria para almacenar la clase en un .txt
	private String parentesco;
	private String tipo = "familiar";
	
	//constructor
	public Familiar(String nombre, String primerApellido,
			String segundoApellido, String edad,
			String telefono, String correo,String parentesco) {
		super(nombre, primerApellido, segundoApellido, edad, telefono,
				correo);
		setParentesco(parentesco);
	}
	//funcion que retorna el valor del atributo Parentesco
	public String getParentesco() {
		return parentesco;
	}
	//método que establece un valor en el atributo parentesco
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	//funcion que retorna el valor del atributo Tipo
	public String getTipo(){
		return tipo;
	}
	//funcion toString
	//Retorna información del objeto en forma de String
	public String toString() {
		String msg=super.toString();
		msg+="Parentesco: "+getParentesco()+"\n";
		return msg;
	}
}
