package beans;

public class Categoria {
	private int codigo;
	private String nombre;
	private int genero;
	private int edadmin;
	private int edadmax;
	private String fregistro;
	private Boolean estado;
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
	public int getGenero() {
		return genero;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	public int getEdadmin() {
		return edadmin;
	}
	public void setEdadmin(int edadmin) {
		this.edadmin = edadmin;
	}
	public int getEdadmax() {
		return edadmax;
	}
	public void setEdadmax(int edadmax) {
		this.edadmax = edadmax;
	}
	public String getFregistro() {
		return fregistro;
	}
	public void setFregistro(String fregistro) {
		this.fregistro = fregistro;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Categoria(int codigo, String nombre, int genero, int edadmin, int edadmax, String fregistro,
			Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.edadmin = edadmin;
		this.edadmax = edadmax;
		this.fregistro = fregistro;
		this.estado = estado;
	}
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
