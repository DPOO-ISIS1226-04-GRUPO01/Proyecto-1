package modelo.servicios_y_consumo;

import java.io.Serializable;

public class Consumo implements Serializable {
	
	private int NumeroHabitacion;
	
	private int PrecioConsumo; 
	
	
	public Consumo(int numero, int precio) {
		this.NumeroHabitacion = numero;
		this.PrecioConsumo = precio; 
	}
	
	
	public int GetNumero() {
		return NumeroHabitacion;
	}

}
