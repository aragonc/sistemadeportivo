package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	public List<PersonaDTO> listarPersonaBuscar(String criterio) {
		PersonaDTO a = null;
		List<PersonaDTO> data = new ArrayList<PersonaDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM persona where ;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new PersonaDTO();
				a.setCodigo(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.setApaterno(rs.getString(3));
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
				a.setSexo(rs.getString(5));
				a.setTipodocumento(rs.getInt(6));
				a.setNumdocumento(rs.getString(7));
				a.setFnacimiento(rs.getDate(8));
				a.setEmail(rs.getString(9));
				a.setFono(rs.getString(10));
				a.setEstado(rs.getInt(11));	
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
			String sql = "INSERT INTO persona VALUES (null,? ,? ,? ,? ,? ,? ,? , ? ,? ,? , NOW())";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApaterno());
			pstm.setString(3, obj.getAmaterno());
			pstm.setString(4, obj.getSexo());
			pstm.setInt(5, obj.getTipodocumento());
			pstm.setString(6, obj.getNumdocumento());
			pstm.setDate(7, new java.sql.Date(obj.getFnacimiento().getTime()));
			pstm.setString(8, obj.getEmail());
			pstm.setString(9, obj.getFono());
			pstm.setInt(10, obj.getEstado());
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
			pstm.setString(4, obj.getSexo());
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

}
