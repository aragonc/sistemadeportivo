package interfaces;

import java.util.Date;
import java.util.List;

import beans.ModalidadDTO;

public interface AjaxDAO {
	public List<ModalidadDTO> listarModalidadEvento(int codevento);
	public boolean mismoNombre(String tabla, String nom);	
	public boolean mismaModalidad(String tabla, int codcategoria, int coddisciplina, String gen);
	public boolean mismoEvento(String tabla, Date fechini, Date fechfin, int codlug);	
	public boolean mismoEvento1(String tabla, Date fechini, Date fechfin, int codlug);
	public boolean mismoEventoInicio(String tabla, Date fechini, Date fechfin, int codlug);
	public boolean mismoEventoFin(String tabla, Date fechini, Date fechfin, int codlug);
	public boolean mismoEquipoEvento(String tabla, String nom, int codev);
	
	public boolean mismoDoc(String tabla, String doc);
}
