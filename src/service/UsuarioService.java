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
	public UsuarioDTO buscaroUsuario(String usuario, String password){
		return usuarioDAO.buscarUsuario(usuario, password);
	}
	public boolean loginUsuario(String usuario, String password){
		return usuarioDAO.loginUsuario(usuario, password);
	}
}
