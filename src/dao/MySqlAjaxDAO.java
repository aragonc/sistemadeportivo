package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.CategoriaDTO;
import beans.DisciplinaDTO;
import beans.ModalidadDTO;
import interfaces.AjaxDAO;
import utils.MysqlDBConexion;

public class MySqlAjaxDAO implements AjaxDAO {

	@Override
	public List<ModalidadDTO> listarModalidadEvento(int codevento) {
		ModalidadDTO mod = null;
		List<ModalidadDTO> data = new ArrayList<ModalidadDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT m.idmodalidad, m.descripcion, d.iddisciplina, d.nombre, c.idcategoria, c.nombre "
					+ "FROM evento_modalidad em inner join modalidad m on m.idmodalidad = em.modalidad_idmodalidad "
					+ "inner join categoria c on m.categoria_idcategoria = c.idcategoria "
					+ "inner join disciplina d on  m.disciplina_iddisciplina = d.iddisciplina "
					+ "where evento_idevento = ?;";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codevento);
			rs = pstm.executeQuery();
			while (rs.next()) {
				mod = new ModalidadDTO();
				mod.setCodigo(rs.getInt(1));
				mod.setDescripcion(rs.getString(2));
				mod.setCodCategoria(rs.getInt(3));
					DisciplinaDTO a = new DisciplinaDTO();
					a.setCodigo(rs.getInt(3));
					a.setNombre(rs.getString(4));
					mod.setDisciplina(a);
				mod.setCodDisciplina(rs.getInt(5));
					CategoriaDTO b = new CategoriaDTO();
					b.setCodigo(rs.getInt(5));
					b.setNombre(rs.getString(6));
					mod.setCategoria(b);
				data.add(mod);
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
	public boolean mismoNombre(String tabla, String nom ) {
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select COUNT(*) from "+tabla+" where nombre=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nom);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}
	
	@Override
	public boolean mismaModalidad(String tabla, int codcategoria, int coddisciplina, String gen ) {
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select COUNT(*) from "+tabla+" where idcategoria=? and iddisciplina=? and tipo_genero=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codcategoria);
			pstm.setInt(2, coddisciplina);
			pstm.setString(3, gen);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}
	
	@Override
	public boolean mismoEvento(String tabla, Date fechini,Date fechfin, int codlug) {
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select count(*) from "+tabla+" where fecha_inicio <=? AND fecha_fin >=? and idlugar=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setDate(1, new java.sql.Date(fechini.getTime()));
			pstm.setDate(2, new java.sql.Date(fechfin.getTime()));
			pstm.setInt(3, codlug);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}
	
	@Override
	public boolean mismoEvento1(String tabla, Date fechini,Date fechfin, int codlug) {
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select count(*) from "+tabla+" where fecha_inicio >=? AND fecha_fin <=? and idlugar=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setDate(1, new java.sql.Date(fechini.getTime()));
			pstm.setDate(2, new java.sql.Date(fechfin.getTime()));
			pstm.setInt(3, codlug);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}
	
	@Override
	public boolean mismoEventoInicio(String tabla, Date fechini,Date fechfin, int codlug) {
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select count(*) from "+tabla+" where fecha_inicio between ? and ? and idlugar=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setDate(1, new java.sql.Date(fechini.getTime()));
			pstm.setDate(2, new java.sql.Date(fechfin.getTime()));
			pstm.setInt(3, codlug);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}
	
	@Override
	public boolean mismoEventoFin(String tabla, Date fechini,Date fechfin, int codlug) {
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select count(*) from "+tabla+" where fecha_fin between ? and ? and idlugar=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setDate(1, new java.sql.Date(fechini.getTime()));
			pstm.setDate(2, new java.sql.Date(fechfin.getTime()));
			pstm.setInt(3, codlug);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}
	
	@Override
	public boolean mismoEquipoEvento(String tabla, String nom, int codev) {
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select COUNT(*) from equipo where nombre=? and evento_idevento=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nom);
			pstm.setInt(2, codev);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}
	
	@Override
	public boolean mismoEquipoModalidad(String tabla, String nom, int codmod) {
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select COUNT(*) from equipo where nombre=? and modalidad_idmodalidad=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nom);
			pstm.setInt(2, codmod);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}
	
	@Override
	public boolean mismoDoc(String tabla, String doc ) {
		boolean unico = false;
		int valor = 0;
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select COUNT(*) from "+tabla+" where num_documento=?";
			
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, doc);
			rs = pstm.executeQuery();
			while(rs.next()){
				valor = rs.getInt(1);
				if(valor != 0){
					unico = true;
				}
				
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
		return unico;
	}

}
