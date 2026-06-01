package es.juan.galeriaImagenes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal() {
		super("Gestor de Imagenes");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		setSize(1000,800);
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setJMenuBar(crearBarraMenu());
		
		setVisible(true);
		
	}
	
	private JMenuBar crearBarraMenu() {
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu menuArchivo = new JMenu("Archivo");
		JMenu menuImagenes = new JMenu("Imagenes");
		
		JMenu menuAyuda = new JMenu("Ayuda");
		
		JMenuItem itemAbrirExplorador = new JMenuItem("Abrir Explorador de Item");
		JMenuItem itemSalir = new JMenuItem("Salir");
		JMenuItem itemPresentacion = new JMenuItem("Iniciar Presentacion");
		JMenuItem itemFavoritos = new JMenuItem("Ver Favoritos");
		
		JMenuItem itemAcercaDe = new JMenuItem("Acerca de...");
		
		itemSalir.addActionListener(e -> System.exit(0));
		itemPresentacion.addActionListener(e -> IniciarPresentacionImagenes());
		itemFavoritos.addActionListener(e -> cargarFavoritos("./img"));
		itemAcercaDe.addActionListener(e -> mostrarAcercaDe());
		
		/*itemAcercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarAcercaDe(e);
			}
			
		});*/
		
	
		barraMenu.add(menuArchivo);
		barraMenu.add(menuImagenes);
		barraMenu.add(menuAyuda);
		
		
		menuArchivo.add(itemAbrirExplorador);
		menuArchivo.add(itemSalir);
		menuArchivo.add(itemPresentacion);
		menuArchivo.add(itemFavoritos);
		menuAyuda.add(itemAcercaDe);	
		return barraMenu;
		
		
	}
	
	private void IniciarPresentacionImagenes() {
		
	}
	
	private void cargarFavoritos(String string) {
		
	}
	
	private void mostrarAcercaDe() {
		JOptionPane.showMessageDialog(null,
				"Un visor y organizador de Imágenes simple y rapido\n"
				+ "version 1.0\n"
				+ "Creado por Juan\n",
				"Acerca de Gestor de Imagenes",
				JOptionPane.INFORMATION_MESSAGE);
		
	}
	


}
