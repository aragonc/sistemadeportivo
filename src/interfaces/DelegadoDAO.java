package interfaces;

import java.util.List;

import beans.DelegadoDTO;

public interface DelegadoDAO {
	
	
	public List<DelegadoDTO> listarDelegado();
	
	public DelegadoDTO buscarDelegado(int cod);
	
	public int registrarDelegado(DelegadoDTO obj);
	
	public int actualizarDelegado(DelegadoDTO obj);
	
	public int eliminarDelegado(int cod);

}
