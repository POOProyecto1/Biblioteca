package registro;

import java.util.ArrayList;

import cliente.Persona;

import enviarMail.javamail;

import almacenamientoDatos.Almacenamiento;

public class Registro {
	ArrayList<Object> personas=new ArrayList<Object>();
	ArrayList<Object> articulos=new ArrayList<Object>();
	Almacenamiento datos=new Almacenamiento();
	javamail sendMail=new javamail();
	
	
	
	public Registro() {
		leer();
		notificar();
	}
	
	public boolean guardar(){
		boolean resultadoP= datos.guardar(getPersonas(), "Personas");
		boolean resultadoA=datos.guardar(getArticulos(), "Articulos");
		if(resultadoP==true&&resultadoA==true){
			return true;
		}else{
			return false;
		}
	}
	
	public void leer(){
		setArticulos(datos.cargar("Articulos"));
		setPersonas(datos.cargar("Personas"));		
	}
	
	public void notificar(){
		int contador=0;
		System.out.println("Enviando Notificaiones:");
		for (int i = 0; i < personas.size(); i++) {
			Persona cliente=((Persona) personas.get(i));
			if(cliente.getMorosidad()==true){
				System.out.println("Resultado de envío a"+cliente.getNombre()+" "+cliente.getPrimerApellido()+" "+cliente.getSegundoApellido()+": ");
				boolean resultado=sendMail.enviarCorreo(cliente.getCorreo(), "Aviso de Morosidad", "Estimad@ "+cliente.getNombre()+" se le recuerda que el articulo "+cliente.getPrestamo()+" se encuentra vencido.\nSe le solicita devolverlo lo más pronto posible.\nAtte: Virtualiteca\nGracias.");
				System.out.println(resultado);
				if(resultado==true){contador+=1;};
			}
		}
		System.out.println("Se han enviado exitosamente "+contador+" notificaciones.");
	}

	public ArrayList<Object> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Object> personas) {
		this.personas = personas;
	}

	public ArrayList<Object> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Object> articulos) {
		this.articulos = articulos;
	}
	
	

}
