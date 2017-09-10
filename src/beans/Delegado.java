package beans;

public class Delegado extends PersonaDTO{
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

	public Delegado(int codigo, String nombre, String apaterno, String amaterno, int sexo, int tipodocumento,
			String numdocumento, String fnacimiento, String email, String fono, String movil, int estado,
			int codequipo) {
		super(codigo, nombre, apaterno, amaterno, sexo, tipodocumento, numdocumento, fnacimiento, email, fono, movil,
				estado);
		this.codequipo = codequipo;
	}

	
	
}
