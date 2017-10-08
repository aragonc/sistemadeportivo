package beans;

import java.util.Date;
import java.util.List;

public class EventoDTO {
	private int codigo;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private int estado;
	private double precio;
	private boolean gratuito;
	private List<ModalidadDTO> modalidades;
	private String lugar;
	private String longitud;
	private String latitud;
	
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
	public List<ModalidadDTO> getModalidades() {
		return modalidades;
	}
	public void setModalidades(List<ModalidadDTO> modalidades) {
		this.modalidades = modalidades;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean getGratuito() {
		return gratuito;
	}
	public void setGratuito(boolean gratuito) {
		this.gratuito = gratuito;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public EventoDTO(int codigo, String nombre, String descripcion, Date fechaInicio, Date fechaFin, int estado,
			double precio, boolean gratuito, List<ModalidadDTO> modalidades, String lugar, String longitud,
			String latitud) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.precio = precio;
		this.gratuito = gratuito;
		this.modalidades = modalidades;
		this.lugar = lugar;
		this.longitud = longitud;
		this.latitud = latitud;
	}
	
	public EventoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
