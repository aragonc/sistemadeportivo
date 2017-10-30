package beans;

public class PerfilDTO {
	private int codigo;
	private String nombre;
	
	
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

	public PerfilDTO(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public PerfilDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
