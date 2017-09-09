package beans;

public class Delegado extends Persona{
	private int codequipo;

	public int getCodequipo() {
		return codequipo;
	}

	public void setCodequipo(int codequipo) {
		this.codequipo = codequipo;
	}

	public Delegado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delegado(int codigo, String nombre, String apaterno, String amaterno, int sexo, String dni,
			String fnacimiento, String email, String fono, String movil, Boolean estado) {
		super(codigo, nombre, apaterno, amaterno, sexo, dni, fnacimiento, email, fono, movil, estado);
		// TODO Auto-generated constructor stub
	}
	
}
