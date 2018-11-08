package Datos;

public class ProductoBaloncesto extends Producto{

	private String talla;
	private String equipo;
	private String tipo; //Camiseta, balon, pantalon...
	private String marca;
	private String color;
	
	public ProductoBaloncesto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductoBaloncesto(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		// TODO Auto-generated constructor stub
	}

	public ProductoBaloncesto(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta, String talla, String equipo, String tipo, String marca, String color) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		this.talla = talla;
		this.equipo = equipo;
		this.tipo = tipo;
		this.marca = marca;
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ProductoBaloncesto [talla=" + talla + ", equipo=" + equipo + ", tipo=" + tipo + ", marca=" + marca
				+ ", color=" + color + "]";
	}
	
	
	
}
