package beans;

import java.util.Date;
import java.util.List;

public class EquipoDTO {
	
	private int codigo;
	private String nombre;
	private String descripcion;
	private String logo;
	private String color;
	private int codEvento;
	private EventoDTO evento;
	private int codModalidad;
	private ModalidadDTO modalidad;
	private List<PersonaDTO> jugadores;
	private Date fregistro;
	private int estado;
	
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

	public int getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(int codEvento) {
		this.codEvento = codEvento;
	}

	public EventoDTO getEvento() {
		return evento;
	}

	public void setEvento(EventoDTO evento) {
		this.evento = evento;
	}

	public int getCodModalidad() {
		return codModalidad;
	}

	public void setCodModalidad(int codModalidad) {
		this.codModalidad = codModalidad;
	}

	public ModalidadDTO getModalidad() {
		return modalidad;
	}

	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
	}

	public List<PersonaDTO> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<PersonaDTO> jugadores) {
		this.jugadores = jugadores;
	}

	public Date getFregistro() {
		return fregistro;
	}

	public void setFregistro(Date fregistro) {
		this.fregistro = fregistro;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
