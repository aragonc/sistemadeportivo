package service;

import java.util.List;

import beans.Delegado;
import interfaces.DelegadoDAO;
import dao.DAOFactory;

public class DelegadoService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	DelegadoDAO delegadoDAO = factory.getDelegadoDAO();
	
	public List<Delegado> listarDelegado() {
		return delegadoDAO.listarDelegado();		
	}	
	
	public Delegado buscarDelegado(int cod){
		return delegadoDAO.buscarDelegado(cod);
	}
	
	public int registrarDelegado(Delegado obj){
		return delegadoDAO.registrarDelegado(obj);
	}
	
	public int actualizarDelegado(Delegado obj){
		return delegadoDAO.actualizarDelegado(obj);
	}
	
	public int eliminarDelegado(int cod){
		return delegadoDAO.eliminarDelegado(cod);
	}

}
