package beans;

import java.util.Date;

public class DelegadoDTO extends PersonaDTO{
	private int codequipo;

	public int getCodequipo() {
		return codequipo;
	}

	public void setCodequipo(int codequipo) {
		this.codequipo = codequipo;
	}

	public DelegadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DelegadoDTO(int codigo, String nombre, String apaterno, String amaterno, int sexo, int tipodocumento,
			String numdocumento, Date fnacimiento, String email, String fono, String movil, int estado,
			int codequipo) {
		super(codigo, nombre, apaterno, amaterno, sexo, tipodocumento, numdocumento, fnacimiento, email, fono, movil,
				estado);
		this.codequipo = codequipo;
	}

	
	
}
