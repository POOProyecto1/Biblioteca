package registro;
//se importan los elementos necesarios para el correcto funcionamiento de la clase
import java.util.ArrayList;
import java.util.Collections;

import cliente.Persona;
import objetos.Articulo;

import enviarMail.javamail;

import almacenamientoDatos.Almacenamiento;

//clase Registro implementa de Comparable
public class Registro implements Comparable {
	public static ArrayList<Object> personas=new ArrayList<Object>();		//lista que contiene a las personas
	public static ArrayList<Object> articulos=new ArrayList<Object>();		//lista que contiene los articulos
	Almacenamiento datos=new Almacenamiento();					//instancia de Amacenamiento
	javamail sendMail=new javamail();						//Instancia de javamail
	

	public Registro() {
		leer();
		notificar();
	}
	
	// Ordenamiento basado en un código de Internet
	//Encargada de comparar objetos para ordenarlos
	//recibe un objeto
	//retorna int
	public int compareTo(Object cmp) {
		int order = 0;
        Articulo articulo = (Articulo)cmp;        
        if(this.titulo.compareTo(articulo.getTitulo()) < 0){ 
        	order = -1; 
        }
        else if(this.titulo.compareTo(articulo.getTitulo()) > 0) { 
        	order = 1; 
        }  
       return order; 
    }
	
	/*
	funcion  guardar
	se encarga de guardar un ArrayList en un .txt
	no recibe parámetros
	devuelve boolean
	*/
	public boolean guardar(){
		boolean resultadoP= datos.guardar(getPersonas(), "Personas");
		boolean resultadoA=datos.guardar(getArticulos(), "Articulos");
		if(resultadoP==true&&resultadoA==true){ //verifica que ambos procesos hayan finalizado correctamente
			return true;
		}else{
			return false;
		}
	}
	/*
	método leer
	se encarga de leer datos desde un .txt
	y almacenarlos en sus respectivas listas
	*/
	public void leer(){
		setArticulos(datos.cargar("Articulos"));
		setPersonas(datos.cargar("Personas"));		
	}
	
	/*
	Método notificar
	Encargado de verificar el estado de morosidad de todas las personas y enviar correos electronicos si estas tienen morosidad
	*/
	public void notificar(){
		int contador=0;
		personas=getPersonas();		//carga la lista de personas en una variable local
		Persona cliente;
		System.out.println("Enviando Notificaiones:");
		for (int i = 0; i < personas.size(); i++) {		//revisa una por una a las personas
			cliente=((Persona) personas.get(i));
			if(cliente.verificarMorosidad()==true){		//si la persona es morosa, se procede a enviarle un correo electrónico
				System.out.println("Resultado de envío a "+cliente.getNombre()+" "+cliente.getPrimerApellido()+" "+cliente.getSegundoApellido()+": ");
				boolean resultado=sendMail.enviarCorreo(cliente.getCorreo(), "Aviso de Morosidad", "Estimad@ "+cliente.getNombre()+" se le recuerda que el articulo "+cliente.getPrestamo()+" se encuentra vencido.\nSe le solicita devolverlo lo más pronto posible.\nAtte: Virtualiteca\nGracias.");
				System.out.println(resultado);
				if(resultado==true){contador+=1;};
			}
		}
		System.out.println("Se han enviado exitosamente "+contador+" notificaciones.");
	}
	
	/////////////////////
	// Setter y Getters//
	/////////////////////
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
