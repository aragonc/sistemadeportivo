package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import beans.ComboDTO;
import beans.ModalidadDTO;
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
		MySqlAjaxDAO ajax = new MySqlAjaxDAO();
		ComboDTO a = null;
		List<ModalidadDTO> lista = ajax.listarModalidadEvento(evento);
		System.out.println(lista);
		List<ComboDTO> data = new ArrayList<ComboDTO>();
		
		for(ModalidadDTO item : lista){
			a = new ComboDTO();
			System.out.println(item.getDisciplina().getNombre());
			a.setField(item.getDisciplina().getNombre());
			a.setField(item.getCodigo()+"");
			data.add(a);
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
