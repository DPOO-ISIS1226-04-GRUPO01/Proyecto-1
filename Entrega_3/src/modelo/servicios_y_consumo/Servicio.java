package modelo.servicios_y_consumo;

public class Servicio {

	private String NombreServicio;
	
	private int PrecioServicio;
	
	
	public Servicio(String nombre, int precio) {
		this.NombreServicio = nombre;
		this.PrecioServicio = precio;
	}
	
	
	public String getNombreServicio() {
		return NombreServicio;
	}
	
	
	public void setPrecio(int nuevoPrecio) {
		this.PrecioServicio = nuevoPrecio;
	}
	
}


