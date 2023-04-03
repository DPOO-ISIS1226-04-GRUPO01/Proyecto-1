package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;



public class Reserva implements Serializable{
	
	private ArrayList<Integer> Habitaciones;
	
	private Cliente Huesped;
	
	private Date Fecha_Inicio;
	
	private Date Fecha_Final;
	
	private Date Id_reserva;
	
	private int Id_habitacion; 
	
	public Reserva(int id_habitacion, Cliente Huesped, Date Fecha_Inicio, Date Fecha_Final, Date id_reserva) {
		this.Id_habitacion = id_habitacion;
		this.Huesped = Huesped;
		this.Fecha_Inicio = Fecha_Inicio;
		this.Fecha_Final = Fecha_Final;
		this.Id_reserva = id_reserva;
		
	}
	

	
	public ArrayList<Integer> getHabitaciones() {
		return Habitaciones;
	}
	
	public Cliente getNombreHuesped() {
		return Huesped;
	}
	public Date getFecha_Inicio() {
		return Fecha_Inicio;
	}
	
	public Date getFecha_Final() {
		return Fecha_Final;
	}
	
	public Date getId_reserva() {
		return Id_reserva;
	}
	
}
