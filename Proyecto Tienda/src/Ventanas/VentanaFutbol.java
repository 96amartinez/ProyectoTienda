package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;
import Ventanas.VentanaPatrocinadores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class VentanaFutbol extends JFrame {

	private JPanel contentPane;
	private JPanel panelCentro;
	public static BD bd;
	private static Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFutbol frame = new VentanaFutbol();
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
	public VentanaFutbol() {
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
		
		String tipos[] = {"-","Botas", "Camisetas", "Pantalones", "Balones", "Sudaderas", "Guantes"};
		JComboBox cbTipo = new JComboBox(tipos);
		panelNorte.add(cbTipo);
		
		JLabel lblTalla = new JLabel("Talla");
		panelNorte.add(lblTalla);
				
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
		
		String marca[] = {"-","Adidas", "Nike", "New Balance", "Puma", "Air Jordan"};
		JComboBox cbMarca = new JComboBox(marca);
		panelNorte.add(cbMarca);
		
		JLabel lblEquipo = new JLabel("Equipo");
		panelNorte.add(lblMarca);
		
		String equipo[] = {"-","Athletic Club", "Liverpool", "Chelsea", "PSG", "Arsenal", "Inter de Milán", "Juventus", "Manchester City"
				,"Leicester City", "Bayern Munich", "Manchester United", "Borussia Dortmund"};
		JComboBox cbEquipo = new JComboBox(equipo);
		panelNorte.add(cbEquipo);
		
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
					if(cbTipo.getSelectedIndex()!=-1)
						tipo=(String)cbTipo.getSelectedItem();
					else {
						seleccionado = false;
						JOptionPane.showMessageDialog(null, "Tiene que seleccionar una opción");
					}
					String color = null;
					if(cbColor.getSelectedIndex()!=-1)
						color = (String) cbColor.getSelectedItem();
					else {
						seleccionado = false;
						JOptionPane.showMessageDialog(null, "Tiene que seleccionar una opción");
					}
					String marca = null;
					if(cbMarca.getSelectedIndex()!=-1)
						marca = (String) cbMarca.getSelectedItem();
					else {
						seleccionado = false;
						JOptionPane.showMessageDialog(null, "Tiene que seleccionar una opción");
					}
					String talla =null;
					if(cbTalla.getSelectedIndex()!=-1)
						talla = (String) cbTalla.getSelectedItem();
					else {
						seleccionado = false;
						JOptionPane.showMessageDialog(null, "Tiene que seleccionar una opción");
					}
					String equipo = null;
					if(cbEquipo.getSelectedIndex()!=-1)
						equipo = (String) cbEquipo.getSelectedItem();
					else {
						seleccionado = false;
						JOptionPane.showMessageDialog(null, "Tiene que seleccionar una opción");
					}
					panelCentro.removeAll();
					ArrayList<String> rutasFiltradas = VentanaLogin.bd.obtenerRutasConFiltroFutbol(tipo, color, marca, talla, equipo);
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
				} while(!seleccionado);
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
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerProductosCategoria("Fútbol");
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
