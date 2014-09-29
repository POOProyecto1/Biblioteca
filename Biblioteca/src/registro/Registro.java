package registro;

import java.util.ArrayList;
import java.util.Collections;

import cliente.Persona;
import objetos.Articulo;

import enviarMail.javamail;

import almacenamientoDatos.Almacenamiento;

public class Registro implements Comparable {
	public static ArrayList<Object> personas=new ArrayList<Object>();
	public static ArrayList<Object> articulos=new ArrayList<Object>();
	Almacenamiento datos=new Almacenamiento();
	javamail sendMail=new javamail();
	
	// Ordenamiento basado en un código de Internet
	public int compareTo(Object cmp) {
        Articulo articulo = (Articulo)cmp;        
        
        return this.titulo.compareTo(articulo.getTitulo());
    }
	
	
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
		personas=getPersonas();
		Persona cliente;
		System.out.println("Enviando Notificaiones:");
		for (int i = 0; i < personas.size(); i++) {
			cliente=((Persona) personas.get(i));
			if(cliente.verificarMorosidad()==true){
				System.out.println("Resultado de envío a "+cliente.getNombre()+" "+cliente.getPrimerApellido()+" "+cliente.getSegundoApellido()+": ");
				boolean resultado=sendMail.enviarCorreo(cliente.getCorreo(), "Aviso de Morosidad", "Estimad@ "+cliente.getNombre()+" se le recuerda que el articulo "+cliente.getPrestamo()+" se encuentra vencido.\nSe le solicita devolverlo lo más pronto posible.\nAtte: Virtualiteca\nGracias.");
				System.out.println(resultado);
				if(resultado==true){contador+=1;};
			}
		}
		System.out.println("Se han enviado exitosamente "+contador+" notificaciones.");
	}

	public static ArrayList<Object> getPersonas() {
		return personas;
	}

	public static void setPersonas(ArrayList<Object> personas) {
		Registro.personas = personas;
	}

	public static ArrayList<Object> getArticulos() {
		return articulos;
	}

	public static void setArticulos(ArrayList<Object> articulos) {
		Registro.articulos = articulos;
	}


	
	

}
