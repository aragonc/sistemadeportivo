package interfaces;

import java.util.List;


import beans.Disciplina;

public interface DisciplinaDAO {
	
	public List<Disciplina> listarDisciplina();
	
	public Disciplina buscarDisciplina(int cod);
	
	public int registrarDisciplina(Disciplina obj);
	
	public int actualizarDisciplina(Disciplina obj);
	
	public int eliminarDisciplina(int cod);

}
