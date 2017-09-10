package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.PersonaDTO;
import interfaces.PersonaDAO;
import utils.MysqlDBConexion;

public class MySqlPersonaDAO implements PersonaDAO{

	@Override
	public List<PersonaDTO> listarPersona() {
		PersonaDTO a = null;
		List<PersonaDTO> data = new ArrayList<PersonaDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from delegado";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new PersonaDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
				a.setNumdocumento(rs.getString(6));
				a.setEstado(rs.getInt(7));				
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

	@Override
	public PersonaDTO buscarPersona(int cod) {
		PersonaDTO a = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from delegoria where iddelegoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				a = new PersonaDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
				a.setNumdocumento(rs.getString(6));
				a.setEstado(rs.getInt(7));		
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

	@Override
	public int registrarPersona(PersonaDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO `campeonato`.`persona` VALUES (null,? ,? ,? ,? ,? ,? ,? , ? ,? ,? ,?, NOW())";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApaterno());
			pstm.setString(3, obj.getAmaterno());
			pstm.setInt(4, obj.getSexo());
			pstm.setInt(5, obj.getTipodocumento());
			pstm.setString(6, obj.getNumdocumento());
			pstm.setString(7, obj.getFnacimiento());
			pstm.setString(8, obj.getEmail());
			pstm.setString(9, obj.getFono());
			pstm.setString(10, obj.getMovil());
			pstm.setInt(11, obj.getEstado());
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

	@Override
	public int actualizarPersona(PersonaDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarPersona(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
