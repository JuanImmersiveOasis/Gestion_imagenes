package es.juan.galeriaImagenes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private File directorioPadre;
	private List<File> listaImagenes;
	private List<File> listaFavoritas;
	private int indiceActual = 0;
	private JLabel etiquetaImagen;
	private javax.swing.Timer timerPresentacion;
	
	
	
	
	
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
		JMenuItem itemAbrirExploradorArchivos = new JMenuItem("Abrir Explorador de Archivos");
		
		itemSalir.addActionListener(e -> System.exit(0));
		itemPresentacion.addActionListener(e -> IniciarPresentacionImagenes());
		itemFavoritos.addActionListener(e -> cargarFavoritos("./img"));
		itemAcercaDe.addActionListener(e -> mostrarAcercaDe());
		itemAbrirExploradorArchivos.addActionListener(e -> abrirExploradorArchivos());
		
		/*itemAcercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarAcercaDe(e);
			}
			
		});*/
		
	
		barraMenu.add(menuArchivo);
		barraMenu.add(menuImagenes);
		barraMenu.add(menuAyuda);
		
		
		menuArchivo.add(itemAbrirExploradorArchivos);
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
	
	private void iniciarVisorImagenes(ImageIcon imagenSeleccionada) {
		
	}
	
	private void abrirExploradorArchivos() {
        //Permite seleccionar archivos o carpetas mediante un cuadro de diálogo. 
        JFileChooser fileChooser = new JFileChooser();
       
        //Creamos un filtro para que el usuario sólo vea los archivos de imagen
        FileNameExtensionFilter filtro =
                new FileNameExtensionFilter("Archivos de Imagen", "jpg", "png", "gif", "bmp");  
        fileChooser.setFileFilter(filtro);
        
        //el usuario sólo puede seleccionar archivos del filtro seleccionado
        fileChooser.setAcceptAllFileFilterUsed(false); 

        // hacer que el explorador se abra en la carpeta Imágenes del usuario actual
        String rutaImagenes = System.getProperty("user.home") 
                + File.separator 
                + "Pictures";
        
        //Establece la carpeta inicial y crea un objeto File 
        //que representa esa carpeta
        fileChooser.setCurrentDirectory(new File(rutaImagenes));

        //abre un cuadro de diálogo y espera a que el usuario realice una acción
        //cancelar, cerrar, elegir archivo...
        // this se refiere a VentanaPrincipal, es para que el JFileChooser 
        //se abra centrado y asociado a esta ventana
        int seleccion = fileChooser.showOpenDialog(this);

        //si el usuario pulsó aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            File archivoSeleccionado = fileChooser.getSelectedFile();
            directorioPadre = archivoSeleccionado.getParentFile();
             
            // Cargar todas las imágenes de la carpeta
            File[] archivos = directorioPadre.listFiles((dir, name) ->
                    name.toLowerCase().endsWith(".jpg") ||
                    name.toLowerCase().endsWith(".png") ||
                    name.toLowerCase().endsWith(".gif") ||
                    name.toLowerCase().endsWith(".bmp"));

            if (archivos != null) {
                listaImagenes = java.util.Arrays.asList(archivos);
                indiceActual = listaImagenes.indexOf(archivoSeleccionado);
            }             

            ImageIcon imagenSeleccionada = new ImageIcon(archivoSeleccionado.getAbsolutePath());

            if (imagenSeleccionada.getIconWidth() == -1) {
                JOptionPane.showMessageDialog(this,
                        "Error al cargar la imagen.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                iniciarVisorImagenes(imagenSeleccionada);
            }
        } // fin pulsar Aceptar
    } // fin abrirExplor

}
