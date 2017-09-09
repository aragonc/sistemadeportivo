package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.MysqlDBConexion;

import beans.Categoria;
import interfaces.CategoriaDAO;

public class MySqlCategoriaDAO implements CategoriaDAO {

	@Override
	public List<Categoria> listarCategoria() {
		Categoria cat = null;
		List<Categoria> data = new ArrayList<Categoria>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from categoria ";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				cat = new Categoria();
				cat.setCodigo(rs.getInt(1));
				cat.setNombre(rs.getString(2));
				cat.setGenero(rs.getInt(3));
				cat.setEdadmin(rs.getInt(4));
				cat.setEdadmax(rs.getInt(5));
				cat.setFregistro(rs.getString(6));
				cat.setEstado(rs.getBoolean(7));				
				data.add(cat);
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
	public Categoria buscarCategoria(int cod) {
		Categoria cat = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from categoria where idcategoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				cat = new Categoria();
				cat.setCodigo(rs.getInt(1));
				cat.setNombre(rs.getString(2));
				cat.setGenero(rs.getInt(3));
				cat.setEdadmin(rs.getInt(4));
				cat.setEdadmax(rs.getInt(5));
				cat.setFregistro(rs.getString(6));
				cat.setEstado(rs.getBoolean(7));
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
		return cat;
	}

	@Override
	public int registrarCategoria(Categoria obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into categoria values(null,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setInt(2, obj.getGenero());
			pstm.setInt(3, obj.getEdadmin());
			pstm.setInt(4, obj.getEdadmax());
			pstm.setString(5, obj.getFregistro());
			pstm.setBoolean(6, obj.getEstado());
			
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
	public int actualizarCategoria(Categoria obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update categoria set nombres=?,genero=?, "
					+ " edad_min=?,edad_max=?, fecha_registro=? estado=? where idcategoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setInt(2, obj.getGenero());
			pstm.setInt(3, obj.getEdadmin());
			pstm.setInt(4, obj.getEdadmax());
			pstm.setString(5, obj.getFregistro());
			pstm.setBoolean(6, obj.getEstado());;	
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
	public int eliminarCategoria(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from categoria where idcategoria=?";
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
