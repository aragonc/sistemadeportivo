package beans;

public class DisciplinaDTO {
	private int codigo;
	private String nombre;
	private String fregistro;
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
	public DisciplinaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DisciplinaDTO(int codigo, String nombre, String fregistro, int estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fregistro = fregistro;
		this.estado = estado;
	}
	
}
