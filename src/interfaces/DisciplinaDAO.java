package interfaces;

import java.util.List;


import beans.DisciplinaDTO;

public interface DisciplinaDAO {
	
	public List<DisciplinaDTO> listarDisciplina();
	
	public DisciplinaDTO buscarDisciplina(int cod);
	
	public int registrarDisciplina(DisciplinaDTO obj);
	
	public int actualizarDisciplina(DisciplinaDTO obj);
	
	public int eliminarDisciplina(int cod);
	
	

}
