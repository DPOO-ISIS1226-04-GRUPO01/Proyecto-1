package modelo.reservas_y_registro;

import java.io.Serializable;

public abstract class Cliente implements Serializable{
	
	private String Nombre;
	
	private int NumeroHabitacion;
	
	
	
	public Cliente(String nombre, int numero) {
		this.Nombre = nombre;
		this.NumeroHabitacion = numero;
	}
	
	
	
	public int getNumero() {
		return NumeroHabitacion;
	}
}
