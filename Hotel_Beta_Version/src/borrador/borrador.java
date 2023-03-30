package borrador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import modelo.Consumo;
import modelo.Habitacion;
import modelo.Huesped;
import modelo.Producto;
import modelo.Reserva;
import modelo.Servicio;

public class borrador {

/*
	public void GuardarHabitaciónInventario (Habitacion habitacion) throws IOException, ClassNotFoundException {
		//guarda habitación en archivo si no existe
		HashMap<Integer, Habitacion> inventario = GetInventario();
		inventario.put(habitacion.getNumero(),habitacion);
		FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoInventario.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(inventario); 
		objectOutputStream.close();
	}
	
	
	// Funciones para escribir informacion en archivos SISTEMA DE REGISTROS DE CONSUMO
	
	public void GuardarConsumo(Consumo consumo) throws IOException, ClassNotFoundException {
		//guarda consumo en archivo si no existe
		HashMap<Integer, Consumo> huespedes = GetConsumos();
		huespedes.put(consumo.GetNumero(), consumo);
		FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoHuespedes.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(huespedes); 
		objectOutputStream.close();
	}
	
	
	// Funciones para escribir informacion en archivos SISTEMA DE RESERVAS Y REGISTRO
	
	
	public void GuardarReserva (Reserva reserva) throws IOException, ClassNotFoundException {
		HashMap<Integer, Reserva> reservas = GetReservas();
		reservas.put(reserva.getNumeroHabitacion() , reserva);
		FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoReservas.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(reservas); 
		objectOutputStream.close();
		
	}
	
	
	public void GuardarHuesped (Huesped huesped) throws ClassNotFoundException, IOException {
		//guarda huesped en archivo si no existe
		HashMap<Integer, Huesped> huespedes = GetHuespedes();
		huespedes.put(huesped.getNumero(), huesped);
		FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoHuespedes.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(huespedes); 
		objectOutputStream.close();
	}
	
	
	// Funciones para escribir informacion en archivos ADMINISTRADOR DE USUARIOS
	
	
	public void GuardarUsuario (String usuario, String contraseña) {
		//guarda usuario en archivo si no existe
		HashMap<String, String> usuarios = GetUsuarios();
		usuarios.put(usuario, contraseña);
		
	}
	
	
	// Funciones para escribir informacion en archivos SISTEMA DE SERVICIOS
	
	public void GuardarServicio(Servicio servicio) throws IOException, ClassNotFoundException {
		HashMap<String, Servicio> servicios = GetServicios();
		servicios.put(servicio.getNombreServicio(), servicio);
		FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoServicios.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(servicios); 
		objectOutputStream.close();
		
	}
	
	public void GuardarProductoMenu(Producto producto) throws IOException, ClassNotFoundException {
		HashMap<String, Producto> menu = GetMenu();
		menu.put(producto.getNombre(), producto);
		FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoMenu.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(menu); 
		objectOutputStream.close();
		
	}
	
	
		
	public void EliminarHabitacion(int numeroHabitacion) throws IOException, ClassNotFoundException{
		HashMap<Integer, Habitacion> inventario = GetInventario();
		inventario.remove(numeroHabitacion) ;
		FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoInventario.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(inventario); 
		objectOutputStream.close();
	}
	*/
}
