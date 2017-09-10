package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Delegado;
import beans.Equipo;
import beans.Jugador;
import interfaces.JugadorDAO;
import utils.MysqlDBConexion;

public class MySqlJugadorDAO implements JugadorDAO{

	@Override
	public List<Jugador> listarJugador() {
		Jugador a = null;
		List<Jugador> data = new ArrayList<Jugador>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from delegado";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new Jugador();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
				a.setNumdocumento(rs.getString(6));
				a.setEstado(rs.getBoolean(7));				
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
	public Jugador buscarJugador(int cod) {
		Jugador a = null;
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
				a = new Jugador();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
				a.setNumdocumento(rs.getString(6));
				a.setEstado(rs.getBoolean(7));		
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
	public int registrarJugador(Jugador obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into delegoria values(null,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, obj.getNumjugador());
			pstm.setDouble(2, obj.getEstatura());
			pstm.setDouble(3, obj.getPeso());
			pstm.setString(4, obj.getTiposangre());
			pstm.setInt(5, obj.getTipo());
			pstm.setInt(6, obj.getCodequipo());
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
	public int actualizarJugador(Jugador obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarJugador(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
