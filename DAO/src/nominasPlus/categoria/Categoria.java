package nominasPlus.categoria;

public class Categoria {

	private CategoriaKey key;
	private String nom;
	public Categoria(CategoriaKey key, String nom) {
		super();
		this.key = key;
		this.nom = nom;
	}
	
	
	
	public Categoria() {
		super();
	}



	public CategoriaKey getKey() {
		return key;
	}
	public void setKey(CategoriaKey key) {
		this.key = key;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}



	@Override
	public String toString() {
		return "Categoria [key=" + key + ", nom=" + nom + "]";
	}
	
	
	
	
}
