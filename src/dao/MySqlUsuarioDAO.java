package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.PersonaDTO;
import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import service.PersonaService;
import utils.MysqlDBConexion;

public class MySqlUsuarioDAO implements UsuarioDAO{
	PersonaService servicePersona = new PersonaService();
	
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
	
	public UsuarioDTO buscarUsuario(String usuario, String password){
		UsuarioDTO a = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM usuario WHERE username = ? and password = ?;";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			if (rs.next()) {
				a = new UsuarioDTO();
				a.setCodigo(rs.getInt(1));
				a.setUsuario(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setCodpersona(rs.getInt(4));
				a.setPerfil(rs.getInt(5));
				PersonaDTO datos = servicePersona.buscarPersona(a.getCodpersona());
				a.setPersona(datos);
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
	
	public boolean loginUsuario(String usuario, String password){
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT COUNT(*) FROM usuario WHERE username = ? and password = ?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}
}
