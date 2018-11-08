package Datos;

public class ProductoPadel extends Producto{
 
	private String marca;
	private String tipo; //Pelotas, pala, camiseta...
	private String color;
	private double peso;
	
	public ProductoPadel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductoPadel(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		// TODO Auto-generated constructor stub
	}

	public ProductoPadel(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta, String marca, String tipo, String color, double peso) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		this.marca = marca;
		this.tipo = tipo;
		this.color = color;
		this.peso = peso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "ProductoPadel [marca=" + marca + ", tipo=" + tipo + ", color=" + color + ", peso=" + peso + "]";
	}
	
	
	
}
