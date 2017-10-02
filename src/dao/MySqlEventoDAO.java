package dao;

import java.util.List;

import beans.EventoDTO;
import interfaces.EventoDAO;

public class MySqlEventoDAO implements EventoDAO {

	@Override
	public List<EventoDTO> listarEventos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventoDTO buscarEvento(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registrarEvento(EventoDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarEvento(EventoDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarEvento(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
