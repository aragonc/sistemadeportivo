package dao;
import interfaces.CategoriaDAO;
import interfaces.DelegadoDAO;
import interfaces.DisciplinaDAO;
import interfaces.EntrenadorDAO;
import interfaces.EquipoDAO;
import interfaces.JugadorDAO;
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
	public EntrenadorDAO getEntrenadorDAO() {
		// TODO Auto-generated method stub
		return new MySqlEntrenadorDAO();
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
	
}

