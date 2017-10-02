package beans;

public class ModalidadDTO {
	private int codEvento;
	private int codDisciplina;
	private int codCategoria;
	
	public int getCodEvento() {
		return codEvento;
	}
	public void setCodEvento(int codEvento) {
		this.codEvento = codEvento;
	}
	public int getCodDisciplina() {
		return codDisciplina;
	}
	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	public int getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}
	public ModalidadDTO(int codEvento, int codDisciplina, int codCategoria) {
		super();
		this.codEvento = codEvento;
		this.codDisciplina = codDisciplina;
		this.codCategoria = codCategoria;
	}
	public ModalidadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
