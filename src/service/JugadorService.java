package service;

import java.util.List;

import beans.JugadorDTO;
import interfaces.JugadorDAO;
import dao.DAOFactory;

public class JugadorService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	JugadorDAO jugadorDAO = factory.getJugadorDAO();
	
	public List<JugadorDTO> listarJugador() {
		return jugadorDAO.listarJugador();		
	}	
	
	public JugadorDTO buscarJugador(int cod){
		return jugadorDAO.buscarJugador(cod);
	}
	
	public int registrarJugador(JugadorDTO obj){
		return jugadorDAO.registrarJugador(obj);
	}
	
	public int actualizarJugador(JugadorDTO obj){
		return jugadorDAO.actualizarJugador(obj);
	}
	
	public int eliminarJugador(int cod){
		return jugadorDAO.eliminarJugador(cod);
	}

}

