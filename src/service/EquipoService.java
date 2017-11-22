package service;

import java.util.List;

import beans.EquipoDTO;
import interfaces.EquipoDAO;
import dao.DAOFactory;

public class EquipoService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	EquipoDAO equipoDAO = factory.getEquipoDAO();
	
	public List<EquipoDTO> listarEquipo() {
		return equipoDAO.listarEquipo();		
	}	
	
	public EquipoDTO buscarEquipo(int cod){
		return equipoDAO.buscarEquipo(cod);
	}
	
	public int registrarEquipo(EquipoDTO obj){
		return equipoDAO.registrarEquipo(obj);
	}
	
	public int actualizarEquipo(EquipoDTO obj){
		return equipoDAO.actualizarEquipo(obj);
	}
	
	public int eliminarEquipo(int cod){
		return equipoDAO.eliminarEquipo(cod);
	}
	
	public int eliminarEquipoEvento(int cod) {
		return equipoDAO.eliminarEquipoEvento(cod);
	}
	
	public int agregarPersona(int equipo, int jugador){
		return equipoDAO.agregarPersona(equipo, jugador);
	}
	
	public int agregarEquipoEvento(int equipo, int evento) {
		return equipoDAO.agregarEquipoEvento(equipo, evento);
	}
	
	public String buscarGenero(int codequipo) {
		return equipoDAO.buscarGenero(codequipo);
	}
}

