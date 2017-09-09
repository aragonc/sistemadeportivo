package service;

import java.util.List;

import beans.Jugador;
import interfaces.JugadorDAO;
import dao.DAOFactory;

public class JugadorService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	JugadorDAO jugadorDAO = factory.getJugadorDAO();
	
	public List<Jugador> listarJugador() {
		return jugadorDAO.listarJugador();		
	}	
	
	public Jugador buscarJugador(int cod){
		return jugadorDAO.buscarJugador(cod);
	}
	
	public int registrarJugador(Jugador obj){
		return jugadorDAO.registrarJugador(obj);
	}
	
	public int actualizarJugador(Jugador obj){
		return jugadorDAO.actualizarJugador(obj);
	}
	
	public int eliminarJugador(int cod){
		return jugadorDAO.eliminarJugador(cod);
	}

}

