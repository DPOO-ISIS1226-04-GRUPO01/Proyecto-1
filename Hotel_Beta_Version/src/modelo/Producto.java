package modelo;

public class Producto {

	private String NombreProducto;
	
	private int PrecioProducto;
	
	public Producto(String nombre, int precio) {
		this.NombreProducto = nombre;
		this.PrecioProducto = precio;
	}
	
	
	public String getNombre() {
		return NombreProducto;
	}
	
	public void setPrecio(int nuevoPrecio) {
		this.PrecioProducto = nuevoPrecio;
	}
}
