package modelo;

import java.io.IOException;
import java.util.HashMap;

public class Administrador_Usuarios {
	BaseDatos datos = new BaseDatos();
	
	public Administrador_Usuarios() {
		
	}
	
	
	public Boolean Crear_sesion(String nombreusuario, String clave, String tipo) throws ClassNotFoundException, IOException {
		HashMap <String, Usuario> usuarios = datos.GetUsuarios();
		if (usuarios.containsKey(nombreusuario)) {
			return false;
		}
		Usuario usuario = new Usuario(nombreusuario, clave, tipo);
		datos.GuardarObjeto(usuario);
		return true;
		
		
	}
	
	public Boolean Iniciar_sesion(String nombreusuario, String clave, String tipo ) throws ClassNotFoundException, IOException {
		HashMap <String, Usuario> usuarios = datos.GetUsuarios();
		Usuario almacenado = usuarios.get(nombreusuario);
		if (almacenado == null) 
			return false;
		
		if (nombreusuario.equals(almacenado.getNombre()) && clave.equals(almacenado.getClave()) && tipo.equals(almacenado.getTipo())) 
			return true;
		
		return false;	
		
	}
	
	
	public Boolean Eliminar_cuenta(String nombreusuario) throws ClassNotFoundException, IOException {
		HashMap<String, Usuario> usuarios = datos.GetUsuarios();
		if (usuarios.containsKey(nombreusuario)) {
			datos.EliminarObjeto(nombreusuario, Usuario.class);
			return true;
		}
		return false;
		
	}

}
