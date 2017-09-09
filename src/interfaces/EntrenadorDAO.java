package interfaces;

import java.util.List;


import beans.Entrenador;

public interface EntrenadorDAO {
	
	public List<Entrenador> listarEntrenador();
	
	public Entrenador buscarEntrenador(int cod);
	
	public int registrarEntrenador(Entrenador obj);
	
	public int actualizarEntrenador(Entrenador obj);
	
	public int eliminarEntrenador(int cod);

}
