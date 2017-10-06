package beans;

public class ModalidadDTO {
	private int codigo;
	private int codDisciplina;
	private int codCategoria;
	private String descripcion;
	private CategoriaDTO categoria;
	private DisciplinaDTO disciplina;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ModalidadDTO(int codigo, int codDisciplina, int codCategoria, String descripcion, CategoriaDTO categoria,
			DisciplinaDTO disciplina) {
		super();
		this.codigo = codigo;
		this.codDisciplina = codDisciplina;
		this.codCategoria = codCategoria;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.disciplina = disciplina;
	}
	
	
}
