package service;

import java.util.List;
import beans.EventoDTO;
import beans.ModalidadDTO;
import dao.DAOFactory;
import interfaces.EventoDAO;

public class EventoService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	EventoDAO eventoDAO = factory.getEventoDAO();
	
	public List<EventoDTO> listarEvento() {
		return eventoDAO.listarEventos();		
	}	
	
	public EventoDTO buscarEvento(int cod){
		return eventoDAO.buscarEvento(cod);
	}
	
	public int registrarEvento(EventoDTO obj){
		return eventoDAO.registrarEvento(obj);
	}
	
	public int actualizarEvento(EventoDTO obj){
		return eventoDAO.actualizarEvento(obj);
	}
	
	public int eliminarEvento(int cod){
		return eventoDAO.eliminarEvento(cod);
	}
	
	public int eliminarEventoModalidad(int cod){
		return eventoDAO.eliminarEventoModalidad(cod);
	}
	public int agregarEventoModalidad(int codEvento, ModalidadDTO mod){
		return eventoDAO.agregarEventoModalidad(codEvento, mod);
	}
}
