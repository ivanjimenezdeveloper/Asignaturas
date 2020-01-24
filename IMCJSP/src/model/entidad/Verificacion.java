package model.entidad;

public class Verificacion {
	
	private int usKey;
	private Integer codigo;
	Boolean verificado;
	public Verificacion(int usKey, Integer codigo, Boolean verificado) {
		super();
		this.usKey = usKey;
		this.codigo = codigo;
		this.verificado = verificado;
	}
	
	
	
	public Verificacion() {
		super();
	}



	public int getUsKey() {
		return usKey;
	}
	public void setUsKey(int usKey) {
		this.usKey = usKey;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Boolean getVerificado() {
		return verificado;
	}
	public void setVerificado(Boolean verificado) {
		this.verificado = verificado;
	}
	
	

}
