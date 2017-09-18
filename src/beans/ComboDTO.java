package beans;

public class ComboDTO {
	private int codigo;
	private String tipo;
	private String field;
	private String valor;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public ComboDTO(int codigo, String tipo, String field, String valor) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.field = field;
		this.valor = valor;
	}
	public ComboDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
