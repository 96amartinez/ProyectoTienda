package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

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
		//Crear tabla Patrocinadores
				try {
					stmt.setQueryTimeout(30);
					String Patrocinadores = "CREATE TABLE PATROCINADORES (Descripcion string, rutaFoto string, dinero int)";
					stmt.executeUpdate(Patrocinadores);
				} catch(SQLException e) {
					//Tabla ya existe, nada que hacer
				}
				//Crear la tabla Fotos
				try {
					stmt.setQueryTimeout(30);
					String Fotos = "CREATE TABLE Fotos (ruta string, tipo string)";
					stmt.executeUpdate(Fotos);
				} catch(SQLException e) {
					//Tabla ya existe, nada que hacer	
				}
				//Crear tabla Productos
				try {
					stmt.setQueryTimeout(30);
					String Productos = "CREATE TABLE PRODUCTOS (codigo string, nombre string, precio double, stock int, descripcion string,"+
							"ruta string, categoria string, oferta boolean, talla string, color string, tipo string, marca string, equipo string,"+
							" peso double, Plataforma string)";
					stmt.executeUpdate(Productos);
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
	
	public ArrayList<String> obtenerRutaPatrocinadores(){
		ArrayList<String> aRutas = new ArrayList<String>();
		String query = "SELECT rutaFoto FROM Patrocinadores";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String ruta = rs.getString(1);
				aRutas.add(ruta);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aRutas;
	}

	public ArrayList<String> obtenerRutaProductos(){
		ArrayList<String> aRutas = new ArrayList<String>();
		String query = "SELECT ruta FROM Productos " ;
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String ruta = rs.getString(1);
				aRutas.add(ruta);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aRutas;
	}


	public static String [] obtenerFotos(String tipo) {
		String query = "SELECT COUNT(ruta) FROM Fotos WHERE tipo='"+tipo+"'";
		String [] fotos = null;
		try {
			ResultSet rs = stmt.executeQuery(query);
			int cont = rs.getInt(1);
			rs.close();
			fotos = new String[cont];
			query = "SELECT ruta FROM Fotos WHERE tipo='"+tipo+"'";
			rs = stmt.executeQuery(query);
			int i=0;
			while(rs.next()) {
				String ruta = rs.getString(1);
				fotos[i] = ruta;
				i++;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fotos;
	}


	public ArrayList<String> obtenerProductosCategoria(String cat){
		String query = "SELECT ruta FROM PRODUCTOS WHERE categoria='" + cat + "'";
		ArrayList<String> aProductos = new ArrayList<String>();
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String ruta = rs.getString(1);
				aProductos.add(ruta);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aProductos;
	}
	
	public ArrayList<String> obtenerProductosCategoriaYTipo(String cat, String tipo){
		String query = "SELECT ruta FROM PRODUCTOS WHERE categoria ='" + cat + "' AND tipo='" + tipo +"'";
		ArrayList<String> aProductos = new ArrayList<String>();
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String ruta = rs.getString(1);
				aProductos.add(ruta);
			}
			rs.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return aProductos;
		
	}
	
	public ArrayList<String> obtenerVideojuegosCategoriaPlataformaYTipo(String cat,String plat, String tipo){
		String query = "SELECT ruta FROM PRODUCTOS WHERE categoria ='" + cat + "' AND Plataforma ='" + plat+ "' AND tipo='" + tipo +"'";
		ArrayList<String> aProductos = new ArrayList<String>();
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String ruta = rs.getString(1);
				aProductos.add(ruta);
			}
			rs.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return aProductos;
		
	}
	

	public ArrayList<String> obtenerRutasConFiltroPadel(String tipo,double peso,String color, String marca){
		String query = "SELECT ruta FROM PRODUCTOS WHERE tipo='"+tipo+"' AND peso IS NOT NULL AND peso>="+(peso-200)+" AND peso<="+peso +" AND color='"+color+"' AND marca='"+marca+"'";
		ArrayList<String> aRutas = new ArrayList<String>();
		ResultSet rs;
		System.out.println(tipo+" "+peso+" "+color+" "+marca);
		try {
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String ruta = rs.getString(1);
				System.out.println(ruta);
				aRutas.add(ruta);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aRutas;
	}
	
	

	public ArrayList<String> obtenerRutasConFiltroFutbol(String tipo, String color, String marca, String talla, String equipo){
		String query= "SELECT ruta FROM PRODUCTOS WHERE tipo='" + tipo + "' AND color ='" + color +"' AND marca='" + marca +"' AND talla='" + talla +"' AND equipo='" + equipo +"'";
		ArrayList<String> aRutas = new ArrayList<String>();
		ResultSet rs;
		try {
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String ruta = rs.getString(1);
				aRutas.add(ruta);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aRutas;
	}

	public String obtenerDescripcionPatrocinador(String ruta) {
		String query = "SELECT Descripcion FROM PATROCINADORES WHERE rutaFoto='"+ruta+"'";
		String desc="";
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
				desc = rs.getString(1);
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return desc;
	}

	public double obtenerDinero(String ruta) {
		String query = "SELECT dinero FROM PATROCINADORES WHERE rutaFoto='" + ruta +"'";
		double desc=0;
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
				desc = rs.getDouble(1);
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return desc;
	}

	public ArrayList<String> obtenerUsuarios(){
		ArrayList<String> usuarios = new ArrayList<String>();
		String query = "SELECT nick FROM USUARIO";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String nom = rs.getString("nick");
				usuarios.add(nom);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public void eliminarUsuario(String nick){
		String query= "DELETE FROM PRODUCTOS WHERE nick ='" + nick +"'";
		try {
			stmt.executeUpdate(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void guardarAlumnosEnTabla(DefaultListModel<String> dlm){
		String query = "DELETE FROM PRODUCTOS";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public int contarProductos() {
		String query = "SELECT COUNT (*) FROM PRODUCTOS";
		int num=0;
		try {
			ResultSet rs = stmt.executeQuery(query);
			num = rs.getInt(1);
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public Object[][] obtenerTablaProductos(){
		int num = contarProductos();
		Object tabla [][] = new Object[num][14];
		String query = "SELECT * FROM PRODUCTOS";
		try {
			ResultSet rs = stmt.executeQuery(query);
			int i=0;
			while(rs.next()) {
				tabla[i][0] = rs.getString("codigo");
				tabla[i][1] = rs.getString("nombre");
				tabla[i][2] = rs.getDouble("precio");
				tabla[i][3] = rs.getInt("stock");
				tabla[i][4] = rs.getString("descripcion");
				tabla[i][5] = rs.getString("ruta");
				tabla[i][6] = rs.getString("categoria");
				tabla[i][7] = rs.getBoolean("oferta");
				tabla[i][8] = rs.getString("talla");
				tabla[i][9] = rs.getString("color");
				tabla[i][10] = rs.getString("tipo");
				tabla[i][11] = rs.getString("marca");
				tabla[i][12] = rs.getString("equipo");
				tabla[i][13] = rs.getDouble("peso");
				i++;
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tabla;
	}
	
	public void borrarUsuario(String nick) {
		String query = "DELETE FROM USUARIO WHERE nick='"+nick+"'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
