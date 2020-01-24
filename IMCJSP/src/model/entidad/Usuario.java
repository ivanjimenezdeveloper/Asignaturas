package model.entidad;

/**
 * POJO de Usuario
 * @author HIBAN
 *
 */
public class Usuario {
	
	private String correo, nombre, pass, imagen;
	private Integer key;
	
	
	public Usuario() {
		super();
	}


	public Usuario(String correo, String nombre, String pass, String imagen, int key) {
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

	public void setID(int k) {
		this.key = k;
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


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public int getKey() {
		return key;
	}


	public void setKey(Integer key) {
		this.key = key;
	}

	
	
	

}
