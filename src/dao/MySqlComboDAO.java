package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.CategoriaDTO;
import beans.ComboDTO;
import interfaces.ComboDAO;
import utils.MysqlDBConexion;

public class MySqlComboDAO implements ComboDAO{

	@Override
	public List<ComboDTO> listarCombo(String field) {
		ComboDTO a = null;
		List<ComboDTO> data = new ArrayList<ComboDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM extrafield WHERE tipo = '"+ field + "';";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new ComboDTO();
				a.setCodigo(rs.getInt(1));
				a.setTipo(rs.getString(2));
				a.setField(rs.getString(3));
				a.setValor(rs.getString(4));
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
	public List<ComboDTO> listarComboModalidad(int evento) {
		ComboDTO a = null;
		List<ComboDTO> data = new ArrayList<ComboDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT m.idmodalidad, CONCAT(d.nombre,' - ', c.nombres) as nombremodalidad FROM evento_modalidad em " + 
					"INNER JOIN modalidad m ON em.modalidad_idmodalidad = m.idmodalidad " + 
					"INNER JOIN disciplina d ON m.disciplina_iddisciplina = d.iddisciplina " + 
					"INNER JOIN categoria c ON m.categoria_idcategoria = c.idcategoria " + 
					"WHERE em.evento_idevento = "+evento+" ;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new ComboDTO();			
				a.setField(rs.getString(1));
				a.setValor(rs.getString(2));
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
	public List<ComboDTO> listarComboSql(String misql) {
		// TODO Auto-generated method stub
		ComboDTO a = null;
		List<ComboDTO> data = new ArrayList<ComboDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = misql;
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				a = new ComboDTO();
				a.setField(rs.getString(1));
				a.setValor(rs.getString(2));
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
