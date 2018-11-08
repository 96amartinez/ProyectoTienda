package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import BaseDeDatos.BD;
import java.awt.Font;
import java.awt.Image;

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrecio;
	private JTextField txtRuta;
	private JFrame ventanaAnterior;
	private JTextField txtDesc;
	private JTextField txtStock;
	JFrame v = this;



	/**
	 * Create the frame.
	 */
	public VentanaAdmin(JFrame va) {
		ventanaAnterior = va;
		setExtendedState(MAXIMIZED_BOTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		Image imbtn = new ImageIcon("Imagenes/Añadir.jpg").getImage();
		ImageIcon imbtn2 = new ImageIcon(imbtn.getScaledInstance(166, 178, Image.SCALE_SMOOTH));
		JButton btnAniadirArticulo = new JButton();
		btnAniadirArticulo.setBounds(10,12,166,178);
		btnAniadirArticulo.setIcon(imbtn2);
		panelCentro.add(btnAniadirArticulo);

		JLabel lblAniadir = new JLabel("Añadir Artículo");
		lblAniadir.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblAniadir.setBounds(10, 186, 145, 16);
		panelCentro.add(lblAniadir);


		Image imb = new ImageIcon("Imagenes/modificar.png").getImage();
		ImageIcon imb2 = new ImageIcon(imb.getScaledInstance(166, 178, Image.SCALE_SMOOTH));
		JButton btnModificar = new JButton("MODIFICAR ARTÍCULO");
		btnModificar.setBounds(10, 222, 166, 178);
		btnModificar.setIcon(imb2);
		panelCentro.add(btnModificar);

		JLabel lblModificar = new JLabel("Modificar Artículo");
		lblModificar.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblModificar.setBounds(10, 395, 145, 16);
		panelCentro.add(lblModificar);

		Image im = new ImageIcon("Imagenes/eliminar.jpg").getImage();
		ImageIcon im2 = new ImageIcon(im.getScaledInstance(176, 178, Image.SCALE_SMOOTH));
		JButton btnBorrarArtculo = new JButton("BORRAR ARTÍCULO");
		btnBorrarArtculo.setBounds(10, 422, 166, 178);
		btnBorrarArtculo.setIcon(im2);
		panelCentro.add(btnBorrarArtculo);

		JLabel lblEliminar = new JLabel("Eliminar Artículo");
		lblEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblEliminar.setBounds(10, 600, 145, 16);
		panelCentro.add(lblEliminar);



		JLabel lblGenero = new JLabel("CÓDIGO");
		lblGenero.setBounds(230, 10, 63, 14);
		panelCentro.add(lblGenero);

		JTextField txtCodigo = new JTextField ();
		txtCodigo.setBounds(320, 10, 145, 20);
		panelCentro.add(txtCodigo);



		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setBounds(570, 10, 63, 14);
		panelCentro.add(lblTipo);

		String[] tipo = {"Camisetas", "Pantalones", "Balones", "Botas", "Sudaderas", "Guantes", "Playeras", "Cascos", "Botellines", "Maillots",
				"Bicicletas", "Protectores", "Paleteros", "Palas", "Pelotas"};
		JComboBox cbTipo = new JComboBox(tipo);
		cbTipo.setBounds(660, 10, 145, 20);
		panelCentro.add(cbTipo);



		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(230, 80, 63, 14);
		panelCentro.add(lblNombre);

		JTextField txtNombre = new JTextField ();
		txtNombre.setBounds(320, 80, 145, 20);
		panelCentro.add(txtNombre);



		JLabel lblMarca = new JLabel("MARCA");
		lblMarca.setBounds(570, 80, 63, 14);
		panelCentro.add(lblMarca);

		String[] marca = {"Adidas", "Nike", "Air Jordan", "Spiuk", "Specialized", "Cannondale", "Canyon", "Roger", "New Balances", "Puma",
				"Head", "Artengo", "Bulpadel", "Vairlon", "Orbea"};
		JComboBox cbMarca = new JComboBox(marca);
		cbMarca.setBounds(660, 80, 145, 20);
		panelCentro.add(cbMarca);



		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(230, 150, 46, 14);
		panelCentro.add(lblPrecio);

		JTextField txtPrecio = new JTextField ();
		txtPrecio.setBounds(320, 150, 145, 20);
		panelCentro.add(txtPrecio);



		JLabel lblEquipo = new JLabel("EQUIPO");
		lblEquipo.setBounds(570, 150, 63, 14);
		panelCentro.add(lblEquipo);

		String[] equipo = {"Athletic Club", "PSG", "Liverpool", "Chelsea", "Arsenal", "Poza Bike Xtrem", "Euskaltel Euskadi", "Euskadi Murias", "Juventus",
				"Inter de Milán", "Astana", "Movistar", "Tinkoff Saxo", "Burgos BH", "Boston Celtics"};
		JComboBox cbEquipo = new JComboBox(equipo);
		cbEquipo.setBounds(660, 150, 145, 20);
		panelCentro.add(cbEquipo);



		JLabel lblStock = new JLabel("STOCK");
		lblStock.setBounds(230, 220, 46, 14);
		panelCentro.add(lblStock);

		txtStock = new JTextField();
		txtStock.setBounds(320, 220, 145, 20);
		panelCentro.add(txtStock);
		txtStock.setColumns(10);



		JLabel lblPeso = new JLabel("PESO");
		lblPeso.setBounds(570, 220, 63, 14);
		panelCentro.add(lblPeso);

		JTextField txtPeso = new JTextField();
		txtPeso.setBounds(660, 220, 145, 20);
		panelCentro.add(txtPeso);
		
		

		Image imvolver = new ImageIcon("Imagenes/volver.jpg").getImage();
		ImageIcon imvolver2 = new ImageIcon(imvolver.getScaledInstance(175, 175, Image.SCALE_SMOOTH));
		JButton btnVolver = new JButton();
		btnVolver.setBounds(875, 20, 175, 175);
		btnVolver.setIcon(imvolver2);
		panelCentro.add(btnVolver);
		
		
		
		Image imus = new ImageIcon("Imagenes/elimus.png").getImage();
		ImageIcon imus2 = new ImageIcon(imus.getScaledInstance(175, 175, Image.SCALE_SMOOTH));
		JButton btnBorrarUsuario = new JButton();
		btnBorrarUsuario.setBounds(1090, 20, 175, 175);
		btnBorrarUsuario.setIcon(imus2);
		btnBorrarUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaJList vjl = new VentanaJList();
				vjl.setVisible(true);
				
			}
		});
		panelCentro.add(btnBorrarUsuario);
		
		JLabel lblUsuario = new JLabel("Eliminar Usuario");
		lblUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblUsuario.setBounds(1090, 195, 145, 16);
		panelCentro.add(lblUsuario);

		
		
		JLabel lblDescripcin = new JLabel("DESCRIPCIÓN");
		lblDescripcin.setBounds(230, 290, 90, 16);
		panelCentro.add(lblDescripcin);

		txtDesc = new JTextField();
		txtDesc.setBounds(320, 290, 145, 20);
		panelCentro.add(txtDesc);
		txtDesc.setColumns(10);


		//Cambiar a label
		JButton lblimSelec = new JButton();
		lblimSelec.setBounds(570,290, 650, 375);
		panelCentro.add(lblimSelec);
		
		
		
		JButton btnRuta = new JButton("Ruta");
		btnRuta.setBounds(230, 360, 230, 20);
		//panelCentro.add(btnRuta);
		btnRuta.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser selector=new JFileChooser();
				File d = new File("/Users/aitorclase/Desktop/prog3-2018/Tienda/Productos");
				selector.setCurrentDirectory(d);
				FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
				selector.setFileFilter(filtroImagen);
				int r=selector.showOpenDialog(null);
				if(r==JFileChooser.APPROVE_OPTION){
					File f=selector.getSelectedFile();
					
					//  lnom.setText(f.getName());
					// lpeso.setText(""+f.length());
					// ImageIcon img = null;
					//try {
						//img = new ImageIcon(selector.getSelectedFile().toURL());
						int x= 650;
						int y=375;
						Image im = null;
						try {
							im = new ImageIcon(selector.getSelectedFile().toURL()).getImage();
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ImageIcon im1 = new ImageIcon(im.getScaledInstance(x, y, Image.SCALE_SMOOTH));
					//} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
					//	e1.printStackTrace();
					//}
					   lblimSelec.setIcon(im1);
				}
			}

		});
		panelCentro.add(btnRuta);


				
				
//		txtRuta = new JTextField();
//		txtRuta.setText("Productos/");
//		txtRuta.setBounds(320, 360, 145, 20);
//		panelCentro.add(txtRuta);
//		txtRuta.setColumns(10);



		JLabel lblCategoria = new JLabel("CATEGORIA");
		lblCategoria.setBounds(230, 430, 100, 20);
		panelCentro.add(lblCategoria);

		String[] cat = {"Futbol", "Padel", "Baloncesto", "Ciclismo", "Videojuegos"};
		JComboBox cbCategoria = new JComboBox(cat);
		cbCategoria.setBounds(320, 430, 145, 20);
		panelCentro.add(cbCategoria);



		JLabel lblOferta = new JLabel("OFERTA");
		lblOferta.setBounds(230, 500, 63, 20);
		panelCentro.add(lblOferta);

		String [] of = {"SI", "NO"};
		JComboBox cbOferta = new JComboBox(of);
		cbOferta.setBounds(320, 500, 145, 20);
		panelCentro.add(cbOferta);



		JLabel lblTalla = new JLabel("TALLA");
		lblTalla.setBounds(230, 570, 63, 20);
		panelCentro.add(lblTalla);

		JTextField txtTalla = new JTextField();
		txtTalla.setBounds(320, 570, 145, 20);
		panelCentro.add(txtTalla);



		JLabel lblColor = new JLabel("COLOR");
		lblColor.setBounds(230, 640, 63, 20);
		panelCentro.add(lblColor);

		String color[] = {"Rojo", "Verde", "Azul", "Rosa", "Amarillo", "Marrón", "Morado","Naranja","Blanco","Gris","Negro"};
		JComboBox cbColor = new JComboBox(color);
		cbColor.setBounds(320, 640, 145, 20);
		panelCentro.add(cbColor);




	}
}
