package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

public class VentanasGBL extends JFrame {

	private JPanel contentPane;
	private JFrame v = this;
	private JPanel panelBiciC, panelBiciM, panelCasco, panelBote, panelMaillot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanasGBL frame = new VentanasGBL();
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
	public VentanasGBL() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lbTexto = new JLabel("Productos de ciclismo");
		panelNorte.add(lbTexto);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		panelSur.add(btnVolver);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentro = new GridBagLayout();
		gbl_panelCentro.columnWidths = new int[]{0, 0, 0, 0, 0 };
		gbl_panelCentro.rowHeights = new int[]{0, 0, 0};
		gbl_panelCentro.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_panelCentro.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelCentro.setLayout(gbl_panelCentro);
		
		
		//PANEL BICI CARRETERA GRIDBAGLAYOUT
		JScrollPane s1 = new JScrollPane();
		GridBagConstraints gbc_s1 = new GridBagConstraints();
		gbc_s1.fill = GridBagConstraints.BOTH;
		gbc_s1.insets = new Insets(0, 0, 5, 5);
		gbc_s1.gridx = 0;
		gbc_s1.gridy = 0;
		panelCentro.add(s1, gbc_s1);
		
		panelBiciC = new JPanel();
		s1.setViewportView(panelBiciC);
		panelBiciC.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JLabel lblBiciC = new JLabel("Bicicletas de carretera");
		lblBiciC.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiciC.setForeground(Color.PINK);
		lblBiciC.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		//panelCentro.add(lblBiciC);
		panelCentro.add(lblBiciC); //SALE EL NOMBRE COMO UN GRIDLAYOUT XQ ESTÁ DENTRO DEL GRIDLAYOUT ASIQUE TENGO QUE HACERLO ANTES CON GRIDBAGLAYOUT
		panelBiciC.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent evento) {
				// TODO Auto-generated method stub
				Point p = evento.getPoint();
				JLabel lblProducto = (JLabel)panelBiciC.getComponentAt(p);
				ImageIcon im = (ImageIcon)lblProducto.getIcon();
				String url = im.getDescription();
				v.dispose();
				VentanaDescripcionPatrocinadores vdp = new VentanaDescripcionPatrocinadores(url,v);
				vdp.setVisible(true);
			}
		});
		
		
		
		//PANEL BICI MONTAÑA GRIDBAGLAYOUT
		JScrollPane s2 = new JScrollPane();
		GridBagConstraints gbc_s2 = new GridBagConstraints();
		gbc_s2.fill = GridBagConstraints.BOTH;
		gbc_s2.insets = new Insets(0, 0, 5, 5);
		gbc_s2.gridx = 1;
		gbc_s2.gridy = 0;
		panelCentro.add(s2, gbc_s2);
		
		panelBiciM = new JPanel();
		s2.setViewportView(panelBiciM);
		panelBiciM.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblBiciM = new JLabel("Bicicletas de montaña");
		lblBiciM.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiciM.setForeground(Color.BLUE);
		lblBiciM.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panelBiciM.add(lblBiciM);
		panelBiciM.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent evento) {
				// TODO Auto-generated method stub
				Point p = evento.getPoint();
				JLabel lblProducto = (JLabel)panelBiciM.getComponentAt(p);
				ImageIcon im = (ImageIcon)lblProducto.getIcon();
				String url = im.getDescription();
				v.dispose();
				VentanaDescripcionPatrocinadores vdp = new VentanaDescripcionPatrocinadores(url,v);
				vdp.setVisible(true);
			}
		});
		
		
		
		//PANEL CASCO GRIDBAGLAYOUT
		JScrollPane s3 = new JScrollPane();
		GridBagConstraints gbc_s3 = new GridBagConstraints();
		gbc_s3.fill = GridBagConstraints.BOTH;
		gbc_s3.insets = new Insets(0, 0, 5, 5);
		gbc_s3.gridx = 2;
		gbc_s3.gridy = 0;
		panelCentro.add(s3, gbc_s3);
		
		panelCasco = new JPanel();
		s3.setViewportView(panelCasco);
		panelCasco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblCasco = new JLabel("Cascos");
		lblCasco.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasco.setForeground(Color.ORANGE);
		lblCasco.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panelCasco.add(lblCasco);
		panelCasco.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent evento) {
				// TODO Auto-generated method stub
				Point p = evento.getPoint();
				JLabel lblProducto = (JLabel)panelCasco.getComponentAt(p);
				ImageIcon im = (ImageIcon)lblProducto.getIcon();
				String url = im.getDescription();
				v.dispose();
				VentanaDescripcionPatrocinadores vdp = new VentanaDescripcionPatrocinadores(url,v);
				vdp.setVisible(true);
			}
		});
		
		
		
		//PANEL BOTELLIN GRIDBAGLAYOUT
		JScrollPane s4 = new JScrollPane();
		GridBagConstraints gbc_s4 = new GridBagConstraints();
		gbc_s4.fill = GridBagConstraints.BOTH;
		gbc_s4.insets = new Insets(0, 0, 5, 5);
		gbc_s4.gridx = 3;
		gbc_s4.gridy = 0;
		panelCentro.add(s4, gbc_s4);
		
		panelBote = new JPanel();
		s4.setViewportView(panelBote);
		panelBote.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblBote = new JLabel("Botellines");
		lblBote.setHorizontalAlignment(SwingConstants.CENTER);
		lblBote.setForeground(Color.GREEN);
		lblBote.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panelBote.add(lblBote);
		panelBote.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent evento) {
				// TODO Auto-generated method stub
				Point p = evento.getPoint();
				JLabel lblProducto = (JLabel)panelBote.getComponentAt(p);
				ImageIcon im = (ImageIcon)lblProducto.getIcon();
				String url = im.getDescription();
				v.dispose();
				VentanaDescripcionPatrocinadores vdp = new VentanaDescripcionPatrocinadores(url,v);
				vdp.setVisible(true);
			}
		});
		
		
		
		//PANEL MAILLOTS GRIDBAGLAYOUT
		JScrollPane s5 = new JScrollPane();
		GridBagConstraints gbc_s5 = new GridBagConstraints();
		gbc_s5.insets = new Insets(0, 0, 5, 0);
		gbc_s5.fill = GridBagConstraints.BOTH;
		gbc_s5.gridx = 4;
		gbc_s5.gridy = 0;
		panelCentro.add(s5, gbc_s5);
		
		panelMaillot = new JPanel();
		s5.setViewportView(panelMaillot);
		panelMaillot.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblMaillot = new JLabel("Maillots");
		lblMaillot.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaillot.setForeground(Color.RED);
		lblMaillot.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panelMaillot.add(lblMaillot);
		
		JLabel label = new JLabel("New label");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panelCentro.add(label, gbc_label);
		panelMaillot.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent evento) {
				// TODO Auto-generated method stub
				Point p = evento.getPoint();
				JLabel lblProducto = (JLabel)panelMaillot.getComponentAt(p);
				ImageIcon im = (ImageIcon)lblProducto.getIcon();
				String url = im.getDescription();
				v.dispose();
				VentanaDescripcionPatrocinadores vdp = new VentanaDescripcionPatrocinadores(url,v);
				vdp.setVisible(true);
			}
		});
		cargarImagenesBicicletasCarretera();
		cargarImagenesBicicletasMontaña();
		cargarImagenesCascos();
		cargarImagenesBotellines();
		cargarImagenesMaillots();	
		
		

	}
	


	private void cargarImagenesBotellines() {
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerProductosCategoriaYTipo("Ciclismo","Botellines");
		for(int i=0;i<aRutas.size();i++) {
			String ruta = aRutas.get(i);
			ImageIcon im = new ImageIcon(ruta);
			int width =250;
			int height = 250;
			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel lblFoto = new JLabel(im);
			panelBote.add(lblFoto);
			lblFoto.setIcon(im);
		}
	}

	private void cargarImagenesCascos() {
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerProductosCategoriaYTipo("Ciclismo","Cascos");
		for(int i=0;i<aRutas.size();i++) {
			String ruta = aRutas.get(i);
			ImageIcon im = new ImageIcon(ruta);
			int width =250;
			int height = 250;
			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel lblFoto = new JLabel(im);
			panelCasco.add(lblFoto);
			lblFoto.setIcon(im);
		}
	}

	private void cargarImagenesMaillots() {
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerProductosCategoriaYTipo("Ciclismo","Maillots");
		for(int i=0;i<aRutas.size();i++) {
			String ruta = aRutas.get(i);
			ImageIcon im = new ImageIcon(ruta);
			int width =250;
			int height = 250;
			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel lblFoto = new JLabel(im);
			panelMaillot.add(lblFoto);
			lblFoto.setIcon(im);
		}
	}

	private void cargarImagenesBicicletasCarretera() {
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerProductosCategoriaYTipo("Ciclismo","Bicicletas Carretera");
		for(int i=0;i<aRutas.size();i++) {
			String ruta = aRutas.get(i);
			ImageIcon im = new ImageIcon(ruta);
			int width =250;
			int height = 250;
			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel lblFoto = new JLabel(im);
			panelBiciC.add(lblFoto);
			lblFoto.setIcon(im);
		}
	}

	private void cargarImagenesBicicletasMontaña() {
		ArrayList<String> aRutas = VentanaLogin.bd.obtenerProductosCategoriaYTipo("Ciclismo","Bicicletas Montaña");
		for(int i=0;i<aRutas.size();i++) {
			String ruta = aRutas.get(i);
			ImageIcon im = new ImageIcon(ruta);
			int width =250;
			int height = 250;
			im.setImage(im.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel lblFoto = new JLabel(im);
			panelBiciM.add(lblFoto);
			lblFoto.setIcon(im);
		}
	}

}
