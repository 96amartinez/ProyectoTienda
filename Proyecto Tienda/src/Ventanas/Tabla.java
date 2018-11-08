package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Tabla extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Tabla() {
		setExtendedState(MAXIMIZED_BOTH);
		
		JLabel lblTxt = new JLabel("TABLA CON TODOS LOS PRODUCTOS DE LA TIENDA");
		lblTxt.setBounds(450, 3, 500,20);
		getContentPane().add(lblTxt);
		
		String nombresColumnas[] = {"CÓDIGO","NOMBRE","PRECIO","STOCK", "DESCRIPCIÓN","RUTA","CATEGORÍA", "OFERTA", "TALLA",
				"COLOR", "TIPO", "MARCA", "EQUIPO", "PESO"};
		
		Object[][] a = VentanaLogin.bd.obtenerTablaProductos();
		JTable table = new JTable(a, nombresColumnas);
		JScrollPane scrol = new JScrollPane(table);
		table.setBounds(12,22,500,500);
		//setSize(750,700);
		scrol.setBounds(12,22,1230,374);
		getContentPane().add(scrol);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnFoto = new JButton("New button");
		btnFoto.setBounds(450, 400, 399, 266);
		getContentPane().add(btnFoto);
		setVisible(true);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(600,670,100,25);
		getContentPane().add(btnVolver);
		

		
		}

}
