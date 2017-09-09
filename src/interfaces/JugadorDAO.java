package interfaces;

import java.util.List;


import beans.Jugador;

public interface JugadorDAO {


	public List<Jugador> listarJugador();
	
	public Jugador buscarJugador(int cod);
	
	public int registrarJugador(Jugador obj);
	
	public int actualizarJugador(Jugador obj);
	
	public int eliminarJugador(int cod);
}
