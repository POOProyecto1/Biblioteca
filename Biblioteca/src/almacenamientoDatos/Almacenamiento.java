package almacenamientoDatos;

//se importan elementos necesarios para el correcto funcionamiento de la clase
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream; 
import java.io.ObjectInputStream; 
 
//La clase Almacenamiento es la encargada de guardar y cargar objetos directamente desde archivos .txt
public class Almacenamiento {
	
	/*
	Función guardar
	guarda en un txt los objetos de una lista
	recibe un ArrayList de elementos tipo Object que serán guardados y un String que será agragado al nombre del .txt
	devuelve un boolean 
	*/
	public boolean guardar( ArrayList<Object> lista, String tipo){
		FileOutputStream salida= null;
		ObjectOutputStream objeto=null;
		File nameArchivo=new File("src/Datos","lista-"+tipo+".txt");    //define el nombre y la direccion del .txt
		try{
			salida= new FileOutputStream(nameArchivo);
			objeto=new ObjectOutputStream(salida);
			
			objeto.writeObject(lista);                               //escribe la lista en el .txt
		}
		catch(Exception e){return false;}
		finally{
			try {
				if (objeto!=null){
					objeto.close();
					System.out.println("\nEl archivo lista-"+tipo+".txt fue guardado exitosamente.\n");
					return true;
				};
				System.out.println("Ha ocurrido un error al guardar los datos.\n");
				return false;
			}
			catch (Exception e2) {}
		}
		return true;
	};
	
	/*
	Método cargar
	Recibe un String utilizado para determinar el archivo que se cargará
	Retorna un ArrayList con elementos de tipo Object
	*/
	public ArrayList<Object> cargar(String tipo){
		 ArrayList<Object>lista = new ArrayList<Object>();  //crea la lista en la que se cargará el contenido del .txt
		 
		 File nameArchivo=new File("src/Datos","lista-"+tipo+".txt");
		 FileInputStream entrada = null;
		 ObjectInputStream objeto = null;
		 
		 try{
			 entrada=new FileInputStream(nameArchivo);
			 objeto=new ObjectInputStream(entrada);
			 lista=(ArrayList<Object>)objeto.readObject();  //carga el contenido del .txt en:  lista
		 }catch(Exception e){}
		 finally{
			 try{
				 if(objeto!=null){
					objeto.close();           //cierra el .txt
					System.out.println("El archivo lista-"+tipo+".txt fue cargado con éxito.\n");
					return lista;            //devuelve la lista
				 }
				 System.out.println("Ha ocurrido un error al cargar los datos.\n");
				 return lista;
			 }
			 catch( Exception e2 ){}
		 }
		return lista;
	};
}
