package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

	private Connection con;
	private static Statement stmt;
	
	/**
	 * Método que crea una sentencia para acceder a la base de datos
	 */
	public void crearSentencia() {
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que permite conectarse a la base de datos
	 */
	public void conectar() {
		try {
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:BaseDeDatos.db");
		crearSentencia();
		}catch (Exception e) {
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que cierra una sentencia
	 */
	public void cerrarSentencia() {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que permite desconectarse de la base de datos
	 */
	public void desconectar() {
		try {
			cerrarSentencia();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BD() {
		conectar();
	}
	
	//A partir de aquí hacemos las consultas específicas de cada proyecto
	
	public Statement createTable(Connection con) {
		
		//Crear tabla usuario
		try {
			stmt.setQueryTimeout(30);
			String Usuario = "CREATE TABLE USUARIO(DNI string, nombre string, apellido string, nick string, contrasenia string, numTel string, domicilio string, cuentaBancaria string)";
			
			stmt.executeUpdate(Usuario);
		} catch(SQLException e) {
			//Tabla ya existe, nada que hacer
		}
		return null;
	}
	
	/**
	 * Método que comprueba si el usuario existe o no
	 * @param nic: Nick introducido por el usuario
	 * @param con: Contraseña introducida por el usuario
	 * @return	0: Si no existe el usuario
	 * 			1: Si existe el nick del usuario pero la contraseña es incorrecta
	 * 			2: Si el nick del usuario es correcto y la contraseña también
	 * 	
	 */
	
	//TODO HE TENIDO QUE PONER STATIC PARA PODER HACER EL JUNIT, NO SE SI ESTARÁ BIEN
	public static int existeUsuario(String nic, String con) {
		String query = "SELECT * FROM Usuario WHERE nick='"+nic+"'";
		ResultSet rs = null;
		int resul=0;
		try {
			rs = stmt.executeQuery(query);
			if(rs.next()){ //AquÌ estamos comprobando si la SELECT ha devuelto alguna fila
				String n = rs.getString("nick");
				String c = rs.getString("contrasenia");
				if(!n.equals(nic))
					resul=0;
				else if(!c.equals(con))
					resul=1;
				else
					resul=2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resul;
	}
	
	/**
	 * Método para Registrar Usuario.
	 * @param dni: DNI del usuario
	 * @param nom: nombre del usuario
	 * @param ape: apellido del usuario
	 * @param nic: nick del usuario
	 * @param con: contraseña del usuario
	 * @param num: numero de teléfono del usuario
	 * @param dom: domicilio del usuario
	 * @param cuenta: cuenta banquaria del usuario
	 */
	public void registrarUsuario(String dni, String nom, String ape, String nic, String con, String num, String dom, String cuenta) {
		String query= "INSERT INTO Usuario(DNI, nombre, apellido, nick, contrasenia, numTel, domicilio, cuentaBancaria ) VALUES('"+dni+"','"+nom+
				"','" + ape + "','" +nic +"','" + con +"','" + num + "','" + dom + "','" + cuenta+ "')" ;
		//No podemos REsultSet pq una INSERT no devuelve filas, solo inserta en la tabla
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
