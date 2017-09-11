package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.MysqlDBConexion;

import beans.Disciplina;
import interfaces.DisciplinaDAO;

public class MySqlDisciplinaDAO implements DisciplinaDAO{

	@Override
	public List<Disciplina> listarDisciplina() {
		Disciplina dis = null;
		List<Disciplina> data = new ArrayList<Disciplina>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from disciplina ";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				dis = new Disciplina();
				dis.setCodigo(rs.getInt(1));
				dis.setNombre(rs.getString(2));
				dis.setFregistro(rs.getString(3));
				dis.setEstado(rs.getBoolean(4));
								
				data.add(dis);
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
	public Disciplina buscarDisciplina(int cod) {
		Disciplina dis = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from disciplina where iddisciplina=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				dis = new Disciplina();
				dis.setCodigo(rs.getInt(1));
				dis.setNombre(rs.getString(2));
				dis.setFregistro(rs.getString(3));
				dis.setEstado(rs.getBoolean(4));
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
		return dis;
	}

	@Override
	public int registrarDisciplina(Disciplina obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into disciplina values(null,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getFregistro());
			pstm.setBoolean(3, obj.getEstado());
			
			
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
	public int actualizarDisciplina(Disciplina obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update disciplina set nombre=?,fecha_registro=?, "
					+ " estado=? iddisciplina=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getFregistro());
			pstm.setBoolean(3, obj.getEstado());
			pstm.setInt(5, obj.getCodigo());
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
	public int eliminarDisciplina(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from disciplina where iddisciplina=?";
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
