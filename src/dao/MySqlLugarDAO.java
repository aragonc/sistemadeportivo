package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.LugarDTO;
import interfaces.LugarDAO;
import utils.MysqlDBConexion;

public class MySqlLugarDAO implements LugarDAO {

	@Override
	public List<LugarDTO> listarLugar() {
		LugarDTO a = null;
		List<LugarDTO> data = new ArrayList<LugarDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM lugar ";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new LugarDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setDireccion(rs.getString(3));
				a.setLatitud(rs.getString(4));
				a.setLongitud(rs.getString(5));
				a.setEstado(rs.getInt(6));				
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
	public LugarDTO buscarLugar(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registrarLugar(LugarDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into lugar values(null , ?, ?, ?, ?, ?, now())";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDireccion());
			pstm.setString(3, obj.getLatitud());
			pstm.setString(4, obj.getLongitud());
			pstm.setInt(5, obj.getEstado());
			
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
	public int actualizarLugar(LugarDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarLugar(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from lugar where idlugar=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
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
