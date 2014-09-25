package almacenamientoDatos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import cliente.Persona;
 
public class Almacenamiento {
	
	public boolean guardar( ArrayList<Persona>persona, int numero){
		FileOutputStream salida= null;
		ObjectOutputStream objeto=null;
		File nameArchivo=new File("src/DatosPersonas","persona"+numero+".txt");
		try{
			salida= new FileOutputStream(nameArchivo);
			objeto=new ObjectOutputStream(salida);
			
			objeto.writeObject(persona);
		}
		catch(Exception e){return false;}
		finally{
			try {
				if (objeto!=null){
					objeto.close();
					return true;
				};
				return false;
			}
			catch (Exception e2) {}
		}
		return true;
	};
	
	
}
