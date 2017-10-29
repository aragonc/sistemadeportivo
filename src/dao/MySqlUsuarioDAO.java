package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MysqlDBConexion;

public class MySqlUsuarioDAO implements UsuarioDAO{
	
	public int registarUsuario(UsuarioDTO obj){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO usuario VALUES (null,? ,? ,? , ?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getUsuario());
			pstm.setString(2, obj.getPassword());
			pstm.setInt(3, obj.getCodpersona());
			pstm.setInt(4, obj.getPerfil());
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
}
