package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  


import modelo.inventario_y_BD.BaseDatos;
import modelo.inventario_y_BD.Habitacion;
import modelo.Hotel;
import modelo.reservas_y_registro.Cliente;
import modelo.reservas_y_registro.Reserva;
import modelo.reservas_y_registro.Sistema_Reservas_y_Registro;




public class vista {
	
	private Hotel infoHotel;
	
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
		vista Aplicacion = new vista();
		Aplicacion.ejecutarAplicacion();
	}
	
	
	public void ejecutarAplicacion() throws IOException, ClassNotFoundException, ParseException {
		System.out.println("Hotel El Dorado");
		this.infoHotel = new Hotel();
	
		
		CrearArchivos();
		
		int id_habitacion = Integer.parseInt(input("Diga el id de la habitacion"));
		String nombre_huesped = input("Diga el nombre del huesped");
		
		String fecha_inicio_raw = input("Diga la fecha de inicio");
		Date fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_inicio_raw);  
		
		
		String fecha_final_raw = input("Diga la fecha final");
		Date fecha_final = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_final_raw);
		
		long id_reserva = Long.parseLong(input("Diga el id de la reserva"));
		
		
		// Reserva reserva = new Reserva(id_habitacion, nombre_huesped, fecha_inicio, fecha_final, id_reserva);
		// GuardarObjeto(reserva);
		
		Sistema_Reservas_y_Registro.Crear_reserva(id_habitacion, nombre_huesped, 12, fecha_inicio, fecha_final, id_reserva, infoHotel.getBD());	
	
		
		ObtenerReservas();
		
		
		
		
		long numero = Long.parseLong(input("Diga el numero de la reserva que quiere eliminar"));
		EliminarReserva(numero);
		
		ObtenerReservas();
		
		
		
		
	}
	
	
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void CrearArchivos() throws IOException {
		BaseDatos BD = infoHotel.getBD();
		BD.CrearArchivoConsumos();
		BD.CrearArchivoClientes();
		BD.CrearArchivoInventario();
		BD.CrearArchivoUsuarios();
		BD.CrearArchivoMenu();
		BD.CrearArchivoServicios();
		BD.CrearArchivoReservas();
	}

	
	public void GuardarHabitacion(int precio, int numero) throws IOException, ClassNotFoundException {
		infoHotel.crearHabitacion(precio,numero);
	}
	
	public void ObtenerReservas() throws ClassNotFoundException, IOException {
		Collection<Reserva> reserva = infoHotel.getReservas().values();
		for (Reserva element:reserva) {
			System.out.print(element.getId_reserva());
			System.out.print("    ");
			System.out.print(element.getNombreHuesped());
			System.out.print("\n");
		}
		
	}
	
	
	public void ObtenerHuespedes() throws ClassNotFoundException, IOException {
		Collection<Cliente> inventario = infoHotel.getClientes().values();
		for (Cliente element:inventario) {
			System.out.print(element.getNumero());
			System.out.print("    ");
			
		}
		
	}
	
	
		public void EliminarHabitacion(int numeroHabitacion) throws IOException, ClassNotFoundException {
			infoHotel.eliminarObjeto(numeroHabitacion); ;
		}
		
		public void EliminarReserva(long numeroReserva) throws IOException, ClassNotFoundException {
			infoHotel.eliminarReserva(numeroReserva);
		}
		
		public void GuardarObjeto(Object objeto) throws ClassNotFoundException, IOException {
			infoHotel.GuardarrObjeto(objeto);
			
		}
}