
public class Usuario {

	private int id;
	private String nombre;
	private String Usuario;
	private String pass;
	private String nombreFoto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public Usuario() {

	}

	public Usuario(int id, String nombre, String usuario, String pass, String nombreFoto) {
		super();
		this.id = id;
		this.nombre = nombre;
		Usuario = usuario;
		this.pass = pass;
		this.nombreFoto = nombreFoto;
	}

}
