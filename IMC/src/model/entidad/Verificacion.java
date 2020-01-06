package model.entidad;

public class Verificacion {
	
	private UsuarioKey usKey;
	private Integer codigo;
	Boolean verificado;
	public Verificacion(UsuarioKey usKey, Integer codigo, Boolean verificado) {
		super();
		this.usKey = usKey;
		this.codigo = codigo;
		this.verificado = verificado;
	}
	
	
	
	public Verificacion() {
		super();
	}



	public UsuarioKey getUsKey() {
		return usKey;
	}
	public void setUsKey(UsuarioKey usKey) {
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
