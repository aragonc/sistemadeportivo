package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.MysqlDBConexion;

import beans.Delegado;
import interfaces.DelegadoDAO;
public class MySqlDelegadoDAO implements DelegadoDAO{

	@Override
	public List<Delegado> listarDelegado() {
		Delegado del = null;
		List<Delegado> data = new ArrayList<Delegado>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from delegado ";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				del = new Delegado();
				del.setCodigo(rs.getInt(1));
				del.setNombre(rs.getString(2));
				del.setGenero(rs.getInt(3));
				del.setEdadmin(rs.getInt(4));
				del.setEdadmax(rs.getInt(5));
				del.setFregistro(rs.getString(6));
				del.setEstado(rs.getBoolean(7));				
				data.add(del);
			}
		} delch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} delch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public Delegado buscarDelegado(int cod) {
		Delegado del = null;
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
				del = new Delegado();
				del.setCodigo(rs.getInt(1));
				del.setNombre(rs.getString(2));
				del.setGenero(rs.getInt(3));
				del.setEdadmin(rs.getInt(4));
				del.setEdadmax(rs.getInt(5));
				del.setFregistro(rs.getString(6));
				del.setEstado(rs.getBoolean(7));
			}
		} delch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} delch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return del;
	}

	@Override
	public int registrarDelegado(Delegado obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into delegoria values(null,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setInt(2, obj.getGenero());
			pstm.setInt(3, obj.getEdadmin());
			pstm.setInt(4, obj.getEdadmax());
			pstm.setString(5, obj.getFregistro());
			pstm.setBoolean(6, obj.getEstado());
			
			estado = pstm.executeUpdate();
		} delch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} delch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int actualizarDelegado(Delegado obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update delegoria set nombres=?,genero=?, "
					+ " edad_min=?,edad_max=?, fecha_registro=? estado=? where iddelegoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setInt(2, obj.getGenero());
			pstm.setInt(3, obj.getEdadmin());
			pstm.setInt(4, obj.getEdadmax());
			pstm.setString(5, obj.getFregistro());
			pstm.setBoolean(6, obj.getEstado());;	
			pstm.setInt(7, obj.getCodigo());
			estado = pstm.executeUpdate();
		} delch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} delch (Exception e2) {
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
