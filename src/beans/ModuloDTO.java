package beans;

public class ModuloDTO {
	private int codigo;
	private String nombre;
	private String url;
	private String iconbing;
	private String iconsmall;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconbing() {
		return iconbing;
	}
	public void setIconbing(String iconbing) {
		this.iconbing = iconbing;
	}
	public String getIconsmall() {
		return iconsmall;
	}
	public void setIconsmall(String iconsmall) {
		this.iconsmall = iconsmall;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public ModuloDTO(int codigo, String nombre, String url, String iconbing, String iconsmall, int estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.url = url;
		this.iconbing = iconbing;
		this.iconsmall = iconsmall;
		this.estado = estado;
	}
	public ModuloDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
