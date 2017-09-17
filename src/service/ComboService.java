package service;

import java.util.List;
import beans.ComboDTO;
import dao.DAOFactory;
import interfaces.ComboDAO;

public class ComboService {
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ComboDAO comboDAO = factory.getComboDAO();
	
	public List<ComboDTO> listarCombo(String field){
		return comboDAO.listarCombo(field);
	}
}
