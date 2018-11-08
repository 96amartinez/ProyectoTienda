package Datos;

public class ProductoVideojuegos extends Producto{
	
	//REVISAR ATRIBUTOS
	private String plataforma;
	private String tipo;
	
	public ProductoVideojuegos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductoVideojuegos(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		// TODO Auto-generated constructor stub
	}

	public ProductoVideojuegos(String cod, String nombre, double precio, int stock, String desc, String ruta,
			String categoria, boolean oferta, String plataforma, String tipo) {
		super(cod, nombre, precio, stock, desc, ruta, categoria, oferta);
		this.plataforma = plataforma;
		this.tipo = tipo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	@Override
	public String toString() {
		return "ProductoVideojuegos [plataforma=" + plataforma + ", tipo=" + tipo + "]";
	}
	
	

}
