package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.PerfilDTO;
import interfaces.PerfilDAO;
import utils.MysqlDBConexion;

public class MySqlPerfilDAO implements PerfilDAO{
	public List<PerfilDTO> listar(){
		PerfilDTO a = null;
		List<PerfilDTO> data = new ArrayList<PerfilDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM perfil";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new PerfilDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				data.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	
	public PerfilDTO buscarPefil(int cod){
		PerfilDTO a = null;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM perfil WHERE idperfil = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new PerfilDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return a;
	}
}
