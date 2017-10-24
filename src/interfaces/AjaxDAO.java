package interfaces;

import java.util.Date;
import java.util.List;

import beans.ModalidadDTO;

public interface AjaxDAO {
	public List<ModalidadDTO> listarModalidadEvento(int codevento);
	public boolean mismoNombre(String tabla, String nom);	
	public boolean mismaModalidad(String tabla, int codcategoria, int coddisciplina, String gen);
	public boolean mismoEvento(String tabla, Date fechini, int codlug);	
	public boolean mismoEquipoEvento(String tabla, String nom, int codev);
	public boolean mismoEquipoModalidad(String tabla, String nom, int codmod);
}
