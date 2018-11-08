package Datos;

public class ProductoFutbol extends Producto{
	
	private String talla;
	private String color;
	private String tipo;//Camiseta, botas, pantalon...
	private String marca;
	private String equipo;
	

	public ProductoFutbol() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductoFutbol(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		// TODO Auto-generated constructor stub
	}


	public ProductoFutbol(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta, String talla, String color, String tipo, String marca, String equipo) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		this.talla = talla;
		this.color = color;
		this.tipo = tipo;
		this.marca = marca;
		this.equipo = equipo;
	}


	public String getTalla() {
		return talla;
	}


	public void setTalla(String talla) {
		this.talla = talla;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getEquipo() {
		return equipo;
	}
	
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}



	@Override
	public String toString() {
		return "ProductoFutbol [talla=" + talla + ", color=" + color + ", tipo=" + tipo + ", marca=" + marca + ", equipo=" + equipo+ "]";
	}
	
	
	
	
	
	

}
