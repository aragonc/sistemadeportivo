package service;

import java.util.List;

import beans.DelegadoDTO;
import interfaces.DelegadoDAO;
import dao.DAOFactory;

public class DelegadoService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	DelegadoDAO delegadoDAO = factory.getDelegadoDAO();
	
	public List<DelegadoDTO> listarDelegado() {
		return delegadoDAO.listarDelegado();		
	}	
	
	public DelegadoDTO buscarDelegado(int cod){
		return delegadoDAO.buscarDelegado(cod);
	}
	
	public int registrarDelegado(DelegadoDTO obj){
		return delegadoDAO.registrarDelegado(obj);
	}
	
	public int actualizarDelegado(DelegadoDTO obj){
		return delegadoDAO.actualizarDelegado(obj);
	}
	
	public int eliminarDelegado(int cod){
		return delegadoDAO.eliminarDelegado(cod);
	}

}
