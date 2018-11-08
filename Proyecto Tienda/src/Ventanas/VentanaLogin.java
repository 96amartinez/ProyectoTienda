package Ventanas;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.awt.event.ActionEvent;

//Poner en el login arriba a la derecha la hora y abajo a la izquierda el día
public class VentanaLogin extends JFrame implements Runnable{

	private JPanel contentPane;
	private JPasswordField pssContrasenia;
	private JTextField txtNick;
	String hora,minutos,segundos,ampm;
	Calendar calendario;    
	Thread h1;
	private JLabel lblHora;

	public static BD bd;
	private static Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void limpiarCampos() {
		txtNick.setText("");
		pssContrasenia.setText("");
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		//Creamos la base de datos
		bd = new BD();
		//Creamos las tablas
		bd.createTable(con);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null); //Para centrar la ventana
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		JLabel lblBienvenidoAMi = new JLabel("Bienvenido a Mi Tienda");
		lblBienvenidoAMi.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 25));
		panelNorte.add(lblBienvenidoAMi);

		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		JPanel panelOeste = new JPanel();
		contentPane.add(panelOeste, BorderLayout.WEST);

		JPanel panelEste = new JPanel();
		contentPane.add(panelEste, BorderLayout.EAST);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		JLabel lblInicio = new JLabel("Inicio de Sesión");
		lblInicio.setForeground(Color.BLUE);
		lblInicio.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		lblInicio.setBounds(156, 26, 175, 16);
		panelCentro.add(lblInicio);

		JLabel lblNick = new JLabel("Nick");
		lblNick.setBounds(74, 91, 61, 16);
		panelCentro.add(lblNick);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(74, 142, 85, 16);
		panelCentro.add(lblContrasea);

		pssContrasenia = new JPasswordField();
		pssContrasenia.setBounds(291, 137, 130, 26);
		panelCentro.add(pssContrasenia);

		txtNick = new JTextField();
		txtNick.setBounds(291, 86, 130, 26);
		panelCentro.add(txtNick);
		txtNick.setColumns(10);

		/**
		 * COMPROBAR EL MES
		 */
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date(System.currentTimeMillis()));
		JLabel lblFecha = new JLabel("New label");
		lblFecha.setBounds(272, 195, 149, 16);
		int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = gc.get(GregorianCalendar.MONTH)+1;
		int anio = gc.get(GregorianCalendar.YEAR);
		lblFecha.setText(dia + "-" + mes + "-" + anio);
		panelCentro.add(lblFecha);


		JFrame v = this;
		JButton btnAceptar = new JButton("Iniciar sesión");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNick.equals("")) {
					JOptionPane.showMessageDialog(null, "El campo Nick no puede estar vacio");
				}else if(pssContrasenia.equals("")) {
					JOptionPane.showMessageDialog(null, "El campo Contraseña no puede estar vacio");
				}
				else if(bd.existeUsuario(txtNick.getText(), pssContrasenia.getText())==0){
					//Nick mal introducido
					JOptionPane.showMessageDialog(null, "El Nick introducido no es correcto. Vuelva a introducirlo o registrese.");
					txtNick.setText("");
					pssContrasenia.setText("");
				} else if(bd.existeUsuario(txtNick.getText(), pssContrasenia.getText())==1) {
					//Contraseña mal introducida
					JOptionPane.showMessageDialog(null, "La contraseña introducida es incorrecta. Vuelva a introducirla");
					txtNick.setText("");
					pssContrasenia.setText("");
				}else {
					//Nick y contraseña bien introducidos por lo tanto el usuario existe
					JOptionPane.showMessageDialog(null, "Bienvenido a Mi Tienda");
					v.dispose();
					VentanaMenu vm = new VentanaMenu(v);
					vm.setVisible(true);
					//musica();
					
				}
			}
		});
		btnAceptar.setBounds(96, 228, 117, 29);
		panelCentro.add(btnAceptar);

		//JFrame v = this;
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.dispose();
				VentanaRegistrar vr = new VentanaRegistrar(bd);
				vr.setVisible(true);
				limpiarCampos();
			}
		});


		btnRegistrarse.setBounds(291, 228, 117, 29);
		panelCentro.add(btnRegistrarse);

		//	HILO PARA QUE EL TIEMPO AVANCE, REVISARLO
		//Date dia2 = new Date(System.currentTimeMillis());
		lblHora = new JLabel("New label");
		lblHora.setBounds(162, 195, 86, 16);
		//lblHora.setText(dia2.getHours() + ":" + dia2.getMinutes() + ":" + dia2.getSeconds());
		panelCentro.add(lblHora);

		
		Image imgNick = new ImageIcon("Imagenes/IconoNick.png").getImage();
		ImageIcon imgNick2= new ImageIcon(imgNick.getScaledInstance(45, 37, Image.SCALE_SMOOTH));
		JLabel lblFotoNick = new JLabel("New label");
		lblFotoNick.setBounds(139, 81, 45, 37);
		lblFotoNick.setIcon(imgNick2);
		panelCentro.add(lblFotoNick);


		Image imgCon = new ImageIcon("Imagenes/IconoContrasenia.png").getImage();
		ImageIcon imgCon2 = new ImageIcon(imgCon.getScaledInstance(45, 37, Image.SCALE_SMOOTH));
		JLabel lblFotoContrasenia = new JLabel("New label");
		lblFotoContrasenia.setBounds(171, 132, 45, 37);
		lblFotoContrasenia.setIcon(imgCon2);
		panelCentro.add(lblFotoContrasenia);

		Image imgTi = new ImageIcon("Imagenes/IconoTienda.jpg").getImage();
		ImageIcon imgTi2 = new ImageIcon(imgTi.getScaledInstance(93, 74, Image.SCALE_SMOOTH));
		JLabel lblIconoTienda = new JLabel("New label");
		lblIconoTienda.setBounds(360, 6, 93, 74);
		lblIconoTienda.setIcon(imgTi2);
		panelCentro.add(lblIconoTienda);
		h1 = new Thread(this);
		h1.start();
		setVisible(true);

	}

	//REVISAR CÓDIGO
	//El ? es como si fuera un if
	public void calcula () {        
		Calendar calendario = new GregorianCalendar();
		Date fechaHoraActual = new Date();


		calendario.setTime(fechaHoraActual);
		ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";

		if(ampm.equals("PM")){
			int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
			hora = h>9?""+h:"0"+h;
		}else{
			hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);            
		}
		minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND); 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread ct = Thread.currentThread();
		while(ct == h1) {   
			calcula();
			lblHora.setText(hora + ":" + minutos + ":" + segundos + " "+ampm);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}

	}
	//REVISAR
	/*public static void musica() {
		try{
			FileInputStream fis = new FileInputStream("BuscandoEnLaBasura.mp3");
			Player player = new Player(fis);
			player.play();
			System.out.println("La canción está sonando");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(JavaLayerException e) {
			e.printStackTrace();
		}
	}*/
}
