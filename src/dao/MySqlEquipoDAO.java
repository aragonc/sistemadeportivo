package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import beans.EquipoDTO;
import interfaces.EquipoDAO;
import utils.MysqlDBConexion;

public class MySqlEquipoDAO implements EquipoDAO{

	@Override
	public List<EquipoDTO> listarEquipo() {
		EquipoDTO a = null;
		List<EquipoDTO> data = new ArrayList<EquipoDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM equipo ";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new EquipoDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setLogo(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setFono(rs.getString(5));
				a.setColor(rs.getString(6));
				a.setCodModalidad(rs.getInt(7));
				a.setEstado(rs.getInt(8));	
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
	public EquipoDTO buscarEquipo(int cod) {
		EquipoDTO a = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM equipo WHERE idequipo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				a = new EquipoDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setLogo(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setFono(rs.getString(5));
				a.setColor(rs.getString(6));
				a.setCodigo(rs.getInt(7));
				a.setEstado(rs.getInt(8));	
				
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
	public int registrarEquipo(EquipoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO equipo VALUES(null,? ,? ,? ,? ,?, ?, ?, now())";
			pstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getLogo());
			pstm.setString(3, obj.getEmail());
			pstm.setString(4, obj.getFono());
			pstm.setString(5, obj.getColor());
			pstm.setInt(6, obj.getCodModalidad());
			pstm.setInt(7, obj.getEstado());
			pstm.executeUpdate();
			
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next()){
			    estado = rs.getInt(1);
			}
			
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
	public int actualizarEquipo(EquipoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "UPDATE equipo SET nombre=?,logo=?, "
					+ " email=?,telefono=?, telefono=?, estado=? fecha_contacto=? where idequipo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getLogo());
			pstm.setString(3, obj.getEmail());
			pstm.setString(4, obj.getFono());
			pstm.setString(5, obj.getColor());
			pstm.setInt(6, obj.getCodModalidad());
			pstm.setInt(7, obj.getEstado());
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
			String sql = "DELETE FROM equipo WHERE idequipo=?";
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
