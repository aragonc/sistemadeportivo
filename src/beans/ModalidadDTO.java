package beans;

public class ModalidadDTO {
	private int codEvento;
	private int codDisciplina;
	private int codCategoria;
	private CategoriaDTO categoria;
	private DisciplinaDTO disciplina;
	
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
	
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}
	public DisciplinaDTO getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaDTO disciplina) {
		this.disciplina = disciplina;
	}
	public ModalidadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModalidadDTO(int codEvento, int codDisciplina, int codCategoria, CategoriaDTO categoria,
			DisciplinaDTO disciplina) {
		super();
		this.codEvento = codEvento;
		this.codDisciplina = codDisciplina;
		this.codCategoria = codCategoria;
		this.categoria = categoria;
		this.disciplina = disciplina;
	}
	
}
