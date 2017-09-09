package beans;

import java.util.Date;

public class equipo {
	
	private int codigo;
	private String nombre;
	private String logo;
	private String direccion;
	private String fregistro;
	private String email;
	private String fono;
	private Boolean estado;
	private Persona entrenador;
	private Persona delegado;
	
	
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
	public Persona getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Persona entrenador) {
		this.entrenador = entrenador;
	}
	public Persona getDelegado() {
		return delegado;
	}
	public void setDelegado(Persona delegado) {
		this.delegado = delegado;
	}
	public equipo(int codigo, String nombre, String logo, String direccion, String fregistro, String email, String fono,
			Boolean estado, Persona entrenador, Persona delegado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.logo = logo;
		this.direccion = direccion;
		this.fregistro = fregistro;
		this.email = email;
		this.fono = fono;
		this.estado = estado;
		this.entrenador = entrenador;
		this.delegado = delegado;
	}
	public equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
