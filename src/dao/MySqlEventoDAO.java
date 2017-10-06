package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import beans.EventoDTO;
import beans.PersonaDTO;
import interfaces.EventoDAO;
import utils.MysqlDBConexion;

public class MySqlEventoDAO implements EventoDAO {

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
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getString(5));
				a.setTipodocumento(rs.getInt(6));
				a.setNumdocumento(rs.getString(7));
				a.setFnacimiento(rs.getDate(8));
				a.setEmail(rs.getString(9));
				a.setFono(rs.getString(10));
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
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public int eliminarEvento(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
