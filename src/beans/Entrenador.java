package beans;

public class Entrenador extends Persona{
	private String numlicencia;
	private int categoria;
	private String fvencimiento;
	
	public String getNumlicencia() {
		return numlicencia;
	}
	public void setNumlicencia(String numlicencia) {
		this.numlicencia = numlicencia;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getFvencimiento() {
		return fvencimiento;
	}
	public void setFvencimiento(String fvencimiento) {
		this.fvencimiento = fvencimiento;
	}
	public Entrenador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
