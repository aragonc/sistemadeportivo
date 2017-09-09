package service;

import java.util.List;

import beans.Persona;
import interfaces.PersonaDAO;
import dao.DAOFactory;

public class PersonaService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	PersonaDAO personaDAO = factory.getPersonaDAO();
	
	public List<Persona> listarPersona() {
		return personaDAO.listarPersona();		
	}	
	
	public Persona buscarPersona(int cod){
		return personaDAO.buscarPersona(cod);
	}
	
	public int registrarPersona(Persona obj){
		return personaDAO.registrarPersona(obj);
	}
	
	public int actualizarPersona(Persona obj){
		return personaDAO.actualizarPersona(obj);
	}
	
	public int eliminarPersona(int cod){
		return personaDAO.eliminarPersona(cod);
	}

}

