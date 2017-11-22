package beans;

import java.util.List;

public class EquipoDTO {
	
	private int codigo;
	private String nombre;
	private String descripcion;
	private String logo;
	private String color;
	private ModalidadDTO modalidad;
	private PersonaDTO delegado;
	private List<PersonaDTO> jugadores;
	private int estado;
	private EventoDTO evento;
	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public EventoDTO getEvento() {
		return evento;
	}

	public void setEvento(EventoDTO evento) {
		this.evento = evento;
	}

	public ModalidadDTO getModalidad() {
		return modalidad;
	}

	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
	}

	public PersonaDTO getDelegado() {
		return delegado;
	}

	public void setDelegado(PersonaDTO delegado) {
		this.delegado = delegado;
	}

	public List<PersonaDTO> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<PersonaDTO> jugadores) {
		this.jugadores = jugadores;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public EquipoDTO(int codigo, String nombre, String descripcion, String logo, String color, EventoDTO evento,
			ModalidadDTO modalidad, PersonaDTO delegado, List<PersonaDTO> jugadores, int estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.logo = logo;
		this.color = color;
		this.evento = evento;
		this.modalidad = modalidad;
		this.delegado = delegado;
		this.jugadores = jugadores;
		this.estado = estado;
	}
	
}
