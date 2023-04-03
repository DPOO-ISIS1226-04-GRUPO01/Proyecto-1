package modelo.inventario_y_BD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Date;
import java.util.Calendar;

import modelo.reservas_y_registro.Cliente;
import modelo.reservas_y_registro.Reserva;
import modelo.servicios_y_consumo.Consumo;
import modelo.servicios_y_consumo.Servicio;
import modelo.servicios_y_consumo.Producto;

public class BaseDatos implements Serializable {
	
	private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
	
	
	public BaseDatos() {
		
	}
	
	// Funciones de creación de archivos
	
	public void CrearArchivoInventario() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoInventario.txt");
	    if (file.createNewFile()) {
	    FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoInventario.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(new HashMap<Integer, Habitacion>()); 
		objectOutputStream.close();
	    }
	   
	    
	    }
	   

	public void CrearArchivoUsuarios() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoUsuarios.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoUsuarios.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<String, String>()); 
			objectOutputStream.close();
		}
	}
	

	public void CrearArchivoClientes() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoClientes.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoClientes.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<Integer, Cliente>()); 
			objectOutputStream.close();
	}
	}
	

	public void CrearArchivoConsumos() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoConsumos.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoConsumos.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<Integer, ArrayList<Consumo>>()); 
			objectOutputStream.close();
		}
	}
	
	public void CrearArchivoReservas() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoReservas.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoReservas.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<Date, Reserva>()); 
			objectOutputStream.close();
		}
	}
	
	public void CrearArchivoServicios() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoServicios.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoServicios.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<String, Servicio>()); 
			objectOutputStream.close();
		}
	}
	
	public void CrearArchivoMenu() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoMenu.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoMenu.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<String, Producto>()); 
			objectOutputStream.close();
		}
	}
	
	// Métodos creación archivos reservas y registro
	
	public void CrearArchivoOcupacion() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoOcupacion.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoOcupacion.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new HashMap<Date, ArrayList<Integer> >()); 
			objectOutputStream.close();
		}
	}
	
	public void CrearArchivoTarifa() throws IOException {
		//crea archivo si no existe
		File file = new File("./data/ArchivoTarifa.txt");
		if (file.createNewFile()) {
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoTarifa.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new ArrayList<HashMap<Date, Integer>>()); 
			objectOutputStream.close();
		}
	}
	

	
// Funcion para guardar un objeto en un archivo según la clase del objeto
	
	
	public void GuardarObjeto (Object objeto) throws ClassNotFoundException, IOException {
		//guarda Cliente en archivo si no existe
		Class<?> clase = objeto.getClass();
		if (clase.equals(Habitacion.class)){
			Habitacion New = (Habitacion) objeto;
			HashMap<Integer, Habitacion> inventario = GetInventario();
			inventario.put(New.getNumero(), New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoInventario.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(inventario); 
			objectOutputStream.close();
		}
		else if(clase.equals(Consumo.class)) {
			Consumo New = (Consumo) objeto;
			HashMap<Integer, ArrayList<Consumo>> clientes = GetConsumos();
			ArrayList<Consumo> listaconsumos = clientes.get(New.GetNumero());
			listaconsumos.add(New);
			clientes.put(New.GetNumero(), listaconsumos);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoConsumos.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(clientes); 
			objectOutputStream.close();
		}
		else if(clase.equals(Cliente.class)) {
			Cliente New = (Cliente) objeto;
			HashMap<Integer, Cliente> clientes = GetClientes();
			clientes.put(New.getNumero(), New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoClientes.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(clientes); 
			objectOutputStream.close();
		}
		else if (clase.equals(Producto.class)) {
			Producto New = (Producto) objeto;
			HashMap<String, Producto> menu = GetMenu();
			menu.put(New.getNombre(), New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoMenu.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(menu); 
			objectOutputStream.close();
		}
		else if (clase.equals(Reserva.class)) {
			Reserva New = (Reserva) objeto;
			HashMap<Date, Reserva> reservas = GetReservas();
			reservas.put(New.getId_reserva() , New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoReservas.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(reservas); 
			objectOutputStream.close();
			
			
			// Modificar archivo ocupaciones
			
			HashMap<Date, ArrayList<Integer> > Mapa_Ocupacion = GetOcupacion();
			HashMap<Integer, Habitacion> Mapa_Inventario = GetInventario();

			//archvo habitaciones
			Date fecha_final = New.getFecha_Final();
			Date iterador_fecha = New.getFecha_Inicio();
			
			
			
			// agregar id_habitacion a ocupadas en las fechas de la reserva
			
			while (iterador_fecha.compareTo(fecha_final) < 0 || iterador_fecha.compareTo(fecha_final)==0) {
			  
			// si la fecha no existe
			if(Mapa_Ocupacion.get(iterador_fecha) == null) {

				ArrayList<Integer> Lista_Habitaciones_Desocupadas = new ArrayList<>(Mapa_Inventario.keySet());			
				
				ArrayList<Integer> Habitaciones = New.getHabitaciones();
				
				for(int i = 0; i < Habitaciones.size(); i++) {
					Lista_Habitaciones_Desocupadas.remove(Habitaciones.get(i));
					Habitacion habitacion = Mapa_Inventario.get(Habitaciones.get(i));
					habitacion.Actualizar_fechas_ocupacion(New.getFecha_Inicio(), New.getFecha_Final(), New.getId_reserva());
					Mapa_Inventario.put(Habitaciones.get(i),habitacion);
				}
				
				Mapa_Ocupacion.put(iterador_fecha, Lista_Habitaciones_Desocupadas);
			}
			
			// si la fecha ya existe
			else {
				ArrayList<Integer> Lista_Habitaciones_Desocupadas = Mapa_Ocupacion.get(iterador_fecha);
				
				ArrayList<Integer> Habitaciones = New.getHabitaciones();
				
				for(int i = 0; i < Habitaciones.size(); i++) {
					Lista_Habitaciones_Desocupadas.remove(Habitaciones.get(i));
					Habitacion habitacion = Mapa_Inventario.get(Habitaciones.get(i));
					habitacion.Actualizar_fechas_ocupacion(New.getFecha_Inicio(), New.getFecha_Final(), New.getId_reserva());
					Mapa_Inventario.put(Habitaciones.get(i),habitacion);
				}
				
				Mapa_Ocupacion.put(iterador_fecha , Lista_Habitaciones_Desocupadas);							
			
			}
			
			// escribir sobre el archivo ocupacion
			
			FileOutputStream fileOutputStream1 = new FileOutputStream("./data/ArchivoOcupacion.txt");
			ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
			objectOutputStream1.writeObject(Mapa_Ocupacion); 
			objectOutputStream1.close();
			
			//escribir sobre el archivo inventario
			
			FileOutputStream fileOutputStream2 = new FileOutputStream("./data/ArchivoInventario.txt");
			ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
			objectOutputStream2.writeObject(Mapa_Inventario); 
			objectOutputStream2.close();

			// avance
			  iterador_fecha = getNextDay(iterador_fecha);
			}
				
			
		}
		else if (clase.equals(Servicio.class)) {
			Servicio New = (Servicio) objeto;
			HashMap<String, Servicio> servicios = GetServicios();
			servicios.put(New.getNombreServicio(), New);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoServicios.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(servicios); 
			objectOutputStream.close();
		}
		else if (clase.equals(Tarifa.class)){
			Tarifa New = (Tarifa) objeto;
			ArrayList<HashMap<Date, Integer>> tarifas = GetTarifa();
			
			if (tarifas.size() == 0) {
				HashMap<Date, Integer> mapa_precio = new HashMap<Date, Integer>();
				tarifas.add(mapa_precio);
				tarifas.add(mapa_precio);
				tarifas.add(mapa_precio);	
				
			}
			
			Date fecha_final = New.getfecha_final();
			Date iterador_fecha = New.getfecha_inicio();
			
			int index = -1;
			
			if (New.gettipo() == "Estadar") {
				index = 0;
			} else if (New.gettipo() == "Suite") {
				index = 1;
			} else if (New.gettipo() == "Suite doble") {
				index = 2;
			}
			
			int precio = New.getprecio();
			ArrayList<Integer> dias = New.getdias_de_la_semana();
			
			Calendar cal = Calendar.getInstance();
			
			
			while (iterador_fecha.compareTo(fecha_final) < 0 || iterador_fecha.compareTo(fecha_final)==0) {
				// si la fecha no existe
				cal.setTime(iterador_fecha);	
				if ( dias.contains(cal.get(Calendar.DAY_OF_WEEK))) {
				
					HashMap<Date, Integer> MapaTarifas = tarifas.get(index);
				
				if(MapaTarifas.get(iterador_fecha) == null) {
					MapaTarifas.put(iterador_fecha, precio);
					
				} else {
					int precio_actual = MapaTarifas.get(iterador_fecha);
					
					if (precio_actual > precio) {
						MapaTarifas.put(iterador_fecha, precio);}}
				}
				iterador_fecha = getNextDay(iterador_fecha);
			
			}	
			
			
			
			
			
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoTarifa.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(tarifas); 
			objectOutputStream.close();
			}

		
	}
	
	
	
	
	// Funciones para obtener informacion de archivos SISTEMA DE INVENTARIOS
	
	
	public HashMap<Integer,Habitacion> GetInventario () throws IOException, ClassNotFoundException {
		//busca el inventario si existe
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoInventario.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<Integer, Habitacion> inventario = (HashMap) objectInputStream.readObject();
		objectInputStream.close();
		return inventario;
		
	}
			
	
	// Funciones para obtener informacion de archivos SISTEMA DE REGISTROS DE CONSUMO
	
	
	public HashMap<Integer, ArrayList<Consumo>> GetConsumos() throws IOException, ClassNotFoundException {
		//busca los consumos por Cliente si existen 
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoConsumos.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<Integer, ArrayList<Consumo>> consumos = (HashMap) objectInputStream.readObject();
		objectInputStream.close();
		return consumos;
	}
	
	
	// Funciones para obtener informacion de archivos SISTEMA DE RESERVAS Y REGISTRO
		
	public HashMap<Date, Reserva> GetReservas() throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoReservas.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<Date, Reserva> reservas = (HashMap) objectInputStream.readObject();
		objectInputStream.close();
		return reservas;
	}
	
	
		public HashMap<Integer, Cliente> GetClientes () throws IOException, ClassNotFoundException {
		//busca la informacion de los Clientes si existe
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoClientes.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<Integer, Cliente> clientes = (HashMap) objectInputStream.readObject();
		objectInputStream.close();
		return clientes;
	}		
		
		public HashMap<Date, ArrayList<Integer> > GetOcupacion () throws IOException, ClassNotFoundException {
			//busca la informacion de la Ocupacin si existe
			FileInputStream fileInputStream = new FileInputStream("./data/ArchivoOcupacion.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			HashMap<Date, ArrayList<Integer> > ocupacion = (HashMap) objectInputStream.readObject();
			objectInputStream.close();
			return ocupacion;
		}
	
	// Funciones para obtener informacion de archivos ADMINISTRADOR DE USUARIOS
	
	
	public HashMap<String, String> GetUsuarios () {
		return null;
		//busca el mapa de usuarios si existe
	}
	

	// Funciones para obtener informacion de archivos SISTEMA DE SERVICIOS
	
	
	public HashMap<String, Servicio> GetServicios() throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoServicios.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<String, Servicio> servicios = (HashMap) objectInputStream.readObject();
		objectInputStream.close();
		return servicios;
	}

	
	public HashMap<String, Producto> GetMenu() throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoMenu.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HashMap<String, Producto> menu = (HashMap) objectInputStream.readObject();
		objectInputStream.close();
		return menu;
	}
	
	public  ArrayList<HashMap<Date, Integer>> GetTarifa() throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream("./data/ArchivoTarifa.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		ArrayList<HashMap<Date, Integer>> tarifa = (ArrayList) objectInputStream.readObject();
		objectInputStream.close();
		return tarifa;
	}
	

	
	
	public void EliminarObjeto(Object objeto, Class<?> clase) throws IOException, ClassNotFoundException {
		if (clase.equals(Habitacion.class)) {
			int numeroHabitacion = (int) objeto;
			HashMap<Integer, Habitacion> inventario = GetInventario();
			inventario.remove(numeroHabitacion) ;
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoInventario.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(inventario); 
			objectOutputStream.close();
		}
		else if (clase.equals(Consumo.class)) {
			int numeroHabitacion = (int) objeto;
			HashMap<Integer, ArrayList<Consumo>> consumos =  GetConsumos();
			consumos.remove(numeroHabitacion);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoConsumos.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(consumos); 
			objectOutputStream.close();
		}
		else if (clase.equals(Cliente.class)) {
			int numeroHabitacion = (int) objeto;
			HashMap<Integer, Cliente> clientes = GetClientes();
			clientes.remove(numeroHabitacion);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoClientes.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(clientes); 
			objectOutputStream.close();	
		}
		else if (clase.equals(Producto.class)) {
			String nombreProducto = (String) objeto;
			HashMap<String, Producto> menu = GetMenu();
			menu.remove(nombreProducto);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoMenu.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(menu); 
			objectOutputStream.close();
		}
		else if (clase.equals(Reserva.class)) {
			Date id_Reserva = (Date) objeto;
			HashMap<Date, Reserva> reservas = GetReservas();
			reservas.remove(id_Reserva);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoReservas.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(reservas); 
			objectOutputStream.close();
		}
		else if (clase.equals(Servicio.class)) {
			String nombreServicio = (String) objeto;
			HashMap<String, Servicio> servicios = GetServicios();
			servicios.remove(nombreServicio);
			FileOutputStream fileOutputStream = new FileOutputStream("./data/ArchivoServicios.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(servicios); 
			objectOutputStream.close();
		}
		
	}
	
	
	public void AbrirRegistroConsumo(int numeroHabitacion) throws ClassNotFoundException, IOException {
		HashMap<Integer, ArrayList<Consumo>> consumos = GetConsumos();
		consumos.put(numeroHabitacion, new ArrayList<>());
		
	}
	
	
	
	public void EditarServicio(String nombreServicio, int nuevoPrecio) throws ClassNotFoundException, IOException {
		HashMap<String, Servicio> servicios= GetServicios();
		Servicio servicio = servicios.get(nombreServicio);
		servicio.setPrecio(nuevoPrecio);
		GuardarObjeto(servicio);
		
		
	}
	
	public void EditarProducto(String nombreProducto, int nuevoPrecio) throws ClassNotFoundException, IOException {
		HashMap<String, Producto> productos= GetMenu();
		Producto producto = productos.get(nombreProducto);
		producto.setPrecio(nuevoPrecio);
		GuardarObjeto(producto);
	}
	
	private static Date getNextDay(Date date)
	{
	  return new Date(date.getTime() + MILLIS_IN_A_DAY);
	}
	

		
	
	
}
