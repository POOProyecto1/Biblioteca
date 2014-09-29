package interfaz;
import objetos.*;
import registro.*;
import registrar.*;
import recursos.*;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;

/* Esta clase es la ventana principal donde se motrara el programa.
 */

public class Interfaz extends JFrame{ //implements ActionListener{
	JPanel contenedor = new JPanel();
	JScrollPane panelGrid = new JScrollPane();
	GridBagConstraints grid = new GridBagConstraints();
	JMenuBar menuBar = new JMenuBar();
	JMenu mnArticulos = new JMenu("Articulos");
	JMenu mnPrestamos = new JMenu("Prestamos");
	
	JMenu mnRegistrar = new JMenu("Registrar");
	JMenuItem mntmCliente = new JMenuItem("Cliente");
	JMenuItem mntmArticulo = new JMenuItem("Articulo");
	
	JMenu mnEditar = new JMenu("Editar");
	JMenuItem mntmECliente = new JMenuItem("Cliente");
	JMenuItem mntmEArticulo = new JMenuItem("Articulo");
	
	ImageIcon logo = new ImageIcon(this.getClass().getResource("/recursos/logo.jpg"));
	ImageIcon invis = new ImageIcon(this.getClass().getResource("/recursos/invisible.png"));
	JLabel logoi = new JLabel(logo);
	JLabel invisi = new JLabel(invis);
	
	String [] nColumnasL = {"Titulo", "Autor/Edicion/Annio","Editorial","Calificacion","Imagen"};
	int numArticulos = 0;
	ArrayList<ArrayList<Object>> listaArticulos;
	
	public static int diasP = 0;
	public static int top = 10;
	public static int veces = 3;
	public static int meses = 6;
	
	ArrayList<Object> personas;
	ArrayList<Object> articulos;
	static Registro registro = new Registro();
	
	//JTable tablaA = new JTable(infoArticulos, nColumnasL);
	
	private final JMenuItem mntmLibros = new JMenuItem("Libros");
	private final JMenuItem mntmRevistas = new JMenuItem("Revistas");
	private final JMenuItem mntmPeliculas = new JMenuItem("Peliculas");
	
	private final JMenuItem mntmLibrosP = new JMenuItem("Libros Prestados");
	private final JMenuItem mntmLibrosNP = new JMenuItem("Libros no Prestados");
	private final JMenuItem mntmRevistasP = new JMenuItem("Revistas Prestadas");
	private final JMenuItem mntmRevistasNP = new JMenuItem("Revistas no Prestadas");
	private final JMenuItem mntmPeliculasP = new JMenuItem("Peliculas Prestadas");
	private final JMenuItem mntmPeliculasNP = new JMenuItem("Peliculas no Prestadas");
	
	private final JMenu mnPrestar = new JMenu("Prestar");
	private final JMenuItem mntmLibro = new JMenuItem("Libro");
	private final JMenuItem mntmRevista = new JMenuItem("Revista");
	private final JMenuItem mntmPelicula = new JMenuItem("Pelicula");
	
	public Interfaz() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Virtualiteca");
		meterWidgets();
		getContentPane().add(contenedor);
		setVisible(true);
	}
	
/* Esta funcion le agrega al panel principal los elementos del menu
 * y la imagen de fondo (nuestro logo). Tambien dentro de ella se defije
 * que pasara cada vez que se presione una opcion del menu.
*/
	public void meterWidgets(){
		contenedor.setLayout(new BorderLayout());
		contenedor.add(menuBar, BorderLayout.NORTH);
		menuBar.add(mnArticulos);
		menuBar.add(mnPrestamos);
		menuBar.add(mnRegistrar);
		menuBar.add(mnEditar);
		
		mnEditar.add(mntmEArticulo);
		mnEditar.add(mntmECliente);
		
		mnRegistrar.add(mntmCliente);
		mnRegistrar.add(mntmArticulo);
		
		mnPrestamos.add(mntmLibrosP);
		mnPrestamos.add(mntmLibrosNP);
		mnPrestamos.add(mntmRevistasP);
		mnPrestamos.add(mntmRevistasNP);
		mnPrestamos.add(mntmPeliculasP);
		mnPrestamos.add(mntmPeliculasNP);
		
		mnArticulos.add(mntmLibros);
		mnArticulos.add(mntmRevistas);
		mnArticulos.add(mntmPeliculas);
		
		menuBar.add(mnPrestar);
		mnPrestar.add(mntmLibro);
		mnPrestar.add(mntmRevista);
		mnPrestar.add(mntmPelicula);
		
		contenedor.add(logoi, BorderLayout.CENTER);
		contenedor.add(logoi);
		
		/*Este bloque de funciones define lo que sucedera cuando se presione alguna
		 * opcion del menu. Hasta el proximo comentario todas haran lo mismo: borrar la
		 * imagen de fondo, poner el fondo del panel blanco, llamar a una funcion
		 * que retornara la cantidad de articulos que cumplen con las condiciones descritas
		 * en el parentesis (tipo, prestado/no prestado/todos)
		 * 
		*/
		mntmPeliculasNP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				contenedor.setBackground(Color.WHITE);
				numArticulos = getNumA("pelicula", "no prestados");
				listaArticulos = getListaA("pelicula", "no prestados");
				mostrarA(numArticulos,4,listaArticulos);
			}
		});
		mntmRevistasNP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				contenedor.setBackground(Color.WHITE);
				numArticulos = getNumA("revista", "no prestados");
				listaArticulos = getListaA("revista", "no prestados");
				mostrarA(numArticulos,5,listaArticulos);
			}
		});
		mntmLibrosNP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				contenedor.setBackground(Color.WHITE);
				numArticulos = getNumA("libro", "no prestados");
				listaArticulos = getListaA("libro", "no prestados");
				mostrarA(numArticulos,6,listaArticulos);
			}
		});
		
		mntmPeliculasP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				contenedor.setBackground(Color.WHITE);
				numArticulos = getNumA("pelicula", "prestados");
				listaArticulos = getListaA("pelicula", "prestados");
				mostrarA(numArticulos,5,listaArticulos);
			}
		});
		mntmRevistasP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				contenedor.setBackground(Color.WHITE);
				numArticulos = getNumA("revista", "prestados");
				listaArticulos = getListaA("revista", "prestados");
				mostrarA(numArticulos,6,listaArticulos);
			}
		});
		mntmLibrosP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				contenedor.setBackground(Color.WHITE);
				numArticulos = getNumA("libro", "prestados");
				listaArticulos = getListaA("libro", "prestados");
				mostrarA(numArticulos,7,listaArticulos);
			}
		});
		
		mntmPeliculas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				contenedor.setBackground(Color.WHITE);
				//numArticulos = getNumA("pelicula", "todos");
				listaArticulos = getListaA("pelicula", "todos");
				mostrarA(numArticulos,4,listaArticulos);
			}
		});
		mntmRevistas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				contenedor.setBackground(Color.WHITE);
				//numArticulos = getNumA("revista", "todos");
				listaArticulos = getListaA("revista", "todos");
				mostrarA(numArticulos,5,listaArticulos);
			}
		});
		mntmLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				contenedor.setBackground(Color.WHITE);
				//numArticulos = getNumA("libro", "todos");
				System.out.print("Esto sucede antes de su funcion.");
				listaArticulos = getListaA("libro", "todos");
				mostrarA(numArticulos,6,listaArticulos);
			}
		});
		
		/*Las siguientes dos funciones sucederan cuando se presione
		 * alguna de las opciones: registrar cliente o registrar articulo.
		 * Mandan a llamar funciones que llaman dos constructores
		 * diferentes.
		*/
		mntmCliente.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent arg0){
				registrarCliente();
			}
		});
		mntmArticulo.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent arg0){
				registrarArticulo();
			}
		});
	}
	
	/*En esta funcion se tenia planeado el proceso para mostrar la informacion de los libros
	 *En general es un while que recorrera todo el ArrayList de ArrayList de Objetos e irá
	 *insertando en un GridLayout la informacion recolectada.
	*/
	public void mostrarA(int cant, int col, ArrayList<ArrayList<Object>> lista){
		int i = 0;
		panelGrid.setLayout(new GridLayout(cant, col));
		System.out.print(cant);
		System.out.print(col);
		while(i<cant){
			
			i++;
		}
	}
	/* Funcion que recibe de entrada un nombre completo que buscara en el
	 * ArrayList de personas. Si lo encuentra en algun objeto devolvera el
	 * indice en donde fue encontrado, si no lo encuentra devolvera un -1. 
	 */
	public int getListaA(String nombre, String apellido1, String apellido2){
		String [][] lista = {};
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int contador = registro.personas.size();
		boolean funco = false;
		while(i1=contador){
			if (((Persona) personas.get(i1)).getNombre()==nombre && ((Persona) personas.get(i1)).getPrimerApellido()==apellido1 && ((Persona) personas.get(i1)).getSegundoApellido()==apellido2){
				return i1;
			}
			i1++;
		}
		return -1;
	}
	
	/* Estas son solamente una referencia para llamaral constructor
	 * de registrarClliente y registrarArticulo. Cada una es
	 * una clase aparte en otro paquene en el que se manda a llamar
	 * un nuevo JFrame con los espacios necesarios para ingresar y
	 * posteriormente regustrar un nuevo cliente o articulo.
	 */
	public void registrarCliente(){
		new Rclientes();
	}
	
	public void registrarArticulo(){
		new Rarticulos();
	}
	
	/* Funcion recibe dos delimitadores tipo 1(libro, revista, pelicula)
	 * y tipo2 (prestado, no prestado, todos), segun estos delimitadores
	 * la funcion buscara en el Arraylist de articulos todos los articulos
	 * que cumplan con las condiciones y devolvera el numero de cuantos
	 * lo cumplen.
	*/
	public int getNumA(String tipo1, String tipo2){
		int i1 = 0;
		int i3 = 0;
		boolean noPrestado = true;
		boolean prestado = false;
		if(tipo2=="prestados")
			noPrestado=false;
			prestado = true;
		if(tipo2=="no prestados")
			noPrestado=false;
		System.out.print(tipo2);
		int contador = registro.articulos.size();
		
		boolean funco = false;
		while(i1<=contador){
			if (tipo1 == "libro"){
				if(noPrestado==((Libro) articulos.get(i1)).isPrestado() && prestado==((Libro) articulos.get(i1)).isPrestado()){
					funco = true;}
				if(funco){i3++;}
			}else if(tipo1 == "pelicula"){
				if(noPrestado==((Libro) articulos.get(i1)).isPrestado() && prestado==((Libro) articulos.get(i1)).isPrestado()){
					funco = true;}
				if(funco){i3++;}
			}else if(tipo1 == "revista"){
				if(noPrestado==((Libro) articulos.get(i1)).isPrestado() && prestado==((Libro) articulos.get(i1)).isPrestado()){
					funco = true;}
				if(funco){i3++;}
			}
			i1++;
		}	
		return i3;
	}
	/* Funcion recibe dos delimitadores tipo 1(libro, revista, pelicula)
	 * y tipo2 (prestado, no prestado, todos), segun estos delimitadores
	 * la funcion buscara en el Arraylist de articulos todos los articulos
	 * que cumplan con las condiciones y devolvera en un ArrayList de ArrayList
	 * de Objetos todos los objetos que cumplem con las condiciones.
	*/
	public ArrayList<ArrayList<Object>> getListaA(String tipo1, String tipo2){
		ArrayList<Object> articulo = new ArrayList<Object>();
		ArrayList<ArrayList<Object>> lista = new ArrayList<ArrayList<Object>>();
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		boolean prestado=false;
		boolean noPrestado=true;
		if(tipo2=="prestados")
			prestado=true;
		if(tipo2=="no prestados")
			noPrestado=false;
		int contador = registro.articulos.size();
		boolean funco = false;
		System.out.print(registro.articulos.get(1).toString());
		System.out.print(((Libro)articulos.get(i1)).getTitulo());
		while(i1<=contador){
			if (tipo1 == "libro"){
				try{
					if((noPrestado==((Libro) articulos.get(i1)).isPrestado() && prestado==((Libro) articulos.get(i1)).isPrestado()) || tipo2==((Libro) articulos.get(i1)).getEstado() || tipo2=="todos"){
						articulo.add(((Libro) articulos.get(i1)).getTitulo());
						articulo.add(((Libro) articulos.get(i1)).getImagen());
						articulo.add(String.valueOf(((Libro) articulos.get(i1)).getCalificacion()));
						articulo.add(((Libro) articulos.get(i1)).getAutor());
						articulo.add(((Libro) articulos.get(i1)).getEdicion());
						articulo.add(((Libro) articulos.get(i1)).getEditorial());
						lista.add(articulo);
						articulo.clear();
						funco = true;
					}
				}finally{if(funco){i3++;}}
			}else if(tipo1 == "pelicula"){
				try{
					if((noPrestado==((Pelicula) articulos.get(i1)).isPrestado() && prestado==((Pelicula) articulos.get(i1)).isPrestado()) || tipo2==((Pelicula) articulos.get(i1)).getEstado() || tipo2=="todos"){
						articulo.add(((Pelicula) articulos.get(i1)).getTitulo());
						articulo.add(((Pelicula) articulos.get(i1)).getImagen());
						articulo.add(String.valueOf(((Pelicula) articulos.get(i1)).getCalificacion()));
						articulo.add(((Pelicula) articulos.get(i1)).getCompania());
						lista.add(articulo);
						articulo.clear();
						funco = true;
					}
				}finally{if(funco){i3++;}}
			}else if(tipo1 == "revista"){
				try{
					if((noPrestado==((Revista) articulos.get(i1)).isPrestado() && prestado==((Revista) articulos.get(i1)).isPrestado()) || tipo2==((Revista) articulos.get(i1)).getEstado() || tipo2=="todos"){
						articulo.add(((Revista) articulos.get(i1)).getTitulo());
						articulo.add(((Revista) articulos.get(i1)).getImagen());
						articulo.add(String.valueOf(((Revista) articulos.get(i1)).getCalificacion()));
						articulo.add(((Revista) articulos.get(i1)).getEdicion());
						articulo.add(((Revista) articulos.get(i1)).getEditorial());
						lista.add(articulo);
						articulo.clear();
						funco = true;
					}
				}finally{if(funco){i3++;}}
			}
			i1++;
		}	
		return lista;
	}
	/*Esta clase inicializa el programa en general. 
	 */
	public static void main(String[] args) {new Interfaz();}
}
