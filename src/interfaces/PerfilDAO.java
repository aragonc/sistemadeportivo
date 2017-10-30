package interfaces;

import java.util.List;

import beans.ModuloDTO;
import beans.PerfilDTO;

public interface PerfilDAO {
	public List<PerfilDTO> listar();
	public PerfilDTO buscarPerfil(int cod);
	public List<ModuloDTO> listarModuloPerfil(int codPerfil);
}
