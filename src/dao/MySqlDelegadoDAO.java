package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.MysqlDBConexion;

import beans.DelegadoDTO;
import interfaces.DelegadoDAO;
public class MySqlDelegadoDAO implements DelegadoDAO{

	@Override
	public List<DelegadoDTO> listarDelegado() {
		DelegadoDTO del = null;
		List<DelegadoDTO> data = new ArrayList<DelegadoDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from delegado ";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				del = new DelegadoDTO();
				del.setCodigo(rs.getInt(1));
				del.setNombre(rs.getString(2));
				del.setApaterno(rs.getString(3));
				del.setAmaterno(rs.getString(4));
				del.setSexo(rs.getInt(5));
				del.setNumdocumento(rs.getString(6));
				del.setEstado(rs.getInt(7));				
				data.add(del);
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
	public DelegadoDTO buscarDelegado(int cod) {
		DelegadoDTO del = null;
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
				del = new DelegadoDTO();
				del.setCodigo(rs.getInt(1));
				del.setNombre(rs.getString(2));
				
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
		return del;
	}

	@Override
	public int registrarDelegado(DelegadoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into delegoria values(null,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			
			
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
	public int actualizarDelegado(DelegadoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update delegoria set nombres=?,genero=?, "
					+ " edad_min=?,edad_max=?, fecha_registro=? estado=? where iddelegoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			
			pstm.setInt(7, obj.getCodigo());
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
	public int eliminarDelegado(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from delegado where iddelegado=?";
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
