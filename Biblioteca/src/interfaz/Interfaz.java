package interfaz;
import cliente.*;
import almacenamientoDatos.*;
import enviarMail.*;
import objetos.*;
import registro.*;

import javax.swing.*;

import java.awt.Component;
//import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.SystemColor;
//import java.awt.Color;
import java.util.ArrayList;

public class Interfaz extends JFrame{ //implements ActionListener{
	JPanel contenedor = new JPanel();
	JPanel panelGrid = new JPanel();
	JScrollPane panelScroll = new JScrollPane();
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
	String [] nColumnasC = {"Cliente", "Nombre","Primer Apellido","Segundo Apellido", "Teléfono","Correo"};
	Object [][] infoTablaC = {};
	Object [][] infoTablaA = {};
	JTable tablaC = new JTable();
	JTable tablaA = new JTable(infoTablaC, nColumnasC);
	static int diasP = 0;
	static int top = 10;
	static int veces = 3;
	static int meses = 6;
	Registro registro = new Registro();
	ArrayList<Object> personas = registro.getPersonas();
	ArrayList<Object> articulos = registro.getArticulos();
	
	public Interfaz() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Biblioteca");
		
		meterWidgets();
		
		add(contenedor);
		
		setVisible(true);
	}

	public void meterWidgets(){
		//contenedor.setLayout(new FlowLayout());
		panelGrid.setLayout(new GridBagLayout());
		contenedor.add(menuBar, BorderLayout.PAGE_START);
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
		
		contenedor.add(panelScroll);
		contenedor.add(tablaC, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new Interfaz();}

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
}
