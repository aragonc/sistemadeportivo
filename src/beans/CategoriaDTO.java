package beans;

public class CategoriaDTO {
	private int codigo;
	private String nombre;
	private String genero;
	private int cantidad;
	private String fregistro;
	private int estado;

	public CategoriaDTO() {
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFregistro() {
		return fregistro;
	}

	public void setFregistro(String fregistro) {
		this.fregistro = fregistro;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public CategoriaDTO(int codigo, String nombre, String genero, int cantidad, String fregistro, int estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.cantidad = cantidad;
		this.fregistro = fregistro;
		this.estado = estado;
	}
	
}
