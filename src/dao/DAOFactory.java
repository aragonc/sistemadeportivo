package dao;
/* import interfaces.BoletaDAO;
import interfaces.ClienteDAO;
import interfaces.ProductoDAO; */


public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    
    /*public abstract ProductoDAO getProductoDAO();
    public abstract ClienteDAO getClienteDAO();
    public abstract BoletaDAO getBoletaDAO(); */
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
