package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import beans.EquipoDTO;
import beans.PersonaDTO;
import interfaces.EquipoDAO;
import service.ModalidadService;
import service.PersonaService;
import utils.MysqlDBConexion;

public class MySqlEquipoDAO implements EquipoDAO{
	
	ModalidadService modalidad = new ModalidadService();
	PersonaService persona = new PersonaService();

	@Override
	public List<EquipoDTO> listarEquipo() {
		EquipoDTO a = null;
		List<EquipoDTO> data = new ArrayList<EquipoDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM equipo;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new EquipoDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setDescripcion(rs.getString(3));
				a.setLogo(rs.getString(4));
				a.setColor(rs.getString(7));
				a.setCodModalidad(rs.getInt(8));
				a.setEstado(rs.getInt(9));	
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
			String sql = "SELECT e.idequipo, e.nombre, e.descripcion, e.logo, e.email, e.telefono, e.color, e.modalidad_idmodalidad, " + 
					"ep.evento_idevento, e.estado, e.fecha_registro FROM equipo e " + 
					"inner join equipo_evento ep on e.idequipo = ep.equipo_idequipo " + 
					"WHERE e.idequipo = ? ";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				a = new EquipoDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setDescripcion(rs.getString(3));
				a.setLogo(rs.getString(4));
				a.setColor(rs.getString(7));
				a.setCodModalidad(rs.getInt(8));
				a.setCodEvento(rs.getInt(9));
				a.setEstado(rs.getInt(10));	
				a.setFregistro(rs.getDate(11));
				List<PersonaDTO> people = persona.buscarPersonaEquipo(a.getCodigo());
				a.setJugadores(people);
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
			String sql = "INSERT INTO equipo VALUES(null,? ,? ,? ,? ,? ,?, ?, ?, now())";
			pstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDescripcion());
			pstm.setString(3, obj.getLogo());
			pstm.setString(4, obj.getColor());
			pstm.setInt(5, obj.getCodEvento());
			pstm.setInt(6, obj.getCodModalidad());
			pstm.setInt(8, obj.getEstado());
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
			String sql = "UPDATE equipo SET nombre=?,descripcion=?, "
					+ " logo=?,email=?, telefono=?, color=?, evento_idevento=?, modalidad_idmodalidad=?, estado=? where idequipo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDescripcion());
			pstm.setString(3, obj.getLogo());
			pstm.setString(6, obj.getColor());
			pstm.setInt(7, obj.getCodEvento());
			pstm.setInt(8, obj.getCodModalidad());
			pstm.setInt(9, obj.getEstado());
			pstm.setInt(10, obj.getCodigo());
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

	public int agregarPersona(int equipo, int jugador){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO persona_equipo VALUES (? ,? )";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, jugador);
			pstm.setInt(2, equipo);
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
	
	public int agregarEquipoEvento(int equipo, int evento){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO equipo_evento VALUES (? ,? )";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, equipo);
			pstm.setInt(2, evento);
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
	
	public int actualizarEquipoEvento(int equipo, int evento){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "UPDATE equipo_evento SET evento_idevento = ? WHERE equipo_idequipo = ?;";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, evento);
			pstm.setInt(2, equipo);
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
