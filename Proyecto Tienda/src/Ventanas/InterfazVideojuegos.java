package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class InterfazVideojuegos extends JFrame {

	private JPanel contentPane, panelPS4, panelPS3, panelXBOX, panelGratis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazVideojuegos frame = new InterfazVideojuegos();
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
	public InterfazVideojuegos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[]{0, 0, 0};
		gbl_panelCentro.rowHeights = new int[]{0, 0, 0};
		gbl_panelCentro.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCentro.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelCentro.setLayout(gbl_panelCentro);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panelCentro.add(scrollPane, gbc_scrollPane);
		
		panelPS4 = new JPanel();
		scrollPane.setViewportView(panelPS4);
		panelPS4.setBorder(new LineBorder(Color.RED, 2));
		panelPS4.setLayout(null);
		JLabel lblPs = new JLabel("PS4");
		lblPs.setBounds(86, 7, 22, 16);
		//lblPs.setHorizontalAlignment(SwingConstants.CENTER);
		lblPs.setVerticalAlignment(SwingConstants.TOP);
		//lblPs.setBounds(20,20,20, getDefaultCloseOperation());
		panelPS4.add(lblPs);
//		panelPS4.setLayout(new GridLayout(0,1));
//		cargarImagenesPS4();

		

		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 0;
		panelCentro.add(scrollPane_1, gbc_scrollPane_1);
		
		panelXBOX = new JPanel();
		scrollPane_1.setViewportView(panelXBOX);
		panelXBOX.setBorder(new LineBorder(Color.MAGENTA, 2));
		
		JLabel lblXbox = new JLabel("Xbox");
		panelXBOX.add(lblXbox);
		
//		panelXBOX.setLayout(new GridLayout(0, 2));
//		cargarImagenesXBOX();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 1;
		panelCentro.add(scrollPane_2, gbc_scrollPane_2);
		
		panelPS3 = new JPanel();
		scrollPane_2.setViewportView(panelPS3);
		panelPS3.setBorder(new LineBorder(Color.BLUE, 2));
		
		JLabel lblPs_1 = new JLabel("PS3");
		panelPS3.add(lblPs_1);
		
//		panelPS3.setLayout(new GridLayout(0, 2));
//		cargarImagenesPS3();
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 1;
		gbc_scrollPane_3.gridy = 1;
		panelCentro.add(scrollPane_3, gbc_scrollPane_3);
		
		panelGratis = new JPanel();
		scrollPane_3.setViewportView(panelGratis);
		panelGratis.setBorder(new LineBorder(Color.GREEN, 2));
		
		JLabel lblGratuitos = new JLabel("Gratuitos");
		panelGratis.add(lblGratuitos);
		
//		panelGratis.setLayout(new GridLayout(0, 2));
//		cargarImagenesGratis();

	}
	
	private void cargarImagenesPS4() {
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerVideojuegosCategoriaPlataformaYTipo("Videojuegos", "PS4", "Deportes");
		for(int i=0;i<aRutas.size();i++) {
			String ruta = aRutas.get(i);
			ImageIcon im = new ImageIcon(ruta);
			int width =250;
			int height = 250;
			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel lblFoto = new JLabel(im);
			panelPS4.add(lblFoto);
			lblFoto.setIcon(im);
		}
	}
	
	private void cargarImagenesPS3() {
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerVideojuegosCategoriaPlataformaYTipo("Videojuegos", "PS4", "Deportes");
		for(int i=0;i<aRutas.size();i++) {
			String ruta = aRutas.get(i);
			ImageIcon im = new ImageIcon(ruta);
			int width =250;
			int height = 250;
			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel lblFoto = new JLabel(im);
			panelPS3.add(lblFoto);
			lblFoto.setIcon(im);
		}
	}
	
//	private void cargarImagenesXBOX() {
//		ArrayList<String> aRutas = VentanaLogin.bd.obtenerVideojuegosCategoriaPlataformaYTipo("Videojuegos", "PS4", "Deportes");
//		for(int i=0;i<aRutas.size();i++) {
//			String ruta = aRutas.get(i);
//			ImageIcon im = new ImageIcon(ruta);
//			int width =250;
//			int height = 250;
//			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
//			JLabel lblFoto = new JLabel(im);
//			panelXBOX.add(lblFoto);
//			lblFoto.setIcon(im);
//		}
//	}
	
	private void cargarImagenesGratis() {
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerVideojuegosCategoriaPlataformaYTipo("Videojuegos", "PS4", "Deportes");
		for(int i=0;i<aRutas.size();i++) {
			String ruta = aRutas.get(i);
			ImageIcon im = new ImageIcon(ruta);
			int width =250;
			int height = 250;
			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel lblFoto = new JLabel(im);
			panelGratis.add(lblFoto);
			lblFoto.setIcon(im);
		}
	}
}
