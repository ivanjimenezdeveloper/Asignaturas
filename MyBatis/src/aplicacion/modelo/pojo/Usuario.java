package aplicacion.modelo.pojo;

/**
 * Classe para almacenar la información de un usuario
 * @author daw
 *
 */
public class Usuario {
	private Integer id;
	private String nombre;
	private String usuario;
	private String password;
	
	/**
	 * Constructor por defecto.
	 */
	public Usuario() {	
	}
	
	/**
	 * Constructor que inicializa la informción de un usuario
	 * @param id Identificador del usuario
	 * @param nombre Nombre del usuario
	 * @param usuario Usuario que tiene el usuario
	 * @param password Password del usuario
	 */
	public Usuario(Integer id, String nombre, String usuario, String password) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
	}

	/**
	 * Obtiene el identificador de un usuario
	 * @return El identificador del usuario
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el identificador de un usuario
	 * @param id El identificador de un usuario
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de un usuario
	 * @return El nombre de un usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establecce el nombre de un usuario
	 * @param nombre El nombre de un usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el usuario de un usuario
	 * @return El usuario de un usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece el usuario de un usuario
	 * @param usuario El usuario de un usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene el password de un usuario
	 * @return El password de un usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece el password de un usuario
	 * @param password El password de un usuario
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
