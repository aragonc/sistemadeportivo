package dao;

import interfaces.AjaxDAO;
import interfaces.CategoriaDAO;
import interfaces.ComboDAO;
import interfaces.DisciplinaDAO;
import interfaces.EquipoDAO;
import interfaces.EventoDAO;
import interfaces.LugarDAO;
import interfaces.ModalidadDAO;
import interfaces.PerfilDAO;
import interfaces.PersonaDAO;
import interfaces.UsuarioDAO;


public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    
    public abstract CategoriaDAO getCategoriaDAO();
    public abstract DisciplinaDAO getDisciplinaDAO();
    public abstract EquipoDAO getEquipoDAO();
    public abstract PersonaDAO getPersonaDAO();
    public abstract ComboDAO getComboDAO();
    public abstract EventoDAO getEventoDAO();
    public abstract ModalidadDAO getModalidadDAO();
    public abstract AjaxDAO getAjaxDAO();
    public abstract LugarDAO getLugarDAO();
    public abstract PerfilDAO getPerfilDAO();
    public abstract UsuarioDAO getUsuarioDAO();

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
