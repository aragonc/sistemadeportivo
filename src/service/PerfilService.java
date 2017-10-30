package service;

import java.util.List;

import beans.PerfilDTO;
import dao.DAOFactory;
import interfaces.PerfilDAO;

public class PerfilService {
DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	PerfilDAO perfilDAO = factory.getPerfilDAO();
	
	public List<PerfilDTO> listar(){
		return perfilDAO.listar();
	}
	public PerfilDTO buscarPefil(int cod){
		return perfilDAO.buscarPefil(cod);
	}
}
