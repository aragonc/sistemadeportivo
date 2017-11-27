package interfaces;

import java.util.List;

import beans.PersonaDTO;

public interface PersonaDAO {
	
	public List<PersonaDTO> listarPersona();
	
	public PersonaDTO buscarPersona(int cod);
	
	public int registrarPersona(PersonaDTO obj);
	
	public int actualizarPersona(PersonaDTO obj);
	
	public int eliminarPersona(int cod);
	
	public List<PersonaDTO> listarPersona(PersonaDTO personaDTO);
	
	public List<PersonaDTO> buscarPersonaEquipo(int equipo);
	public List<PersonaDTO> listarDelegados();
	public List<PersonaDTO> listarPersonaSexo(int tipo);

}
