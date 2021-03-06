package beans;

import java.util.List;

public class UsuarioDTO {
	public int codigo;
	public String usuario;
	public String password;
	public int codpersona;
	public int codperfil;
	public PerfilDTO perfil;
	public PersonaDTO persona;
	private List<ModuloDTO> modulo;
	
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
	public PerfilDTO getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}
		
	public int getCodperfil() {
		return codperfil;
	}
	public void setCodperfil(int codperfil) {
		this.codperfil = codperfil;
	}
	
	public List<ModuloDTO> getModulo() {
		return modulo;
	}
	
	public void setModulo(List<ModuloDTO> modulo) {
		this.modulo = modulo;
	}
	
	
	public UsuarioDTO(int codigo, String usuario, String password, int codpersona, int codperfil, PerfilDTO perfil,
			PersonaDTO persona, List<ModuloDTO> modulo) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.password = password;
		this.codpersona = codpersona;
		this.codperfil = codperfil;
		this.perfil = perfil;
		this.persona = persona;
		this.modulo = modulo;
	}
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
