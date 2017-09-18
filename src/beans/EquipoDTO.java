package beans;

public class EquipoDTO {
	
	private int codigo;
	private String nombre;
	private String logo;
	private String color;
	private String fregistro;
	private String email;
	private String fono;
	private int estado;
	private int iddisciplina;
	private int idcategoria;
	private DelegadoDTO delegadoDTO;
	
	public EquipoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getFregistro() {
		return fregistro;
	}
	
	public void setFregistro(String fregistro) {
		this.fregistro = fregistro;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFono() {
		return fono;
	}
	
	public void setFono(String fono) {
		this.fono = fono;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public int getIddisciplina() {
		return iddisciplina;
	}
	public void setIddisciplina(int iddisciplina) {
		this.iddisciplina = iddisciplina;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public DelegadoDTO getDelegado() {
		return delegadoDTO;
	}
	
	public void setDelegado(DelegadoDTO delegadoDTO) {
		this.delegadoDTO = delegadoDTO;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public DelegadoDTO getDelegadoDTO() {
		return delegadoDTO;
	}
	public void setDelegadoDTO(DelegadoDTO delegadoDTO) {
		this.delegadoDTO = delegadoDTO;
	}
	public EquipoDTO(int codigo, String nombre, String logo, String color, String fregistro, String email, String fono,
			int estado, int iddisciplina, int idcategoria, DelegadoDTO delegadoDTO) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.logo = logo;
		this.color = color;
		this.fregistro = fregistro;
		this.email = email;
		this.fono = fono;
		this.estado = estado;
		this.iddisciplina = iddisciplina;
		this.idcategoria = idcategoria;
		this.delegadoDTO = delegadoDTO;
	}
}
