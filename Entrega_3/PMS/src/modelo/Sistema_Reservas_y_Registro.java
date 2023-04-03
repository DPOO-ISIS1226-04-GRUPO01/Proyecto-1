package modelo;


import java.io.IOException;
import java.util.*;
import java.io.Serializable;


public class Sistema_Reservas_y_Registro implements Serializable{
	
	
	public static void Crear_reserva(int id_habitacion, Cliente huesped, int num_clientes, Date fecha_inicio, Date fecha_final, Date id_reserva, BaseDatos BD) throws ClassNotFoundException, IOException {
		Reserva reserva = new Reserva(id_habitacion, huesped, fecha_inicio, fecha_final, id_reserva);
		BD.GuardarObjeto(reserva);
	}
		
}