package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class VentanaJList extends JFrame {

	private JPanel contentPane;
	private JList<String> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJList frame = new VentanaJList();
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
	public VentanaJList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		panelSur.add(btnVolver);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.CENTER);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel1 = new JPanel();
		panelCentro.add(panel1);
		panel1.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panelCentro.add(panel2);
		panel2.setLayout(null);
		
		Image im = new ImageIcon("Imagenes/elim.png").getImage();
		ImageIcon im2 = new ImageIcon(im.getScaledInstance(146, 229, Image.SCALE_SMOOTH));
		JButton btn = new JButton();
		btn.setBounds(0, 0, 146, 229);
		panel2.add(btn);
		btn.setIcon(im2);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!lista.isSelectionEmpty()) {
					DefaultListModel<String> dlm1 = (DefaultListModel<String>)lista.getModel();
					int pos = lista.getSelectedIndex();
					VentanaLogin.bd.borrarUsuario(dlm1.getElementAt(pos));
					dlm1.removeElementAt(pos);
					lista.setModel(dlm1);
					
				}
			}
		});
		
		ArrayList<String> usuarios = VentanaLogin.bd.obtenerUsuarios();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		for(String nom: usuarios) {
			dlm.addElement(nom);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 121, 193);
		panel1.add(scrollPane);
		lista = new JList<String>(new DefaultListModel<String>());
		scrollPane.setViewportView(lista);
		lista.setModel(dlm);
		
		JLabel lblUsuarios = new JLabel("Usuarios registrados");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setBounds(10,11,130,22);
		panel1.add(lblUsuarios);
		
		
		
	}
}
