package almacenamientoDatos;


import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileInputStream; 
import java.io.ObjectInputStream; 
 
public class Almacenamiento {
	
	public boolean guardar( ArrayList<Object> lista, String tipo){
		FileOutputStream salida= null;
		ObjectOutputStream objeto=null;
		File nameArchivo=new File("src/Datos","lista-"+tipo+".txt");
		try{
			salida= new FileOutputStream(nameArchivo);
			objeto=new ObjectOutputStream(salida);
			
			objeto.writeObject(lista);
		}
		catch(Exception e){return false;}
		finally{
			try {
				if (objeto!=null){
					objeto.close();
					System.out.println("\nEl archivo lista-"+tipo+".txt fue guardado exitosamente.");
					return true;
				};
				System.out.println("Ha ocurrido un error al guardar los datos.");
				return false;
			}
			catch (Exception e2) {}
		}
		return true;
	};
	
	public ArrayList<Object> cargar(String tipo){
		 ArrayList<Object>lista = new ArrayList<Object>();
		 
		 File nameArchivo=new File("src/Datos","lista-"+tipo+".txt");
		 FileInputStream entrada = null;
		 ObjectInputStream objeto = null;
		 
		 try{
			 entrada=new FileInputStream(nameArchivo);
			 objeto=new ObjectInputStream(entrada);
			 lista=(ArrayList<Object>)objeto.readObject();
		 }catch(Exception e){}
		 finally{
			 try{
				 if(objeto!=null){
					objeto.close();
					System.out.println("El archivo lista-"+tipo+".txt fue cargado con éxito.");
					return lista;
				 }
				 System.out.println("Ha ocurrido un error al cargar los datos.");
				 return lista;
			 }
			 catch( Exception e2 ){}
		 }
		
		return lista;
		 
	};
	
}
	

