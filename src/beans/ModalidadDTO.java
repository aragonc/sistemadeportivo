package beans;

public class ModalidadDTO {
	private int codigo;
	private int codDisciplina;
	private int codCategoria;
	private String descripcion;
	private String genero;
	private int numJugadores;
	private int numVarones;
	private int numMujeres;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getNumJugadores() {
		return numJugadores;
	}
	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}
	public int getNumVarones() {
		return numVarones;
	}
	public void setNumVarones(int numVarones) {
		this.numVarones = numVarones;
	}
	public int getNumMujeres() {
		return numMujeres;
	}
	public void setNumMujeres(int numMujeres) {
		this.numMujeres = numMujeres;
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
	public ModalidadDTO(int codigo, int codDisciplina, int codCategoria, String descripcion, String genero,
			int numJugadores, int numVarones, int numMujeres, CategoriaDTO categoria, DisciplinaDTO disciplina) {
		super();
		this.codigo = codigo;
		this.codDisciplina = codDisciplina;
		this.codCategoria = codCategoria;
		this.descripcion = descripcion;
		this.genero = genero;
		this.numJugadores = numJugadores;
		this.numVarones = numVarones;
		this.numMujeres = numMujeres;
		this.categoria = categoria;
		this.disciplina = disciplina;
	}
	public ModalidadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
