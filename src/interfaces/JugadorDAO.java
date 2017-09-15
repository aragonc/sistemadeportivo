package interfaces;

import java.util.List;


import beans.JugadorDTO;

public interface JugadorDAO {


	public List<JugadorDTO> listarJugador();
	
	public JugadorDTO buscarJugador(int cod);
	
	public int registrarJugador(JugadorDTO obj);
	
	public int actualizarJugador(JugadorDTO obj);
	
	public int eliminarJugador(int cod);
}
