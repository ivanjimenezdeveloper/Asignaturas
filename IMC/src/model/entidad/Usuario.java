package model.entidad;

public class Usuario {
	
	private String correo, nombre, pass, imagen;
	private UsuarioKey key;
	
	
	public Usuario() {
		super();
	}
	public Usuario(String correo, String nombre, String pass,String imagen, UsuarioKey key) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.pass = pass;
		this.imagen = imagen;
		this.key = key;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public UsuarioKey getKey() {
		return key;
	}
	public void setKey(UsuarioKey key) {
		this.key = key;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	

}
