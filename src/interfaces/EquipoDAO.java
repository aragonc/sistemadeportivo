package interfaces;

import java.util.List;


import beans.EquipoDTO;

public interface EquipoDAO {
	
	public List<EquipoDTO> listarEquipo();
	
	public EquipoDTO buscarEquipo(int cod);
	
	public int registrarEquipo(EquipoDTO obj);
	
	public int actualizarEquipo(EquipoDTO obj);
	
	public int eliminarEquipo(int cod);
	
	public int eliminarEquipoEvento(int cod);
	
	public int agregarPersona(int equipo, int jugador);
	
	public int agregarEquipoEvento(int equipo, int evento);
	
	public int buscarGenero(int codequipo);
	
	public int eliminarEquipoPersona(int codequipo);

}
