package dao;
import interfaces.AjaxDAO;
import interfaces.CategoriaDAO;
import interfaces.ComboDAO;
import interfaces.DelegadoDAO;
import interfaces.DisciplinaDAO;
import interfaces.EquipoDAO;
import interfaces.EventoDAO;
import interfaces.JugadorDAO;
import interfaces.ModalidadDAO;
import interfaces.PersonaDAO;

public class MySqlDAOFactory extends DAOFactory {
	
	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new MySqlCategoriaDAO();
	}
	@Override
	public DelegadoDAO getDelegadoDAO() {
		// TODO Auto-generated method stub
		return new MySqlDelegadoDAO();
	}
	@Override
	public DisciplinaDAO getDisciplinaDAO() {
		// TODO Auto-generated method stub
		return new MySqlDisciplinaDAO();
	}
	@Override
	public EquipoDAO getEquipoDAO() {
		// TODO Auto-generated method stub
		return new MySqlEquipoDAO();
	}
	@Override
	public JugadorDAO getJugadorDAO() {
		// TODO Auto-generated method stub
		return new MySqlJugadorDAO();
	}
	@Override
	public PersonaDAO getPersonaDAO() {
		// TODO Auto-generated method stub
		return new MySqlPersonaDAO();
	}
	@Override
	public ComboDAO getComboDAO() {
		// TODO Auto-generated method stub
		return new MySqlComboDAO();
	}
	public EventoDAO getEventoDAO(){
		return new MySqlEventoDAO();
	}
	public ModalidadDAO getModalidadDAO(){
		return new MySqlModalidadDAO();
	}
	public AjaxDAO getAjaxDAO(){
		return new MySqlAjaxDAO();
	}
}

