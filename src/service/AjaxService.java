package service;

import java.util.List;

import beans.ModalidadDTO;
import dao.DAOFactory;
import interfaces.AjaxDAO;

public class AjaxService {
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	AjaxDAO ajaxDAO = factory.getAjaxDAO();
	
	public List<ModalidadDTO> listarModalidadEvento(int codevento) {
		return ajaxDAO.listarModalidadEvento(codevento);
	}
	public boolean mismoNombre(String tabla, String nom){
		return ajaxDAO.mismoNombre(tabla, nom);
	}
}

