package service;

import java.util.List;

import beans.PersonaDTO;
import interfaces.PersonaDAO;
import dao.DAOFactory;

public class PersonaService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	PersonaDAO personaDAO = factory.getPersonaDAO();
	
	public List<PersonaDTO> listarPersona() {
		return personaDAO.listarPersona();		
	}	
	
	public PersonaDTO buscarPersona(int cod){
		return personaDAO.buscarPersona(cod);
	}
	
	public int registrarPersona(PersonaDTO obj){
		return personaDAO.registrarPersona(obj);
	}
	
	public int actualizarPersona(PersonaDTO obj){
		return personaDAO.actualizarPersona(obj);
	}
	
	public int eliminarPersona(int cod){
		return personaDAO.eliminarPersona(cod);
	}
	
	public List<PersonaDTO> listarPersona(PersonaDTO personaDTO ) {
		return personaDAO.listarPersona(personaDTO);		
	}

	public List<PersonaDTO> buscarPersonaEquipo(int equipo) {
		return personaDAO.buscarPersonaEquipo(equipo);
	}
	public List<PersonaDTO> listarDelegados() {
		return personaDAO.listarDelegados();
	}
	public List<PersonaDTO> listarPersonaSexo(int tipo) {
		return personaDAO.listarPersonaSexo(tipo);
	}
}

