package modelo.reservas_y_registro;


import java.io.IOException;
import java.util.*;
import java.io.Serializable;


import modelo.inventario_y_BD.BaseDatos;


public class Sistema_Reservas_y_Registro implements Serializable{
	
	
	public static void Crear_reserva(int id_habitacion, String nombre_huesped, int num_clientes, Date fecha_inicio, Date fecha_final, long id_reserva, BaseDatos BD) throws ClassNotFoundException, IOException {
		Reserva reserva = new Reserva(id_habitacion, nombre_huesped, fecha_inicio, fecha_final, id_reserva);
		BD.GuardarObjeto(reserva);
	}
		
}
