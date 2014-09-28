package interfaz;
import cliente.*;
import almacenamientoDatos.*;
import enviarMail.*;
import objetos.*;
import registro.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Component;
//import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.io.File;
//import java.awt.SystemColor;
//import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame{ //implements ActionListener{
	JPanel contenedor = new JPanel();
	JPanel panelGrid = new JPanel();
	GridBagConstraints grid = new GridBagConstraints();
	JMenuBar menuBar = new JMenuBar();
	JMenu mnClientes = new JMenu("Clientes");
	JMenuItem mntmEstudiantes = new JMenuItem("Estudiantes");
	JMenuItem mntmColegas = new JMenuItem("Colegas");
	JMenuItem mntmFamiliares = new JMenuItem("Familiares");
	JMenu mnArticulos = new JMenu("Articulos");
	JMenuItem mntmLibros = new JMenuItem("Libros");
	JMenuItem mntmRevistas = new JMenuItem("Revistas");
	JMenuItem mntmPeliculas = new JMenuItem("Peliculas");
	JMenu mnPrestamos = new JMenu("Prestamos");
	JMenuItem mntmVerde = new JMenuItem("Verde");
	JMenuItem mntmAmarillo = new JMenuItem("Amarillo");
	JMenuItem mntmRojo = new JMenuItem("Rojo");
	JMenu mnRegistrar = new JMenu("Registrar");
	JMenuItem mntmCliente = new JMenuItem("Cliente");
	JMenuItem mntmArticulo = new JMenuItem("Articulo");
	JMenu mnEditar = new JMenu("Editar");
	JMenuItem mntmECliente = new JMenuItem("Cliente");
	JMenuItem mntmEArticulo = new JMenuItem("Articulo");
	ImageIcon logo = new ImageIcon("C://logo.jpg");
	JLabel logoi = new JLabel(logo);
	String [] nColumnasC = {"Nombre","Primer Apellido","Segundo Apellido", "Teléfono","Correo"};
	String [] nColumnasL = {"Titulo", "Autor/Edicion/Annio","Editorial","Calificacion","Imagen"};
	String [][] infoClientes = {};
	String [][] infoArticulos = {};
	static int diasP = 0;
	static int top = 10;
	static int veces = 3;
	static int meses = 6;
	ArrayList<Object> personas;
	ArrayList<Object> articulos;
	static Registro registro = new Registro();
	JTable tablaC = new JTable(infoClientes, nColumnasC);
	JTable tablaA = new JTable(infoArticulos, nColumnasL);
	
	public Interfaz() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Virtualteca");
		meterWidgets();
		getContentPane().add(contenedor);
		setVisible(true);
	}

	public void meterWidgets(){
		contenedor.setLayout(new BorderLayout());
		contenedor.add(menuBar, BorderLayout.NORTH);
		menuBar.add(mnClientes);
		menuBar.add(mnArticulos);
		menuBar.add(mnPrestamos);
		menuBar.add(mnRegistrar);
		menuBar.add(mnEditar);
		mnEditar.add(mntmEArticulo);
		mnEditar.add(mntmECliente);
		mnRegistrar.add(mntmCliente);
		mnRegistrar.add(mntmArticulo);
		mnPrestamos.add(mntmVerde);
		mnPrestamos.add(mntmAmarillo);
		mnPrestamos.add(mntmRojo);
		mnArticulos.add(mntmLibros);
		mnArticulos.add(mntmRevistas);
		mnArticulos.add(mntmPeliculas);
		mnClientes.add(mntmEstudiantes);
		mnClientes.add(mntmColegas);
		mnClientes.add(mntmFamiliares);
		contenedor.add(logoi, BorderLayout.CENTER);
		panelGrid.setLayout(new GridBagLayout());
		contenedor.add(logoi);
		
		mntmEstudiantes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				infoClientes = getListaC("estudiantes");
				tablaC = new JTable();
			}
		});
		mntmColegas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				infoClientes = getListaC("colegas");
				
			}
		});
		mntmFamiliares.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				infoClientes = getListaC("familiares");
				
			}
		});
		
		mntmPeliculas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				infoArticulos = getListaA("peliculas");
				
			}
		});
		mntmRevistas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				infoArticulos = getListaA("revistas");
				
			}
		});
		mntmLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				infoArticulos = getListaA("libros");
				
			}
		});
		
		mntmRojo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				infoClientes = getListaC("rojo");
				
			}
		});
		mntmVerde.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				infoClientes = getListaC("verde");
				
			}
		});
		mntmAmarillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contenedor.remove(logoi);
				infoClientes = getListaC("amarillo");
				
			}
		});
		
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
	
	public boolean registrarCliente(){
		boolean exito = false;
		JFrame regC = new JFrame();
		JPanel panelC = new JPanel();
		
		
		return exito;
	}
	
	public boolean registrarArticulo(){
		boolean exito = false;
		
		return exito;
	}
	
	public String[][] getListaC(String tipo){
		String [][] lista = {};
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int contador = registro.personas.size();
		boolean funco = false;
		while(i1<=contador){
			if (tipo == "colega"){
				try{
					lista[i3][i2] = ((Colega) personas.get(i1)).getNombre();
					i2++;
					lista[i3][i2] = ((Colega) personas.get(i1)).getPrimerApellido();
					i2++;
					lista[i3][i2] = ((Colega) personas.get(i1)).getSegundoApellido();
					i2++;
					lista[i3][i2] = ((Colega) personas.get(i1)).getTelefono();
					i2++;
					lista[i3][i2] = ((Colega) personas.get(i1)).getCorreo();
					i2 = 0;
					funco = true;
				}finally{if(funco){i3++;}}
			}else if(tipo == "estudiante"){
				try{
					lista[i3][i2] = ((Estudiante) personas.get(i1)).getNombre();
					i2++;
					lista[i3][i2] = ((Estudiante) personas.get(i1)).getPrimerApellido();
					i2++;
					lista[i3][i2] = ((Estudiante) personas.get(i1)).getSegundoApellido();
					i2++;
					lista[i3][i2] = ((Estudiante) personas.get(i1)).getTelefono();
					i2++;
					lista[i3][i2] = ((Estudiante) personas.get(i1)).getCorreo();
					i2 = 0;
					funco = true;
				}finally{if(funco){i3++;}}
			}else{
				try{
					lista[i3][i2] = ((Familiar) personas.get(i1)).getNombre();
					i2++;
					lista[i3][i2] = ((Familiar) personas.get(i1)).getPrimerApellido();
					i2++;
					lista[i3][i2] = ((Familiar) personas.get(i1)).getSegundoApellido();
					i2++;
					lista[i3][i2] = ((Familiar) personas.get(i1)).getTelefono();
					i2++;
					lista[i3][i2] = ((Familiar) personas.get(i1)).getCorreo();
					i2 = 0;
					funco = true;
				}finally{if(funco){i3++;}}
			}
			i1++;
			i2=0;
		}	
		return lista;
	}
	
	public String[][] getListaA(String tipo){
		String [][] lista = {};
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int contador = registro.articulos.size();
		boolean funco = false;
		while(i1<=contador){
			if (tipo == "libro"){
				try{
					lista[i3][i2] = ((Libro) articulos.get(i1)).getTitulo();
					i2++;
					lista[i3][i2] = ((Libro) articulos.get(i1)).getAutor();
					i2++;
					lista[i3][i2] = ((Libro) articulos.get(i1)).getEditorial();
					i2++;
					lista[i3][i2] = String.valueOf(((Libro) articulos.get(i1)).getCalificacion());
					i2++;
					lista[i3][i2] = ((Libro) articulos.get(i1)).getImagen();
					i2 = 0;
					funco = true;
				}finally{if(funco){i3++;}}
			}else if(tipo == "pelicula"){
				try{
					lista[i3][i2] = ((Pelicula) articulos.get(i1)).getTitulo();
					i2++;
					lista[i3][i2] = ((Pelicula) articulos.get(i1)).getAnnio();
					i2++;
					lista[i3][i2] = ((Pelicula) articulos.get(i1)).getCompania();
					i2++;
					lista[i3][i2] = String.valueOf(((Pelicula) articulos.get(i1)).getCalificacion());
					i2++;
					lista[i3][i2] = ((Pelicula) articulos.get(i1)).getImagen();
					i2 = 0;
					funco = true;
				}finally{if(funco){i3++;}}
			}else if(tipo == "revista"){
				try{
					lista[i3][i2] = ((Revista) articulos.get(i1)).getTitulo();
					i2++;
					lista[i3][i2] = ((Revista) articulos.get(i1)).getEdicion();
					i2++;
					lista[i3][i2] = ((Revista) articulos.get(i1)).getEditorial();
					i2++;
					lista[i3][i2] = String.valueOf(((Revista) articulos.get(i1)).getCalificacion());
					i2++;
					lista[i3][i2] = ((Revista) articulos.get(i1)).getImagen();
					i2 = 0;
					funco = true;
				}finally{if(funco){i3++;}}
			}else if(tipo == "prestados"){
				
			}else if(tipo == "no prestados"){
				
			}else if(tipo == "verde"){
				
			}else if(tipo == "amarillo"){
				
			}else if(tipo == "rojo"){
				
			}
			i1++;
			i2=0;
		}	
		return lista;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public static void main(String[] args) {new Interfaz();}
}
