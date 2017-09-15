package service;

import java.util.List;

import beans.DisciplinaDTO;
import interfaces.DisciplinaDAO;
import dao.DAOFactory;

public class DisciplinaService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	DisciplinaDAO disciplinaDAO = factory.getDisciplinaDAO();
	
	public List<DisciplinaDTO> listarDisciplina() {
		return disciplinaDAO.listarDisciplina();		
	}	
	
	public DisciplinaDTO buscarDisciplina(int cod){
		return disciplinaDAO.buscarDisciplina(cod);
	}
	
	public int registrarDisciplina(DisciplinaDTO obj){
		return disciplinaDAO.registrarDisciplina(obj);
	}
	
	public int actualizarDisciplina(DisciplinaDTO obj){
		return disciplinaDAO.actualizarDisciplina(obj);
	}
	
	public int eliminarDisciplina(int cod){
		return disciplinaDAO.eliminarDisciplina(cod);
	}

}
