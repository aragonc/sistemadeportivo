package service;

import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;

public class UsuarioService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);	
	UsuarioDAO usuarioDAO = factory.getUsuarioDAO();
	
	public int registarUsuario(UsuarioDTO obj){
		return usuarioDAO.registarUsuario(obj);
	}
}
