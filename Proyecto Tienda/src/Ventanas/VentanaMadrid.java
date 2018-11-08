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
public class VentanaMadrid extends JFrame {

	private JPanel contentPane;
	JFrame v = this;
	
	/**
	 * Create the frame.
	 */
	public VentanaMadrid() {
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
		
		JLabel lblBilbao = new JLabel("Madrid");
		lblBilbao.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		panelNorte.add(lblBilbao);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		panelSur.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.dispose();
				VentanaMenu vm = new VentanaMenu(v);
				vm.setVisible(true);
				
			}
		});
		
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		Image img1 = new ImageIcon("Imagenes/fotoMadrid.jpg").getImage();
		ImageIcon img12 = new ImageIcon(img1.getScaledInstance(532, 302, Image.SCALE_SMOOTH));
		JLabel lblFoto1 = new JLabel("");
		lblFoto1.setBounds(552, 6, 532, 302);
		lblFoto1.setIcon(img12);
		panelCentro.add(lblFoto1);
		
		Image img2 = new ImageIcon("Imagenes/locMadrid.png").getImage();
		ImageIcon img22 = new ImageIcon(img2.getScaledInstance(532, 302, Image.SCALE_SMOOTH));
		JLabel lblFoto2 = new JLabel("");
		lblFoto2.setBounds(6, 6, 532, 302);
		lblFoto2.setIcon(img22);
		panelCentro.add(lblFoto2);
		
		String text = "Madrid es un municipio y ciudad de España. La localidad, con categoría histórica de villa,9​ es la capital del Estado10​ y de la Comunidad de Madrid. Dentro del término  \n" + 
				"municipal de Madrid, el más poblado de España, viven 3 182 981 personas empadronadas, según el INE de 2017. El área metropolitana de Madrid tiene una población de \n" + 
				"6 543 031 habitantes,11​ por lo que es la tercera o cuarta área metropolitana de la Unión Europea, según la fuente, por detrás de las de París y Londres, y en \n" + 
				"algunas fuentes detrás también de la Región del Ruhr, así como la tercera ciudad más poblada de la Unión Europea, por detrás de Berlín y Londres.\n"
				+ "La ciudad cuenta con un PIB nominal de 227 411 millones USD y un PIB per cápita nominal de 34 425 USD, lo que representa un PIB PPA per cápita de 40 720 USD,16​ siendo la\n"
				+ " 1.ª área metropolitana española en actividad económica; y la décima de Europa. Madrid es también la ciudad española con más pernoctaciones hoteleras" ;
		
		 
		JTextArea txt = new JTextArea(text,20,10);
		txt.setEditable(false);
		txt.setOpaque(false);
		txt.setBounds(6, 326, 1078, 115);
		panelCentro.add(txt);
		

	}
}
