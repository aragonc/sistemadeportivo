package beans;

public class Persona {
	private int codigo;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private int sexo;
	private String dni;
	private String fnacimiento;
	private String email;
	private String fono;
	private String movil;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFnacimiento() {
		return fnacimiento;
	}
	public void setFnacimiento(String fnacimiento) {
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
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Persona(int codigo, String nombre, String apaterno, String amaterno, int sexo, String dni,
			String fnacimiento, String email, String fono, String movil, Boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.sexo = sexo;
		this.dni = dni;
		this.fnacimiento = fnacimiento;
		this.email = email;
		this.fono = fono;
		this.movil = movil;
		this.estado = estado;
	}
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
}
