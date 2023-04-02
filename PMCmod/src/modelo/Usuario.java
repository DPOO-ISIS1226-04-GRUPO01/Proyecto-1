package modelo;

import java.io.Serializable;

public class Usuario implements Serializable{

	private String nombreUsuario;
	
	private String contraseña;
	
	private String TipoUsuario;
	
	public Usuario(String usuario, String clave, String tipo) {
		this.nombreUsuario = usuario;
		this.contraseña = clave;
		this.TipoUsuario = tipo;
	}
	
	public String getNombre() {
		return nombreUsuario;
	}
	
	public String getClave() {
		return contraseña;
	}
	
	public String getTipo() {
		return TipoUsuario;
	}
}
