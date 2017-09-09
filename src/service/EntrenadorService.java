package service;

import java.util.List;

import beans.Entrenador;
import interfaces.EntrenadorDAO;
import dao.DAOFactory;

public class EntrenadorService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	EntrenadorDAO entrenadorDAO = factory.getEntrenadorDAO();
	
	public List<Entrenador> listarEntrenador() {
		return entrenadorDAO.listarEntrenador();		
	}	
	
	public Entrenador buscarEntrenador(int cod){
		return entrenadorDAO.buscarEntrenador(cod);
	}
	
	public int registrarEntrenador(Entrenador obj){
		return entrenadorDAO.registrarEntrenador(obj);
	}
	
	public int actualizarEntrenador(Entrenador obj){
		return entrenadorDAO.actualizarEntrenador(obj);
	}
	
	public int eliminarEntrenador(int cod){
		return entrenadorDAO.eliminarEntrenador(cod);
	}

}
