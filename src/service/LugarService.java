package service;

import java.util.List;

import beans.LugarDTO;
import dao.DAOFactory;
import interfaces.LugarDAO;

public class LugarService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	LugarDAO lugarDAO = factory.getLugarDAO();
	
	public List<LugarDTO> listarLugar(){
		return lugarDAO.listarLugar();
	}
	
	public LugarDTO buscarLugar(int cod){
		return lugarDAO.buscarLugar(cod);
	}
	
	public int registrarLugar(LugarDTO obj){
		return lugarDAO.registrarLugar(obj);
	}
	
	public int actualizarLugar(LugarDTO obj){
		return lugarDAO.actualizarLugar(obj);
	}
	
	public int eliminarLugar(int cod){
		return lugarDAO.eliminarLugar(cod);
	}
}
