package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class VentanaBilbao extends JFrame {

	private JPanel contentPane;
	JFrame v = this;
	
	/**
	 * Create the frame.
	 */
	public VentanaBilbao() {
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
		
		JLabel lblBilbao = new JLabel("Bilbao");
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
		
		Image img1 = new ImageIcon("Imagenes/locBilbao.png").getImage();
		ImageIcon img12 = new ImageIcon(img1.getScaledInstance(532, 302, Image.SCALE_SMOOTH));
		JLabel lblFoto1 = new JLabel("");
		lblFoto1.setBounds(552, 6, 532, 302);
		lblFoto1.setIcon(img12);
		panelCentro.add(lblFoto1);
		
		Image img2 = new ImageIcon("Imagenes/FotoBilbao.jpg").getImage();
		ImageIcon img22 = new ImageIcon(img2.getScaledInstance(532, 302, Image.SCALE_SMOOTH));
		JLabel lblFoto2 = new JLabel("");
		lblFoto2.setBounds(6, 6, 532, 302);
		lblFoto2.setIcon(img22);
		panelCentro.add(lblFoto2);
		
		String text = "Como bien puedes apreciar en la foto de la derecha, nuestra tienda se situa en la calle Doctor Areilza Nº4. Es una de las tiendas en la que más vendemos y fue la primera. \n" + 
				"Bilbao o Bilbo en euskera, es un municipio situado al norte de España.Posee una importante infraestructura de transportes que conecta con las principales capitales de \n" + 
				"Europa, por tierra, mar y aire. La capital vizcaína es el corazón de una metrópoli de más de 1.000.000 habitantes. Fundada en 1300, es eje principal del desarrollo \n" + 
				"económico-social y factor base de la modernización de la provincia.\n" + 
				"En Bilbao existen muchos equipos de fúbol pero el más conocido es el Athletic Club. Fue fundado en 1989 y junto con Real Madrid y Barcelona son los únicos equipos que \n" + 
				"no han bajado a 2ª división. Es por esto que es una de las tiendas que más vende, ya que aquí el 95% de la población es del athletic y compran mucho material del\n"+
				"Athletic ya que son de gran calidad y a un precio muy económico";
		JTextArea txt = new JTextArea(text,20,10);
		txt.setEditable(false);
		txt.setOpaque(false);
		txt.setBounds(6, 320, 1078, 115);
		panelCentro.add(txt);
		

	}
}
