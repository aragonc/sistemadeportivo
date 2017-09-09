package beans;

public class Disciplina {
	private int codigo;
	private String nombre;
	private String descripcion;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public Disciplina(int codigo, String nombre, String descripcion, String fregistro, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fregistro = fregistro;
		this.estado = estado;
	}
	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}
}
