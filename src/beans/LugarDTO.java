package beans;

public class LugarDTO {
	private int codigo;
	private String nombre;
	private String direccion;
	private String longitud;
	private String latitud;
	private int estado;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public LugarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LugarDTO(int codigo, String nombre, String direccion, String longitud, String latitud, int estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.longitud = longitud;
		this.latitud = latitud;
		this.estado = estado;
	}
	
	
}
