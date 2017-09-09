package interfaces;

import java.util.List;

import beans.Delegado;

public interface DelegadoDAO {
	
	
	public List<Delegado> listarDelegado();
	
	public Delegado buscarDelegado(int cod);
	
	public int registrarDelegado(Delegado obj);
	
	public int actualizarDelegado(Delegado obj);
	
	public int eliminarDelegado(int cod);

}
