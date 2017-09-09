package service;

import java.util.List;

import beans.Disciplina;
import interfaces.DisciplinaDAO;
import dao.DAOFactory;

public class DisciplinaService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	DisciplinaDAO disciplinaDAO = factory.getDisciplinaDAO();
	
	public List<Disciplina> listarDisciplina() {
		return disciplinaDAO.listarDisciplina();		
	}	
	
	public Disciplina buscarDisciplina(int cod){
		return disciplinaDAO.buscarDisciplina(cod);
	}
	
	public int registrarDisciplina(Disciplina obj){
		return disciplinaDAO.registrarDisciplina(obj);
	}
	
	public int actualizarDisciplina(Disciplina obj){
		return disciplinaDAO.actualizarDisciplina(obj);
	}
	
	public int eliminarDisciplina(int cod){
		return disciplinaDAO.eliminarDisciplina(cod);
	}

}
