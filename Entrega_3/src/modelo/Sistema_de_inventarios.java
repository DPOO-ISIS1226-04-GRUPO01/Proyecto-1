package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Sistema_de_inventarios implements Serializable{


	
		public static void Crear_Tarifa(String tipo, Date fecha_inicial, Date fecha_final, ArrayList<Integer> dias, BaseDatos BD, int precio) throws ClassNotFoundException, IOException {
			Tarifa tarifa = new Tarifa(tipo, fecha_inicial,fecha_final, dias, precio);
			BD.GuardarObjeto(tarifa);
	}

}
