package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel implements Serializable{

	private HashMap<Integer, Habitacion> Inventario; 
	
	private HashMap<String, String> Usuarios;
	
	private ArrayList<Huesped> Huespedes;
	
	private HashMap<Integer, ArrayList<Consumo>> Consumos;
	
	private BaseDatos Administrador_BD;
	
	
	public Hotel() {
		this.Inventario = null;
		this.Usuarios = null;
		this.Huespedes = null;
		this.Consumos = null;
		this.Administrador_BD = new BaseDatos();
	}
	
	
	public void setInventario(){
		//Cargar archivo binario
	}
	
	public void setUsuarios(){
		//Cargar archivo binario
	}
	
	public void setHuespedes(){
		//Cargar archivo binario
	}
	
	public void setConsumos(){
		//Cargar archivo binario
	}
	
	
	
	
	
	
	
	
	
	
	public HashMap<Integer, Habitacion> getInventario() throws ClassNotFoundException, IOException{
		return Administrador_BD.GetInventario();
	}
	
	public HashMap<String, String> getUsuarios(){
		return Administrador_BD.GetUsuarios();
	}
	
	public HashMap<Integer, Huesped> getHuespedes() throws ClassNotFoundException, IOException{
		return Administrador_BD.GetHuespedes();
	}
	
	public void getConsumos(){
		
	}
	
	public BaseDatos getBD(){
		return Administrador_BD;
	}
	
	
	public void crearHabitacion(int precio, int numero) throws IOException, ClassNotFoundException
	{
		Habitacion objeto = new Habitacion(precio, numero);
		
	}
	
	public void eliminarObjeto(int numeroHabitacion) throws ClassNotFoundException, IOException {
		Class<Habitacion> clase = Habitacion.class;
		Administrador_BD.EliminarObjeto(numeroHabitacion, clase);
		
	}
	
	
	public void GuardarrObjeto(int precio, int numero) throws ClassNotFoundException, IOException {
		Habitacion objeto = new Habitacion(precio, numero);
		Administrador_BD.GuardarObjeto(objeto);
	}
	
	
	
}
