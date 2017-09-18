package beans;

import java.util.Date;

public class PersonaDTO {
	private int codigo;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private int sexo;
	private int tipodocumento;
	private String numdocumento;
	private Date fnacimiento;
	private String email;
	private String fono;
	private String movil;
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
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public String getNumdocumento() {
		return numdocumento;
	}
	public void setNumdocumento(String dni) {
		this.numdocumento = dni;
	}
	public Date getFnacimiento() {
		return fnacimiento;
	}
	public void setFnacimiento(Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFono() {
		return fono;
	}
	public void setFono(String fono) {
		this.fono = fono;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getTipodocumento() {
		return tipodocumento;
	}
	public void setTipodocumento(int tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public PersonaDTO(int codigo, String nombre, String apaterno, String amaterno, int sexo, int tipodocumento,
			String numdocumento, Date fnacimiento, String email, String fono, String movil, int estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.sexo = sexo;
		this.tipodocumento = tipodocumento;
		this.numdocumento = numdocumento;
		this.fnacimiento = fnacimiento;
		this.email = email;
		this.fono = fono;
		this.movil = movil;
		this.estado = estado;
	}
	public PersonaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
