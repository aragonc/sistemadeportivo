package beans;

public class Jugador extends Persona {
	private int numjugador;
	private Double estatura;
	private Double peso;
	private String tiposangre;
	private int codequipo;
	private int tipo;
	public int getNumjugador() {
		return numjugador;
	}
	public void setNumjugador(int numjugador) {
		this.numjugador = numjugador;
	}
	public Double getEstatura() {
		return estatura;
	}
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public String getTiposangre() {
		return tiposangre;
	}
	public void setTiposangre(String tiposangre) {
		this.tiposangre = tiposangre;
	}
	public int getCodequipo() {
		return codequipo;
	}
	public void setCodequipo(int codequipo) {
		this.codequipo = codequipo;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jugador(int codigo, String nombre, String apaterno, String amaterno, int sexo, String dni,
			String fnacimiento, String email, String fono, String movil, Boolean estado) {
		super(codigo, nombre, apaterno, amaterno, sexo, dni, fnacimiento, email, fono, movil, estado);
		// TODO Auto-generated constructor stub
	}
	
	
}
