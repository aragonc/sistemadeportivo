package interfaces;

import java.util.List;

import beans.EventoDTO;
import beans.ModalidadDTO;

public interface ModalidadDAO {

	public List<ModalidadDTO> listarModalidad();
	
	public ModalidadDTO buscarModalidad(int cod);
	
	public int registrarModalidad(ModalidadDTO obj);
	
	public int actualizarModalidad(ModalidadDTO obj);
	
	public int eliminarModalidad(int cod);
	
	public List<ModalidadDTO> buscarModalidadEvento(int cod);
}
