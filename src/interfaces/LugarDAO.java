package interfaces;

import java.util.List;
import beans.LugarDTO;

public interface LugarDAO {
	
	public List<LugarDTO> listarLugar();
	
	public LugarDTO buscarLugar(int cod);
	
	public int registrarLugar(LugarDTO obj);
	
	public int actualizarLugar(LugarDTO obj);
	
	public int eliminarLugar(int cod);
}
