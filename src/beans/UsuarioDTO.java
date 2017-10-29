package beans;

public class UsuarioDTO {
	public int codigo;
	public String usuario;
	public String password;
	public int codpersona;
	public int perfil;
	public PersonaDTO persona;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCodpersona() {
		return codpersona;
	}
	public void setCodpersona(int codpersona) {
		this.codpersona = codpersona;
	}
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	public int getPerfil() {
		return perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	
	public UsuarioDTO(int codigo, String usuario, String password, int codpersona, int perfil,
			PersonaDTO persona) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.password = password;
		this.codpersona = codpersona;
		this.perfil = perfil;
		this.persona = persona;
	}
	
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
