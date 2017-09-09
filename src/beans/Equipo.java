package beans;

public class Equipo {
	
	private int codigo;
	private String nombre;
	private String logo;
	private String direccion;
	private String fregistro;
	private String email;
	private String fono;
	private Boolean estado;
	private Entrenador entrenador;
	private Delegado delegado;
	
	public Equipo() {
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
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	
	public Boolean getEstado() {
		return estado;
	}
	
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public Entrenador getEntrenador() {
		return entrenador;
	}
	
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	
	public Delegado getDelegado() {
		return delegado;
	}
	
	public void setDelegado(Delegado delegado) {
		this.delegado = delegado;
	}
}
