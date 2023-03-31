package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import modelo.Hotel;
import modelo.reservas_y_registro.Huesped;
import modelo.inventario_y_BD.BaseDatos;
import modelo.inventario_y_BD.Habitacion;





public class vista {
	
	private Hotel infoHotel;
	
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		vista Aplicacion = new vista();
		Aplicacion.ejecutarAplicacion();
	}
	
	
	public void ejecutarAplicacion() throws IOException, ClassNotFoundException {
		System.out.println("Hotel El Dorado");
		this.infoHotel = new Hotel();
	
		
		CrearArchivos();
		int precio = Integer.parseInt(input("Diga el precio de la habitacion"));
		int numero = Integer.parseInt(input("Diga el numero de la habitacion"));
		
		GuardarObjeto(precio,numero);
		
	
		
		ObtenerInventario();
		
		numero = Integer.parseInt(input("Diga el numero de la habitacion que quiere eliminar"));
		EliminarHabitacion(numero);
		
		ObtenerInventario();
		
		
		
		
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
		BD.CrearArchivoHuespedes();
		BD.CrearArchivoInventario();
		BD.CrearArchivoUsuarios();
		BD.CrearArchivoMenu();
		BD.CrearArchivoServicios();
		BD.CrearArchivoReservas();
	}

	
	public void GuardarHabitacion(int precio, int numero) throws IOException, ClassNotFoundException {
		infoHotel.crearHabitacion(precio,numero);
	}
	
	public void ObtenerInventario() throws ClassNotFoundException, IOException {
		Collection<Habitacion> inventario = infoHotel.getInventario().values();
		for (Habitacion element:inventario) {
			System.out.print(element.getPrecio());
			System.out.print("    ");
			System.out.print(element.getNumero());
			System.out.print("\n");
		}
		
	}
	
	
	public void ObtenerHuespedes() throws ClassNotFoundException, IOException {
		Collection<Huesped> inventario = infoHotel.getHuespedes().values();
		for (Huesped element:inventario) {
			System.out.print(element.getNumero());
			System.out.print("    ");
			
		}
		
	}
	
	
		public void EliminarHabitacion(int numeroHabitacion) throws IOException, ClassNotFoundException {
			infoHotel.eliminarObjeto(numeroHabitacion); ;
		}
		
		public void GuardarObjeto(int precio, int numero) throws ClassNotFoundException, IOException {
			infoHotel.GuardarrObjeto(precio, numero);
		}
}
