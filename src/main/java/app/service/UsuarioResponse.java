package app.service;

import java.util.ArrayList;
import java.util.List;

import app.recipe.Usuario;


public class UsuarioResponse extends AbstractResponse {

	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		if(usuarios==null)
			usuarios= new ArrayList<Usuario>();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
