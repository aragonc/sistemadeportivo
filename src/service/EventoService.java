package service;

import java.util.List;
import beans.EventoDTO;
import dao.DAOFactory;
import interfaces.EventoDAO;

public class EventoService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	EventoDAO eventoDAO = factory.getEventoDAO();
	
	public List<EventoDTO> listarEvento() {
		return eventoDAO.listarEventos();		
	}	
	
	public EventoDTO buscarEquipo(int cod){
		return eventoDAO.buscarEvento(cod);
	}
	
	public int registrarEquipo(EventoDTO obj){
		return eventoDAO.registrarEvento(obj);
	}
	
	public int actualizarEquipo(EventoDTO obj){
		return eventoDAO.actualizarEvento(obj);
	}
	
	public int eliminarEquipo(int cod){
		return eventoDAO.eliminarEvento(cod);
	}

}
