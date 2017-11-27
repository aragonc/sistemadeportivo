package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import beans.EventoDTO;
import beans.LugarDTO;
import beans.ModalidadDTO;
import interfaces.EventoDAO;
import service.LugarService;
import service.ModalidadService;
import utils.MysqlDBConexion;

public class MySqlEventoDAO implements EventoDAO {
	ModalidadService modalidad = new ModalidadService();
	LugarService lugarService = new LugarService();
	
	@Override
	public List<EventoDTO> listarEventos() {
		EventoDTO a = null;
		List<EventoDTO> data = new ArrayList<EventoDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT e.idevento, e.nombre, e.descripcion, e.fecha_fin, e.fecha_fin, e.modo, "
					+ "e.costo, l.idlugar, l.nombre, l.direccion , e.estado FROM evento e inner join lugar l on e.idlugar = l.idlugar;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new EventoDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setDescripcion(rs.getString(3));
				a.setFechaInicio(rs.getTimestamp(4));
				a.setFechaFin(rs.getTimestamp(5));
				a.setModo(rs.getInt(6));
				a.setPrecio(rs.getDouble(7));
				LugarDTO lugar = new LugarDTO();
				lugar.setCodigo(rs.getInt(8));
				lugar.setNombre(rs.getString(9));
				lugar.setDireccion(rs.getString(10));
				a.setLugar(lugar);
				a.setEstado(rs.getInt(11));
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
			String sql = "SELECT e.idevento, e.nombre, e.descripcion, e.fecha_inicio, e.fecha_fin, e.modo, e.costo, e.estado, l.idlugar, l.nombre, l.direccion, l.latitud, l.longitud "
					+ "FROM evento e inner join lugar l on e.idlugar = l.idlugar where idevento = ?;";
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
				a.setModo(rs.getInt(6));
				a.setPrecio(rs.getDouble(7));
				a.setEstado(rs.getInt(8));
				a.setCodlugar(rs.getInt(9));
				LugarDTO lugar = new LugarDTO();
				lugar.setCodigo(rs.getInt(9));
				lugar.setNombre(rs.getString(10));
				lugar.setDireccion(rs.getString(11));
				lugar.setLatitud(rs.getString(12));
				lugar.setLongitud(rs.getString(13));
				List<ModalidadDTO> mod = modalidad.buscarModalidadEvento(a.getCodigo());
				a.setLugar(lugar);
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
			String sql = "INSERT INTO evento VALUES (null,? ,? ,? ,? ,? ,? ,? , ?, NOW())";
			pstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDescripcion());
			pstm.setTimestamp(3, new java.sql.Timestamp(obj.getFechaInicio().getTime()));
			pstm.setTimestamp(4, new java.sql.Timestamp(obj.getFechaFin().getTime()));
			pstm.setInt(5, obj.getModo());
			pstm.setDouble(6, obj.getPrecio());
			pstm.setInt(7, obj.getEstado());
			pstm.setInt(8, obj.getCodlugar());
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
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update evento set nombre=?,descripcion=?,fecha_inicio=?,fecha_fin=?,modo=?,costo=?,estado=?,idlugar=? where idevento=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDescripcion());
			pstm.setTimestamp(3, new java.sql.Timestamp(obj.getFechaInicio().getTime()));
			pstm.setTimestamp(4, new java.sql.Timestamp(obj.getFechaFin().getTime()));
			pstm.setInt(5, obj.getModo());
			pstm.setDouble(6, obj.getPrecio());
			pstm.setInt(7, obj.getEstado());
			pstm.setInt(8, obj.getCodlugar());
			pstm.setInt(9, obj.getCodigo());
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
	
	public int agregarEventoModalidad(int codEvento, ModalidadDTO mod){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO evento_modalidad VALUES (? , ?, ?, ?, ?, ? )";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codEvento);
			pstm.setInt(2, mod.getCodigo());
			pstm.setInt(3, mod.getGenero());
			pstm.setInt(4, mod.getNumJugadores());
			pstm.setInt(5, mod.getNumVarones());
			pstm.setInt(6, mod.getNumMujeres());
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
	
	public int eliminarEventoModalidad(int cod){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "DELETE FROM evento_modalidad WHERE evento_idevento = ? ";
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
	@Override
	public int eliminarEvento(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "DELETE FROM evento where idevento=?";
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
