package utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class MysqlDBConexion {

	public static Connection getConexion(){
		Connection cn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/campeonato?autoReconnect=true&useSSL=false","root","yannoo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
		
	}	
}
