
package modelo;

import java.io.Serializable;
import java.util.*;

public class Habitacion implements Serializable{
	
	
	private int NumeroHabitacion;
	private int PrecioHabitacion;
	private int Capacidad_personas;
	
	// fechas ocupacion es una lista que nos dice qué días está ocupada una habitacion y que reserva 
	// esta asociada a el día de ocupacion.
	// El primer elmento de la lista es otra lista que contiene dos fechas que conforman el intervalo de 
	// ocupacion de la habitacion. Desde el segundo elemento en adelante los elemntos son listas de los inertavlos
	// de ocupacion y en el ultimo elemento es el id_de la reserva
	
	private LinkedList<ArrayList<Date>> Fechas_Ocupacion;
	
	
	public Habitacion(int Precio, int Numero, int Capacidad_personas) {
		this.PrecioHabitacion = Precio;
		this.NumeroHabitacion = Numero;
		this.Capacidad_personas = Capacidad_personas;
	}
	
	
	public int getPrecio() {
		return PrecioHabitacion;
	}
	
	public int getNumero() {
		return NumeroHabitacion;
	}
	
	public int getCapacidad_personas() {
		return Capacidad_personas;
	}
	
	public LinkedList<ArrayList<Date>> getFechas_Ocupacion() {
		return Fechas_Ocupacion;
	}
	
	public void Actualizar_fechas_ocupacion(Date fecha_inicial, Date fecha_final, Date id_reserva){
		// Conseguimos el atributo con las fechas de habitación
		LinkedList<ArrayList<Date>> Fechas_Ocupacion = this.getFechas_Ocupacion();
		
		if (Fechas_Ocupacion == null) {
			LinkedList<ArrayList<Date>> fechas_ocupacion = new LinkedList<ArrayList<Date>>();
			ArrayList<Date> intervalo_ocupacion = new ArrayList<Date>();
			
			intervalo_ocupacion.add(fecha_inicial);
			intervalo_ocupacion.add(fecha_final);
			
			fechas_ocupacion.add(intervalo_ocupacion);
			
			ArrayList<Date> intervalo_reserva = new ArrayList<Date>();
			
			intervalo_reserva.add(fecha_inicial);
			intervalo_reserva.add(fecha_final);
			intervalo_reserva.add(id_reserva);
			
			fechas_ocupacion.add(intervalo_reserva);	
			
			Fechas_Ocupacion = fechas_ocupacion;
		
		} else {
			
			ArrayList<Date> intervalo_ocupacion = Fechas_Ocupacion.get(0);
			Date fecha_inicial_ocupacion = intervalo_ocupacion.get(0);
			Date fecha_final_ocupacion = intervalo_ocupacion.get(1);
			ArrayList<Date> intervalo_reserva = new ArrayList<Date>();
			
			if (fecha_inicial.before(fecha_inicial_ocupacion) && fecha_final.before(fecha_inicial_ocupacion)) {
				intervalo_ocupacion.set(0, fecha_inicial);
				Fechas_Ocupacion.set(0, intervalo_ocupacion);
				
				intervalo_reserva.add(fecha_inicial);
				intervalo_reserva.add(fecha_final);
				intervalo_reserva.add(id_reserva);
				
				Fechas_Ocupacion.add(1,intervalo_reserva);
			
			} else if (fecha_inicial.after(fecha_final_ocupacion) && fecha_final.after(fecha_final_ocupacion)) {
				intervalo_ocupacion.set(1, fecha_final);
				Fechas_Ocupacion.set(0, intervalo_ocupacion);
				
				intervalo_reserva.add(fecha_inicial);
				intervalo_reserva.add(fecha_final);
				intervalo_reserva.add(id_reserva);
				
				Fechas_Ocupacion.addLast(intervalo_reserva);
				
			} else if (fecha_inicial.after(fecha_inicial_ocupacion) && fecha_final.before(fecha_final_ocupacion)) {

				
				intervalo_reserva.add(fecha_inicial);
				intervalo_reserva.add(fecha_final);
				intervalo_reserva.add(id_reserva);
				
				
				
				for(int i = 1; i < Fechas_Ocupacion.size()-1; i++) {
					
					Date itr_fecha_final_reserva_i = Fechas_Ocupacion.get(i).get(1);
					Date itr_fecha_inicial_reserva_i2 = Fechas_Ocupacion.get(i+2).get(0);
					
					
					if (fecha_inicial.after(itr_fecha_final_reserva_i) && fecha_final.before(itr_fecha_inicial_reserva_i2)) {
						Fechas_Ocupacion.add(i+1,intervalo_reserva);
						break;
					}
					
					else {
						System.out.println("Error: fecha de reserva no está en medio de dos reservas");
					}
				}
				
			} 
			
			
			
		}
		
		this.Fechas_Ocupacion = Fechas_Ocupacion;
		
	}
	

	
	


}
