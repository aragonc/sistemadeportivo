package interfaces;

import java.util.List;

import beans.ModalidadDTO;

public interface AjaxDAO {
	public List<ModalidadDTO> listarModalidadEvento(int codevento);
	public boolean mismoNombre(String tabla, String nom);
}
