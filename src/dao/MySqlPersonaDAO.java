package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import beans.PersonaDTO;
import interfaces.PersonaDAO;
import utils.MysqlDBConexion;

public class MySqlPersonaDAO implements PersonaDAO{

	@Override
	public List<PersonaDTO> listarPersona() {
		PersonaDTO a = null;
		List<PersonaDTO> data = new ArrayList<PersonaDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		String avatar = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM persona;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new PersonaDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
				a.setTipodocumento(rs.getInt(6));
				a.setNumdocumento(rs.getString(7));
				a.setFnacimiento(rs.getDate(8));
				a.setEmail(rs.getString(9));
				a.setFono(rs.getString(10));
				avatar = rs.getString(11);
				if(avatar != null && !avatar.equals("")) {
					a.setAvatar(avatar);
				} else {
					a.setAvatar(null);
				}	
				a.setPlataforma(rs.getBoolean(12));
				a.setEstado(rs.getInt(13));				
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
	
	public List<PersonaDTO> listarDelegados() {
		PersonaDTO a = null;
		List<PersonaDTO> data = new ArrayList<PersonaDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT p.idpersona, p.nombres, p.apaterno, p.amaterno, p.sexo, p.tipo_documento, p.num_documento, p.fecha_nacimiento, p.email, "
					+ "p.telefono, p.avatar, p.es_usuario, p.estado FROM persona p inner join usuario u on p.idpersona = u.idpersona where u.idperfil = 2;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new PersonaDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
				a.setTipodocumento(rs.getInt(6));
				a.setNumdocumento(rs.getString(7));
				a.setFnacimiento(rs.getDate(8));
				a.setEmail(rs.getString(9));
				a.setFono(rs.getString(10));
				a.setAvatar(rs.getString(11));
				a.setPlataforma(rs.getBoolean(12));
				a.setEstado(rs.getInt(13));				
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

	public List<PersonaDTO> listarPersonaSexo(int tipo) {
		PersonaDTO a = null;
		List<PersonaDTO> data = new ArrayList<PersonaDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		String avatar = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM persona where sexo = ? ;";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, tipo);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new PersonaDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
				a.setTipodocumento(rs.getInt(6));
				a.setNumdocumento(rs.getString(7));
				a.setFnacimiento(rs.getDate(8));
				a.setEmail(rs.getString(9));
				a.setFono(rs.getString(10));
				avatar = rs.getString(11);
				if(avatar != null && !avatar.equals("")) {
					a.setAvatar(avatar);
				} else {
					a.setAvatar(null);
				}			
				a.setPlataforma(rs.getBoolean(12));
				a.setEstado(rs.getInt(13));				
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

	public List<PersonaDTO> buscarPersonaEquipo(int equipo) {
		PersonaDTO a = null;
		List<PersonaDTO> data = new ArrayList<PersonaDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT p.idpersona, p.nombres, p.apaterno, p.amaterno, p.sexo, p.tipo_documento, p.num_documento, p.fecha_nacimiento, "
					+ "p.email, p.telefono, p.estado FROM persona p inner join "
					+ "persona_equipo pe on p.idpersona = pe.idpersona where pe.idequipo = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, equipo);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new PersonaDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
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
	public PersonaDTO buscarPersona(int cod) {
		PersonaDTO a = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM persona WHERE idpersona=?;";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				a = new PersonaDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
				a.setTipodocumento(rs.getInt(6));
				a.setNumdocumento(rs.getString(7));
				a.setFnacimiento(rs.getDate(8));
				a.setEmail(rs.getString(9));
				a.setFono(rs.getString(10));
				if(rs.getString(11)==null){
					a.setAvatar("avatar.jpg");
				}else{
					a.setAvatar(rs.getString(11));
				}
				a.setPlataforma(rs.getBoolean(12));
				a.setEstado(rs.getInt(13));	
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
	public int registrarPersona(PersonaDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO persona VALUES (null,? ,? ,? ,? ,? ,? ,? , ? ,? ,? ,? , ?,  NOW())";
			pstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApaterno());
			pstm.setString(3, obj.getAmaterno());
			pstm.setInt(4, obj.getSexo());
			pstm.setInt(5, obj.getTipodocumento());
			pstm.setString(6, obj.getNumdocumento());
			pstm.setDate(7, new java.sql.Date(obj.getFnacimiento().getTime()));
			pstm.setString(8, obj.getEmail());
			pstm.setString(9, obj.getFono());
			pstm.setString(10, obj.getAvatar());
			pstm.setBoolean(11, obj.getPlataforma());
			pstm.setInt(12, obj.getEstado());
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
	public int actualizarPersona(PersonaDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update persona set nombres=?, "
					+ " apaterno=?, amaterno=?, sexo=?, tipo_documento=?, dni=?, fecha_nacimiento=?"
					+ ", email=?, telefono_contacto=?,estado=? where idpersona=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApaterno());
			pstm.setString(3, obj.getAmaterno());
			pstm.setInt(4, obj.getSexo());
			pstm.setInt(5, obj.getTipodocumento());
			pstm.setString(6, obj.getNumdocumento());
			pstm.setDate(7, new java.sql.Date(obj.getFnacimiento().getTime()));
			pstm.setString(8, obj.getEmail());
			pstm.setString(9, obj.getFono());
			pstm.setInt(10, obj.getEstado());
			pstm.setInt(11, obj.getCodigo());
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

	public int eliminarPersona(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from persona where idpersona=?";
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
	public List<PersonaDTO> listarPersona(PersonaDTO personaDTO) {
		PersonaDTO a = null;
		List<PersonaDTO> data = new ArrayList<PersonaDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from persona";
			int countWhere=0;
			if(personaDTO!=null && personaDTO.getNombre()!=null){
				if(countWhere==0){
					sql += " where ";
				}
				sql += " nombres like ? ";
				countWhere++;		
			}
			if(personaDTO!=null && personaDTO.getApaterno()!=null){
				if(countWhere==0){
					sql += " where ";
				}else {
					sql += " and ";					
				}
				sql += " apaterno like ? ";
				countWhere++;			
			}
			
			
			
			pstm = cn.prepareStatement(sql);
			countWhere=0;
			if(personaDTO!=null && personaDTO.getNombre()!=null){
				pstm.setString(++countWhere, "%"+personaDTO.getNombre()+"%");
			}
			
			if(personaDTO!=null && personaDTO.getApaterno()!=null){
				pstm.setString(++countWhere, "%"+personaDTO.getApaterno()+"%");
			}
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new PersonaDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
				a.setAmaterno(rs.getString(4));
				a.setSexo(rs.getInt(5));
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

}
