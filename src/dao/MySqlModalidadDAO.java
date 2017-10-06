package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.CategoriaDTO;
import beans.DisciplinaDTO;
import beans.ModalidadDTO;
import interfaces.ModalidadDAO;
import utils.MysqlDBConexion;

public class MySqlModalidadDAO implements ModalidadDAO {

	@Override
	public List<ModalidadDTO> listarModalidad() {
		ModalidadDTO cat = null;
		List<ModalidadDTO> data = new ArrayList<ModalidadDTO>();
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT m.idmodalidad, m.descripcion, d.iddisciplina, d.nombre, c.idcategoria, c.nombres  FROM modalidad m "
					+ "inner join categoria c on m.categoria_idcategoria = c.idcategoria inner join "
					+ "disciplina d on  m.disciplina_iddisciplina = d.iddisciplina;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				cat = new ModalidadDTO();
				cat.setCodigo(rs.getInt(1));
				cat.setDescripcion(rs.getString(2));
				DisciplinaDTO a = new DisciplinaDTO();
				a.setCodigo(rs.getInt(3));
				a.setNombre(rs.getString(4));
				cat.setDisciplina(a);
				CategoriaDTO b = new CategoriaDTO();
				b.setCodigo(rs.getInt(5));
				b.setNombre(rs.getString(6));
				cat.setCategoria(b);
				data.add(cat);
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
	public ModalidadDTO buscarModalidad(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registrarModalidad(ModalidadDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into modalidad values(null , ?, ?, ?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setInt(2, obj.getCodCategoria());
			pstm.setInt(3, obj.getCodDisciplina());
			
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
	public int actualizarModalidad(ModalidadDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarModalidad(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from modalidad where idmodalidad=?";
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
