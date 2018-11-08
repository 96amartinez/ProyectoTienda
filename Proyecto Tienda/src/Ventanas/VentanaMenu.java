package Ventanas;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;


public class VentanaMenu extends JFrame {

	private JPanel contentPane;
	JMenuBar barra; //Barra menu
	JMenu menuElegirOpcion, menuDeportes, menuVideojuegos, menuNuestrasTiendas, menuInformacion, menuOpciones, menuAyuda, menuPatrocinadores, menuMostrarProductos;
	JMenuItem itemFutbol, itemPadel, itemBaloncesto, itemCiclismo, itemBilbao, itemMadrid, itemBarcelona, itemPozaDeLaSal, 
	itemSobreMi, itemJuegosDeMesa, itemJuegosDeportivos, itemJuegosAccion, itemJuegosMusicales;
	JFrame v = this;
	JLabel JLabel1;
	private JLabel lblNewLabel;
	public static String path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public VentanaMenu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); //Para centrar la ventana
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//NOSE XQ NO SE REDIMENSIONA
		String [] g = {"adidas.gif", "apple.gif", "cocacola.gif", "fanta.gif", "futbol.gif", "gucci.gif", "ikea.gif", "lg.gif", "masterCard.gif"
				, "mc.gif", "nike.gif", "nike1.gif", "pepsi.gif", "spotify.gif", "vans.gif", "youtube.gif"};
		Random r;
		r= new Random();
		int i = r.nextInt(16);
		JLabel lblFoto1 = new JLabel("New Label");
		lblFoto1.setBounds(33,352,126,120);
		contentPane.add(lblFoto1);
		ImageIcon myImage = new ImageIcon("gif/adidas.gif") /*+g[i])*/;
		Image img = myImage.getImage();
		Image newImg = img.getScaledInstance(lblFoto1.getWidth(), lblFoto1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		lblFoto1.setIcon(image);
		
		String [] g2 = {"adidas.gif", "apple.gif", "cocacola.gif", "fanta.gif", "futbol.gif", "gucci.gif", "ikea.gif", "lg.gif", "masterCard.gif"
				, "mc.gif", "nike.gif", "nike1.gif", "pepsi.gif", "spotify.gif", "vans.gif", "youtube.gif"};
		Random r1;
		r1= new Random();
		int i1 = r1.nextInt(16);
		JLabel lblFoto2 = new JLabel("New Label");
		lblFoto2.setBounds(574,25,126,120);
		contentPane.add(lblFoto2);
		ImageIcon myImage1 = new ImageIcon("gif/adidas.gif") /*+g2[i1])*/;
		Image img1 = myImage1.getImage();
		Image newImg1 = img1.getScaledInstance(lblFoto2.getWidth(), lblFoto2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image1 = new ImageIcon(newImg1);
		lblFoto2.setIcon(image1);
		
		

		
		crearMenu();
		
		//La intención es que busque un gif aleatorio
		
		/**
		 * Hilo para mover el gif de izquierda a derecha
		 */
		new Thread() {
			public void run() {
				Random r = new Random();
				//int x = r.nextInt(1000);
				//int y = r.nextInt(1000);
				int x = 0;
				int y = lblFoto1.getLocation().y;
				while(true) {
					x++;
					if(x > getWidth()) {
						x=0;
					}
					lblFoto1.setLocation(x,y);
					try {
						sleep(10);
					} catch(Exception e) {
						
					}
				}
			}
		}.start();
		
		/**
		 * Hilo para mover el gif de arriba a abajo
		 */
		new Thread() {
			public void run() {
				int x = lblFoto2.getLocation().x;
				int y = 0;
				while(true) {
					y++;
					if(y > getHeight()) {
						y=0;
					}
					lblFoto2.setLocation(x,y);
					try {
						sleep(10);
					} catch(Exception e) {
						
					}
				}
			}
		}.start();

	}


	private void crearMenu() {
		// TODO Auto-generated method stub
		barra = new JMenuBar();
		menuElegirOpcion= new JMenu("Elegir Opción");
		menuDeportes = new JMenu("Deportes");
		menuVideojuegos = new JMenu("Videojuegos");
		menuNuestrasTiendas = new JMenu("Nuestras Tiendas");
		menuInformacion = new JMenu("Información");
		menuOpciones = new JMenu("Opciones");
		menuPatrocinadores = new JMenu("Patrocinadores");
		menuMostrarProductos = new JMenu("Mostrar productos");
		menuAyuda = new JMenu("Ayuda");
		
		itemJuegosDeMesa = new JMenuItem("Videojuegos de Mesa");
		itemJuegosDeportivos = new JMenuItem("Videojuegos de deportes");
		itemJuegosMusicales = new JMenuItem("Videojuegos musicales");
		itemJuegosAccion = new JMenuItem("Videojuegos de acción");
		itemFutbol = new JMenuItem("Fútbol");
		itemPadel = new JMenuItem("Padel");
		itemBaloncesto = new JMenuItem("Baloncesto");
		itemCiclismo = new JMenuItem("Ciclismo");
		itemBilbao = new JMenuItem("Bilbao");
		itemBilbao.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaBilbao vl = new VentanaBilbao();
				vl.setVisible(true);
			}
			
		});
		itemMadrid = new JMenuItem("Madrid");
		itemBarcelona = new JMenuItem("Barcelona");
		itemPozaDeLaSal = new JMenuItem("Poza de la Sal");
		itemPozaDeLaSal.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaPoza vp = new VentanaPoza();
				vp.setVisible(true);
			}
			
		});
		itemSobreMi = new JMenuItem("Sobre Mi");
		itemSobreMi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaSobreMi vs = new VentanaSobreMi();
				vs.setVisible(true);
			}
			
		});
		
		
		
		menuElegirOpcion.add(menuDeportes);
		menuElegirOpcion.addSeparator();
		//itemDeportes.add(itemFutbol);
		menuDeportes.add(itemFutbol);
		menuDeportes.addSeparator();
		menuDeportes.add(itemPadel);
		menuDeportes.addSeparator();
		menuDeportes.add(itemBaloncesto);
		menuDeportes.addSeparator();
		menuDeportes.add(itemCiclismo);
		menuElegirOpcion.add(menuVideojuegos);
		menuVideojuegos.add(itemJuegosAccion);
		menuVideojuegos.addSeparator();
		menuVideojuegos.add(itemJuegosDeMesa);
		menuVideojuegos.addSeparator();
		menuVideojuegos.add(itemJuegosMusicales);
		menuVideojuegos.addSeparator();
		menuVideojuegos.add(itemJuegosDeportivos);
		
		
		menuNuestrasTiendas.add(itemBilbao);
		menuNuestrasTiendas.addSeparator();
		menuNuestrasTiendas.add(itemMadrid);
		menuNuestrasTiendas.addSeparator();
		menuNuestrasTiendas.add(itemBarcelona);
		menuNuestrasTiendas.addSeparator();
		menuNuestrasTiendas.add(itemPozaDeLaSal);
		
		menuInformacion.add(itemSobreMi);
		
		barra.add(menuElegirOpcion);
		barra.add(menuNuestrasTiendas);
		barra.add(menuMostrarProductos);
		barra.add(menuInformacion);
		barra.add(menuPatrocinadores);
		barra.add(menuAyuda);
		setJMenuBar(barra);

		

	}
}
