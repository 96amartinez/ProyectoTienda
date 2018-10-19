package Ventanas;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

//Las ventanas de los sitios van a tener el mismo formato, como juntarlas
public class VentanaPoza extends JFrame {

	private JPanel contentPane;
	JFrame v = this;
	

	/**
	 * Create the frame.
	 */
	public VentanaPoza() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); //Para centrar la ventana
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
				
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblBilbao = new JLabel("Poza de la Sal");
		lblBilbao.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		panelNorte.add(lblBilbao);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		panelSur.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.dispose();
				VentanaMenu vm = new VentanaMenu();
				vm.setVisible(true);
				
			}
		});
		
		
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		/*
		 * FOTO ALEATORIA EN UN JLABEL
		 * String[] imgs = {"FondoMenu.jpg","yo.png","IconoNick.png", "IconoTienda.jpg"};
		Random r ;
		r = new Random();
		int index = r.nextInt(4);
		Image im = new ImageIcon("Imagenes/" + imgs[index]).getImage();
		ImageIcon icon = new ImageIcon(im);
		
		
	//	Image img1 = new ImageIcon("Imagenes/locPoza.png").getImage();
	//	ImageIcon img12 = new ImageIcon(img1.getScaledInstance(532, 302, Image.SCALE_SMOOTH));
		JLabel lblFoto1 = new JLabel("");
		lblFoto1.setBounds(552, 6, 532, 302);
	//	lblFoto1.setIcon(img12);
		lblFoto1.setIcon(icon);
		panelCentro.add(lblFoto1);
		
		*/
		
		
		Image img1 = new ImageIcon("Imagenes/locPoza.png").getImage();
		ImageIcon img12 = new ImageIcon(img1.getScaledInstance(532, 302, Image.SCALE_SMOOTH));
		JLabel lblFoto1 = new JLabel("");
		lblFoto1.setBounds(552, 6, 532, 302);
		lblFoto1.setIcon(img12);
		panelCentro.add(lblFoto1);
		
		Image img2 = new ImageIcon("Imagenes/FotoPoza.png").getImage();
		ImageIcon img22 = new ImageIcon(img2.getScaledInstance(532, 302, Image.SCALE_SMOOTH));
		JLabel lblFoto2 = new JLabel("");
		lblFoto2.setBounds(6, 6, 532, 302);
		lblFoto2.setIcon(img22);
		panelCentro.add(lblFoto2);
		
		String text = "Poza de la Sal es una villa situada a 43 km al norte de Burgos capital con unos 338 habitantes más o menos, ya que cada año va disminuyendo. Junto a los municipios de \n" + 
				"Oña y Frías conforma la mancomunidad de Raices de Castilla. La localidad se encuentra enriscada en la ladera de una sierra, fortificada y protegida por el castillo de los \n" + 
				"Rojas y con vistas sobre las llanuras de la comarca de La Bureba. La plaza vieja tiene un espolón el cuál es denominado el balcón de la bureba ya que desde hay se puede \n" + 
				"ver toda la bureba. Este precioso pueblo fue declarado de conjunto Histórico-Artístico en 1982.\n" + 
				"Decidimos abrir una tienda aquí ya que siempre que tengo un hueco me gusta escaparme al pueblo de mis abuelos en el que tan buenos momentos he pasado y porque \n" + 
				"paso practicamente todas las vacaciones en él. De esta manera cada vez que me fuera al pueblo podría estar pendiente de que todo estaría funcionando correctamente \n"+
				"por no hablar de la cantidad de camisetas, videojuegos, bicicletas... que se venden a lo largo del verano";
		JTextArea txt = new JTextArea(text,20,10);
		txt.setOpaque(false);
		txt.setEditable(false);
		txt.setBounds(6, 320, 1078, 115);
		panelCentro.add(txt);
		

	}
}
