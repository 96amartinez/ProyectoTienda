package Ventanas;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.Messaging.SyncScopeHelper;

import BaseDeDatos.BD;

import javax.swing.JButton;


public class VentanaMenu extends JFrame {

	private JPanel contentPane;
	JMenuBar barra; //Barra menu
	JMenu menuElegirOpcion, menuDeportes, menuVideojuegos, menuNuestrasTiendas, menuInformacion, menuOpciones, menuAyuda/*, menuPatrocinadores*/, menuMostrarProductos;
	JMenuItem menuPatrocinadores, itemFutbol, itemPadel, itemBaloncesto, itemCiclismo, itemBilbao, itemMadrid, itemBarcelona, itemPozaDeLaSal, 
	itemSobreMi, itemJuegosDeMesa, itemJuegosDeportivos, itemJuegosAccion, itemJuegosMusicales, itemTodos,itemProductos;
	JFrame v = this;
	JLabel JLabel1;
	private JLabel lblNewLabel;
	public static String path;
	private JFrame ventanaAnterior;
	JLabel lblFotos;
	



	/**
	 * Create the frame.
	 */
	public VentanaMenu(JFrame va) {
		//JFrame v = this;
		ventanaAnterior=va;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); //Para centrar la ventana
		setContentPane(contentPane);
		contentPane.setLayout(null);



		String [] g = BD.obtenerFotos("gif");
		Random r;
		r= new Random();
		int i3 = r.nextInt(19);
		JLabel lblFoto1 = new JLabel("");
		lblFoto1.setBounds(33,352,126,120);
		contentPane.add(lblFoto1);
		ImageIcon image = new ImageIcon(g[i3]);
		int width = 100;
		int height = 100;
		image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		lblFoto1.setIcon(image);


		String [] g2 = BD.obtenerFotos("gif");
		Random r1;
		r1= new Random(System.currentTimeMillis());
		int i1 = r1.nextInt(19);
		JLabel lblFoto2 = new JLabel("");
		lblFoto2.setBounds(542,26,126,120);
		contentPane.add(lblFoto2);
		ImageIcon image1 = new ImageIcon(g2[i1]);
		int width1=100;
		int height1=100;
		image1.setImage(image1.getImage().getScaledInstance(width1, height1, Image.SCALE_DEFAULT));
		lblFoto2.setIcon(image1);


		String ofertas[] = BD.obtenerFotos("ofertas");
		//		for(int i=0;i<ofertas.length;i++)
		//			System.out.println(ofertas[i]);
		Random r2 = new Random(System.currentTimeMillis());
		int i2 = r2.nextInt(5);
		JLabel lblOfertas = new JLabel("");
		lblOfertas.setBounds(33, 261, 635, 202);
		contentPane.add(lblOfertas);
		ImageIcon ioferta = new ImageIcon(ofertas[i2]);
		int x2= 635;
		int y2= 202;
		ioferta.setImage(ioferta.getImage().getScaledInstance(x2, y2, Image.SCALE_SMOOTH));
		lblOfertas.setIcon(ioferta);



		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(338, 471, 117, 29);
		contentPane.add(btnVolver);

		
		JButton btnFotoIzq = new JButton("");
		ImageIcon im1 = new ImageIcon("Imagenes/fotoIzq.jpg");
		int w1 =48;
		int y1=48;
		im1.setImage(im1.getImage().getScaledInstance(w1, y1, Image.SCALE_SMOOTH));
		btnFotoIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnFotoIzq.setBounds(6, 98, 48, 48);
		contentPane.add(btnFotoIzq);
		btnFotoIzq.setIcon(im1);
		
		JButton btnFotoDch = new JButton("");
		ImageIcon im = new ImageIcon("Imagenes/fotoDcha.jpg");
		int w = 48;
		int y = 48;
		im.setImage(im.getImage().getScaledInstance(w, y, Image.SCALE_SMOOTH));
		btnFotoDch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
			}

		});
		btnFotoDch.setBounds(650, 98, 48, 48);
		contentPane.add(btnFotoDch);
		btnFotoDch.setIcon(im);

		String menu [] = BD.obtenerFotos("menu");
		Random r3 = new Random(System.currentTimeMillis());
		int i4=r3.nextInt(5);
		lblFotos = new JLabel("");
		lblFotos.setBounds(33, 25, 635, 202);
		contentPane.add(lblFotos);
		ImageIcon imenu = new ImageIcon(menu[i4]);
		int x3 = 635;
		int y3 = 202;
		imenu.setImage(imenu.getImage().getScaledInstance(x3, y3, Image.SCALE_SMOOTH));
		lblFotos.setIcon(imenu);
		
		
		



		crearMenu();



		/**
		 * Hilo para mover el gif de izquierda a derecha
		 */
		new Thread() {
			public void run() {
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
		menuPatrocinadores = new JMenuItem("Patrocinadores");
		menuMostrarProductos = new JMenu("Mostrar productos");
		menuAyuda = new JMenu("Ayuda");

		itemJuegosDeMesa = new JMenuItem("Videojuegos de Mesa");
		itemJuegosDeportivos = new JMenuItem("Videojuegos de deportes");
		itemJuegosDeportivos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				InterfazVideojuegos iv = new InterfazVideojuegos();
				iv.setVisible(true);
				
			}
		});
		itemJuegosMusicales = new JMenuItem("Videojuegos musicales");
		itemJuegosAccion = new JMenuItem("Videojuegos de acción");
		itemFutbol = new JMenuItem("Fútbol");
		itemPadel = new JMenuItem("Pádel");
		itemPadel.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaPadel vp = new VentanaPadel();
				vp.setVisible(true);
			}
			
		});
		itemBaloncesto = new JMenuItem("Baloncesto");
		itemCiclismo = new JMenuItem("Ciclismo");
		itemCiclismo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanasGBL vc = new VentanasGBL();
				vc.setVisible(true);
				
			}
		});

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

		itemTodos = new JMenuItem("Todos");
		itemTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaPatrocinadores vp = new VentanaPatrocinadores(v);
				vp.setVisible(true);
			}

		});

		itemProductos = new JMenuItem("Productos");
		itemProductos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				Tabla vt = new Tabla();
				vt.setVisible(true);
			}
		});


		menuElegirOpcion.add(menuDeportes);
		menuElegirOpcion.addSeparator();
		//itemDeportes.add(itemFutbol);
		menuDeportes.add(itemFutbol);
		itemFutbol.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaFutbol vf = new VentanaFutbol();
				vf.setVisible(true);
			}
		});
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
		itemMadrid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaMadrid vm = new VentanaMadrid();
				vm.setVisible(true);
			}

		});
		menuNuestrasTiendas.addSeparator();
		menuNuestrasTiendas.add(itemBarcelona);
		itemBarcelona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaBarcelona vb = new VentanaBarcelona();
				vb.setVisible(true);
			}

		});
		menuNuestrasTiendas.addSeparator();
		menuNuestrasTiendas.add(itemPozaDeLaSal);

		menuInformacion.add(itemSobreMi);
		
		menuMostrarProductos.add(itemProductos);

		//menuPatrocinadores.add(itemTodos);
		menuPatrocinadores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaPatrocinadores vp = new VentanaPatrocinadores(v);
				vp.setVisible(true);
			}
		});

		barra.add(menuElegirOpcion);
		barra.add(menuNuestrasTiendas);
		barra.add(menuMostrarProductos);
		barra.add(menuInformacion);
		barra.add(menuPatrocinadores);
		barra.add(menuAyuda);
		setJMenuBar(barra);



	}


}
