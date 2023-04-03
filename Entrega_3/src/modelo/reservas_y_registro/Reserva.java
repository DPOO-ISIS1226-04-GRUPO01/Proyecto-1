package modelo.reservas_y_registro;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import modelo.inventario_y_BD.BaseDatos;
import modelo.inventario_y_BD.Habitacion;
import java.util.Random;



public class Reserva implements Serializable{
	
	private ArrayList<Integer> Habitaciones;
	
	private String NombreHuesped;
	
	private Date Fecha_Inicio;
	
	private Date Fecha_Final;
	
	private Date Id_reserva;
	
	public Reserva(String nombre_huesped, Date Fecha_Inicio, Date Fecha_Final, Date id_reserva, BaseDatos BD) {
		this.NombreHuesped = nombre_huesped;
		this.Fecha_Inicio = Fecha_Inicio;
		this.Fecha_Final = Fecha_Final;
		this.Id_reserva = id_reserva;
		
	}
	

	
	public ArrayList<Integer> getHabitaciones() {
		return Habitaciones;
	}
	
	public String getNombreHuesped() {
		return NombreHuesped;
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
	
	public void setHabitaciones(Date Fecha_Inicio, Date Fecha_Final, HashMap<Date, ArrayList<Integer> > Mapa_Ocupacion) throws ClassNotFoundException, IOException {
		
		
	}
}
