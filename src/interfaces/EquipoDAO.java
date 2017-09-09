package interfaces;

import java.util.List;


import beans.Equipo;

public interface EquipoDAO {
	
	public List<Equipo> listarEquipo();
	
	public Equipo buscarEquipo(int cod);
	
	public int registrarEquipo(Equipo obj);
	
	public int actualizarEquipo(Equipo obj);
	
	public int eliminarEquipo(int cod);

}
