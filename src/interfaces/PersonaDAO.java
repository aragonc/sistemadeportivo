package interfaces;

import java.util.List;

import beans.Persona;

public interface PersonaDAO {
	
	public List<Persona> listarPersona();
	
	public Persona buscarPersona(int cod);
	
	public int registrarPersona(Persona obj);
	
	public int actualizarPersona(Persona obj);
	
	public int eliminarPersona(int cod);

}
