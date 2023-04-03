package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Tarifa {
	private String tipo;
	private Date fecha_inicio;
	private Date fecha_final;
	private ArrayList<Integer> dias_de_la_semana;
	private int precio;
	
	public Tarifa(String tipo, Date fecha_inicio, Date fecha_final, ArrayList<Integer> dias_de_la_semana, int precio) {
		this.tipo = tipo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.dias_de_la_semana = dias_de_la_semana;
		this.precio = precio;

	}
	
	public String gettipo() {
		return tipo;
	}
	
	public Date getfecha_inicio() {
		return fecha_inicio;
	}
	
	public Date getfecha_final() {
		return fecha_final;
	}
	
	public ArrayList<Integer> getdias_de_la_semana() {
		return dias_de_la_semana;
	}
	
	public int getprecio() {
		return precio;
	}

}