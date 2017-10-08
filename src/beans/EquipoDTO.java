package beans;

import java.util.List;

public class EquipoDTO {
	
	private int codigo;
	private String nombre;
	private String logo;
	private String email;
	private String fono;
	private String color;
	private int estado;
	private List<PersonaDTO> jugadores;
	private int codModalidad;
	private ModalidadDTO modalidad;
	
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<PersonaDTO> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<PersonaDTO> jugadores) {
		this.jugadores = jugadores;
	}

	public ModalidadDTO getModalidad() {
		return modalidad;
	}

	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
	}

	public int getCodModalidad() {
		return codModalidad;
	}

	public void setCodModalidad(int codModalidad) {
		this.codModalidad = codModalidad;
	}

	public EquipoDTO(int codigo, String nombre, String logo, String email, String fono, String color, int estado,
			List<PersonaDTO> jugadores, int codModalidad, ModalidadDTO modalidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.logo = logo;
		this.email = email;
		this.fono = fono;
		this.color = color;
		this.estado = estado;
		this.jugadores = jugadores;
		this.codModalidad = codModalidad;
		this.modalidad = modalidad;
	}

	
	
	
}
