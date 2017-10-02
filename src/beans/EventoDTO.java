package beans;

import java.util.Date;
import java.util.List;

public class EventoDTO {
	private int codigo;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private int estado;
	private double precio;
	private List<ModalidadDTO> listaModalidad;
	
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
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public List<ModalidadDTO> getListaModalidad() {
		return listaModalidad;
	}
	public void setListaModalidad(List<ModalidadDTO> listaModalidad) {
		this.listaModalidad = listaModalidad;
	}
	
	public EventoDTO(int codigo, String nombre, Date fechaInicio, Date fechaFin, int estado, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.precio = precio;
	}
	
	public EventoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
