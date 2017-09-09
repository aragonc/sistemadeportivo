package service;

import java.util.List;

import beans.Equipo;
import interfaces.EquipoDAO;
import dao.DAOFactory;

public class EquipoService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	EquipoDAO equipoDAO = factory.getEquipoDAO();
	
	public List<Equipo> listarEquipo() {
		return equipoDAO.listarEquipo();		
	}	
	
	public Equipo buscarEquipo(int cod){
		return equipoDAO.buscarEquipo(cod);
	}
	
	public int registrarEquipo(Equipo obj){
		return equipoDAO.registrarEquipo(obj);
	}
	
	public int actualizarEquipo(Equipo obj){
		return equipoDAO.actualizarEquipo(obj);
	}
	
	public int eliminarEquipo(int cod){
		return equipoDAO.eliminarEquipo(cod);
	}

}

