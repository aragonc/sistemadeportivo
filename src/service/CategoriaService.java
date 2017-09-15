package service;

import java.util.List;

import beans.CategoriaDTO;
import interfaces.CategoriaDAO;
import dao.DAOFactory;

public class CategoriaService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	CategoriaDAO categoriaDAO = factory.getCategoriaDAO();
	
	public List<CategoriaDTO> listarCategoria() {
		return categoriaDAO.listarCategoria();		
	}	
	
	public CategoriaDTO buscarCategoria(int cod){
		return categoriaDAO.buscarCategoria(cod);
	}
	
	public int registrarCategoria(CategoriaDTO obj){
		return categoriaDAO.registrarCategoria(obj);
	}
	
	public int actualizarCategoria(CategoriaDTO obj){
		return categoriaDAO.actualizarCategoria(obj);
	}
	
	public int eliminarCategoria(int cod){
		return categoriaDAO.eliminarCategoria(cod);
	}

}
