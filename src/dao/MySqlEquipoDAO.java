package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import beans.Equipo;
import interfaces.EquipoDAO;
import utils.MysqlDBConexion;

public class MySqlEquipoDAO implements EquipoDAO{

	@Override
	public List<Equipo> listarEquipo() {
		Equipo a = null;
		List<Equipo> data = new ArrayList<Equipo>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from equipo ";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new Equipo();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setLogo(rs.getString(3));
				a.setDireccion(rs.getString(4));
				a.setFregistro(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setFono(rs.getString(7));
				a.setEstado(rs.getBoolean(8));				
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
	public Equipo buscarEquipo(int cod) {
		Equipo a = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from equipo where idequipo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				a = new Equipo();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setLogo(rs.getString(3));
				a.setDireccion(rs.getString(4));
				a.setFregistro(rs.getString(5));
				a.setEmail(rs.getString(6));
				a.setFono(rs.getString(7));
				a.setEstado(rs.getBoolean(8));
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
	public int registrarEquipo(Equipo obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into equipo values(null,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getLogo());
			pstm.setString(3, obj.getDireccion());
			pstm.setString(4, obj.getFregistro());
			pstm.setString(5, obj.getEmail());
			pstm.setString(6, obj.getFono());
			pstm.setBoolean(7, obj.getEstado());
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
	public int actualizarEquipo(Equipo obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update equipo set nombre=?,logo=?, "
					+ " direccion=?,email_contacto=?, telefono_contacto=?, estado=? fecha_contacto=? where idequipo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getLogo());
			pstm.setString(3, obj.getDireccion());
			pstm.setString(4, obj.getFregistro());
			pstm.setString(5, obj.getEmail());
			pstm.setString(6, obj.getFono());
			pstm.setBoolean(7, obj.getEstado());
			pstm.setInt(8, obj.getCodigo());
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
	public int eliminarEquipo(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from equipo where idequipo=?";
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
