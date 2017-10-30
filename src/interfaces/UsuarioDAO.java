package interfaces;

import beans.UsuarioDTO;

public interface UsuarioDAO {
	public int registarUsuario(UsuarioDTO obj);
	public UsuarioDTO buscarUsuario(String usuario, String password);
	public boolean loginUsuario(String usuario, String password);
}
