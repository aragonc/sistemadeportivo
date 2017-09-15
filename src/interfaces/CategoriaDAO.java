package interfaces;

import java.util.List;
import beans.CategoriaDTO;

public interface CategoriaDAO {
	
	public List<CategoriaDTO> listarCategoria();
	
	public CategoriaDTO buscarCategoria(int cod);
	
	public int registrarCategoria(CategoriaDTO obj);
	
	public int actualizarCategoria(CategoriaDTO obj);
	
	public int eliminarCategoria(int cod);

}
