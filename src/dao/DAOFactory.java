package dao;

import interfaces.CategoriaDAO;
import interfaces.ComboDAO;
import interfaces.DelegadoDAO;
import interfaces.DisciplinaDAO;
import interfaces.EquipoDAO;
import interfaces.EventoDAO;
import interfaces.JugadorDAO;
import interfaces.PersonaDAO;


public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    
    public abstract CategoriaDAO getCategoriaDAO();
    public abstract DelegadoDAO getDelegadoDAO();
    public abstract DisciplinaDAO getDisciplinaDAO();
    public abstract EquipoDAO getEquipoDAO();
    public abstract JugadorDAO getJugadorDAO();
    public abstract PersonaDAO getPersonaDAO();
    public abstract ComboDAO getComboDAO();
    public abstract EventoDAO getEventoDAO();

    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
       	case MYSQL:
        	   return new MySqlDAOFactory();
        	case XML:
        	case ORACLE:

        	default:
        	    return null;
        }
     }
}
