package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import beans.EventoDTO;
import interfaces.EventoDAO;
import utils.MysqlDBConexion;

public class MySqlEventoDAO implements EventoDAO {

	@Override
	public List<EventoDTO> listarEventos() {
		// TODO Auto-generated method stub
		return null;
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
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDescripcion());
			System.out.println(obj.getFechaInicio());
			System.out.println(obj.getFechaInicio().getTime());
			pstm.setTimestamp(3, new java.sql.Timestamp(obj.getFechaInicio().getTime()));
			pstm.setTimestamp(4, new java.sql.Timestamp(obj.getFechaFin().getTime()));
			pstm.setBoolean(5, obj.getGratuito());
			pstm.setDouble(6, obj.getPrecio());
			pstm.setInt(7, obj.getEstado());
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
