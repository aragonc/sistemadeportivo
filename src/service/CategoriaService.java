package service;

import java.util.List;

import beans.Categoria;
import interfaces.CategoriaDAO;
import dao.DAOFactory;

public class CategoriaService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	
	CategoriaDAO categoriaDAO = factory.getCategoriaDAO();
	
	public List<Categoria> listarCategoria() {
		return categoriaDAO.listarCategoria();		
	}	
	
	public Categoria buscarCategoria(int cod){
		return categoriaDAO.buscarCategoria(cod);
	}
	
	public int registrarCategoria(Categoria obj){
		return categoriaDAO.registrarCategoria(obj);
	}
	
	public int actualizarCategoria(Categoria obj){
		return categoriaDAO.actualizarCategoria(obj);
	}
	
	public int eliminarCategoria(int cod){
		return categoriaDAO.eliminarCategoria(cod);
	}

}
