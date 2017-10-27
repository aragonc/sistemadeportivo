package service;

import java.util.Date;
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
	
	public boolean mismaModalidad(String tabla, int codcategoria, int coddisciplina, String gen){
		return ajaxDAO.mismaModalidad(tabla, codcategoria, coddisciplina, gen);
	}
	
	public boolean mismoEvento(String tabla, Date fechini,Date fechfin, int codlug){
		return ajaxDAO.mismoEvento(tabla, fechini,fechfin,codlug);
	}
	
	public boolean mismoEvento1(String tabla, Date fechini,Date fechfin, int codlug){
		return ajaxDAO.mismoEvento1(tabla, fechini,fechfin,codlug);
	}
	
	public boolean mismoEventoInicio(String tabla, Date fechini,Date fechfin, int codlug){
		return ajaxDAO.mismoEventoInicio(tabla, fechini,fechfin,codlug);
	}
	
	public boolean mismoEventoFin(String tabla, Date fechini,Date fechfin, int codlug){
		return ajaxDAO.mismoEventoFin(tabla, fechini,fechfin,codlug);
	}
	
	public boolean mismoEquipoEvento(String tabla, String nom, int codev){
		return ajaxDAO.mismoEquipoEvento(tabla, nom,codev);
	}
	
	public boolean mismoEquipoModalidad(String tabla, String nom, int codmod){
		return ajaxDAO.mismoEquipoModalidad(tabla, nom,codmod);
	}
	public boolean mismoDoc(String tabla, String doc){
		return ajaxDAO.mismoDoc(tabla, doc);
	}
}

