package entidad;

public class Juego {
	
	private int id,idGenero,idPlataforma, anyo;
	private String titulo,img,descripcion;
	public Juego(int id, int idGenero, int idPlataforma, int anyo, String titulo, String img, String descripcion) {
		super();
		this.id = id;
		this.idGenero = idGenero;
		this.idPlataforma = idPlataforma;
		this.anyo = anyo;
		this.titulo = titulo;
		this.img = img;
		this.descripcion = descripcion;
	}
	
	
	public Juego() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public int getIdPlataforma() {
		return idPlataforma;
	}
	public void setIdPlataforma(int idPlataforma) {
		this.idPlataforma = idPlataforma;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	

}
