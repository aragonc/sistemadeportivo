package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import beans.EventoDTO;
import beans.ModalidadDTO;
import beans.PersonaDTO;
import interfaces.EventoDAO;
import service.ModalidadService;
import utils.MysqlDBConexion;

public class MySqlEventoDAO implements EventoDAO {
	ModalidadService modalidad = new ModalidadService();
	@Override
	public List<EventoDTO> listarEventos() {
		EventoDTO a = null;
		List<EventoDTO> data = new ArrayList<EventoDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM evento;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new EventoDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setDescripcion(rs.getString(3));
				a.setFechaInicio(rs.getTimestamp(4));
				a.setFechaFin(rs.getTimestamp(5));
				a.setGratuito(rs.getBoolean(6));
				a.setPrecio(rs.getDouble(7));
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
	public EventoDTO buscarEvento(int cod) {
		EventoDTO a = null;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM evento where idevento = ?;";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new EventoDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setDescripcion(rs.getString(3));
				a.setFechaInicio(rs.getTimestamp(4));
				a.setFechaFin(rs.getTimestamp(5));
				a.setGratuito(rs.getBoolean(6));
				a.setPrecio(rs.getDouble(7));
				a.setEstado(rs.getInt(8));
				List<ModalidadDTO> mod = modalidad.buscarModalidadEvento(a.getCodigo());
				a.setModalidades(mod);
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
	public int registrarEvento(EventoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO evento VALUES (null,? ,? ,? ,? ,? ,? ,? , NOW())";
			pstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDescripcion());
			pstm.setTimestamp(3, new java.sql.Timestamp(obj.getFechaInicio().getTime()));
			pstm.setTimestamp(4, new java.sql.Timestamp(obj.getFechaFin().getTime()));
			pstm.setBoolean(5, obj.getGratuito());
			pstm.setDouble(6, obj.getPrecio());
			pstm.setInt(7, obj.getEstado());
			estado = pstm.executeUpdate();
			
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
	public int actualizarEvento(EventoDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int agregarModalidad(int codEvento, int codModalidad){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO evento_modalidad VALUES (? ,? )";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codEvento);
			pstm.setInt(2, codModalidad);
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
	public int eliminarEvento(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from evento where idevento=?";
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
