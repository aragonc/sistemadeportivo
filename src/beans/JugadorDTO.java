package beans;

import java.util.Date;

public class JugadorDTO extends PersonaDTO {
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
	public JugadorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JugadorDTO(int codigo, String nombre, String apaterno, String amaterno, int sexo, int tipodocumento,
			String numdocumento, Date fnacimiento, String email, String fono, String movil, int estado,
			int numjugador, Double estatura, Double peso, String tiposangre, int codequipo, int tipo) {
		super(codigo, nombre, apaterno, amaterno, sexo, tipodocumento, numdocumento, fnacimiento, email, fono, movil,
				estado);
		this.numjugador = numjugador;
		this.estatura = estatura;
		this.peso = peso;
		this.tiposangre = tiposangre;
		this.codequipo = codequipo;
		this.tipo = tipo;
	}
	
	
	
}
