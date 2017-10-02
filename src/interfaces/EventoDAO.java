package interfaces;

import java.util.List;
import beans.EventoDTO;

public interface EventoDAO {
	
	public List<EventoDTO> listarEventos();
	
	public EventoDTO buscarEvento(int cod);
	
	public int registrarEvento(EventoDTO obj);
	
	public int actualizarEvento(EventoDTO obj);
	
	public int eliminarEvento(int cod);
}
