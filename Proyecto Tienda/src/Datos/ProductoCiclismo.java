package Datos;

public class ProductoCiclismo extends Producto{
	
	private String tipo; //Bici de monte, de carretera, cascos, mayot...
	private String marca;
	private String color;
	private String equipo;
	private double peso;
	
	public ProductoCiclismo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductoCiclismo(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		// TODO Auto-generated constructor stub
	}
	
	public ProductoCiclismo(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta, String tipo, String marca, String color, String equipo,
			double peso) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		this.tipo = tipo;
		this.marca = marca;
		this.color = color;
		this.equipo = equipo;
		this.peso = peso;
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

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "ProductoCiclismo [tipo=" + tipo + ", marca=" + marca + ", color=" + color
				+ ", equipo=" + equipo + ", peso=" + peso + "]";
	}
	
	
	
	

}
