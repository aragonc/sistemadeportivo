package service;

import java.util.List;


import beans.ModalidadDTO;
import dao.DAOFactory;
import interfaces.ModalidadDAO;

public class ModalidadService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	ModalidadDAO modalidadDAO = factory.getModalidadDAO();
	
	public List<ModalidadDTO> listarModalidad() {
		return modalidadDAO.listarModalidad();		
	}	
	
	public ModalidadDTO buscarModalidad(int cod){
		return modalidadDAO.buscarModalidad(cod);
	}
	
	public int registrarModalidad(ModalidadDTO obj){
		return modalidadDAO.registrarModalidad(obj);
	}
	
	public int actualizarModalidad(ModalidadDTO obj){
		return modalidadDAO.actualizarModalidad(obj);
	}
	
	public int eliminarModalidad(int cod){
		return modalidadDAO.eliminarModalidad(cod);
	}
	public List<ModalidadDTO> buscarModalidadEvento(int cod){
		return modalidadDAO.buscarModalidadEvento(cod);
	}
	
}
