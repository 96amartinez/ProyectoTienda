package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class VentanaPadel extends JFrame {

	private JPanel contentPane;
	private JPanel panelCentro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPadel frame = new VentanaPadel();
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
	public VentanaPadel() {
		JFrame v = this;
		setExtendedState(MAXIMIZED_BOTH);
		//v.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		JLabel lblTipo = new JLabel("Tipo");
		panelNorte.add(lblTipo);
		
		String tipos[] = {"-","Palas", "Camisetas", "Pantalones", "Pelotas", "Paleteros", "Protectores"};
		JComboBox cbTipo = new JComboBox(tipos);
		panelNorte.add(cbTipo);
		
		JLabel lblTalla = new JLabel("Peso");
		panelNorte.add(lblTalla);
		
		

		JSlider slider=new JSlider( 0, 10,  0);
		slider.setPaintTicks(true); //las rayitas que marcan los números
		slider.setMajorTickSpacing(1); // de cuanto en cuanto los números en el slider
		slider.setMinorTickSpacing(1); //las rayitas de cuanto en cuanto
		slider.setPaintLabels(true); //si se ve los números del slider
		panelNorte.add(slider);
		//Esto crea un JSlider que tiene un rango del minimo hasta el maximo que nosotros especifiquemos, e inicia en la posicion en la que le indicamo.
		
		String talla[] = {"-","XS", "S", "M", "L", "XL", "XXL", "34","35","36","37","38","39","40","41","42","43","44","45","46"};
		JComboBox cbTalla = new JComboBox(talla);
		panelNorte.add(cbTalla);
		
		JLabel lblColor = new JLabel("Color");
		panelNorte.add(lblColor);
		
		String color[] = {"-","Rojo", "Verde", "Azul", "Rosa", "Amarillo", "Marrón", "Morado","Naranja","Blanco","Gris","Negro"};
		JComboBox cbColor = new JComboBox(color);
		panelNorte.add(cbColor);
		
		JLabel lblMarca = new JLabel("Marca");
		panelNorte.add(lblMarca);
		
		String marca[] = {"-", "Adidas", "Wilson", "Head", "Varlion", "Artengo", "Bullpadel", "Dunlop"};
		JComboBox cbMarca = new JComboBox(marca);
		panelNorte.add(cbMarca);
		
		JButton btnFiltrar = new JButton("FILTRAR");
		panelNorte.add(btnFiltrar);
		btnFiltrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean seleccionado;
				do {
					seleccionado = true;
					String tipo = null;
					double peso = 0;
					if(cbTipo.getSelectedIndex() != -1)
						tipo = (String)cbTipo.getSelectedItem();
					else {
						seleccionado = false;
						JOptionPane.showMessageDialog(null, "Tienes que seleccionar todas las opciones");
					}peso = slider.getValue() * 100; //Ponía 1000
					String color = null;
					if(cbColor.getSelectedIndex() != -1)
						color = (String) cbColor.getSelectedItem();
					else {
						seleccionado = false;
						JOptionPane.showMessageDialog(null, "Tienes que seleccionar todas las opciones");
					}
					String marca = null;
					if(cbMarca.getSelectedIndex() != -1)
						marca = (String) cbMarca.getSelectedItem();
					else {
						seleccionado = false;
						JOptionPane.showMessageDialog(null, "Tienes que seleccionar todas las opciones");
					}
					panelCentro.removeAll();
					ArrayList<String> rutasFiltradas = VentanaLogin.bd.obtenerRutasConFiltroPadel(tipo,peso,color,marca);
					for(int i=0;i<rutasFiltradas.size();i++) {
						String ruta = rutasFiltradas.get(i);
						ImageIcon im = new ImageIcon(ruta);
						int width =500;
						int height = 500;
						im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
						JLabel lblFoto = new JLabel(im);
						panelCentro.add(lblFoto);
						lblFoto.setIcon(im);
					}
					panelCentro.updateUI();
				}while(!seleccionado);
				
			}
		});
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.dispose();
				VentanaMenu vm = new VentanaMenu(v);
				vm.setVisible(true);
			}
			
		});
		panelSur.add(btnVolver);
		
		panelCentro = new JPanel();
		JScrollPane sc = new JScrollPane(panelCentro);
		sc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	//	sc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		contentPane.add(sc, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0,5,0,0));
		cargarImagenes();
		
		
	}

	private void cargarImagenes() {
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerProductosCategoria("Pádel");
		for(int i=0;i<aRutas.size();i++) {
			String ruta = aRutas.get(i);
			ImageIcon im = new ImageIcon(ruta);
			int width =500;
			int height = 500;
			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel lblFoto = new JLabel(im);
			panelCentro.add(lblFoto);
			lblFoto.setIcon(im);
		}
	}
}
