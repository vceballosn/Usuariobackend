package app.datasource;

import java.util.List;

import app.recipe.Usuario;


public interface UsuarioDatasource  {

	List<Usuario> findAll();
    void saveOrUpdate(Usuario recipe);
    void delete(Usuario recipe);
    List<Usuario> consultaPorUsuario(Usuario usuario);
    List<Usuario> consultaPorFecha(Usuario usuario);
    List<Usuario> consultaPorRol(Usuario usuario);
    List<Usuario> consultaPorFuncPorUsuario(Usuario usuario);
	
}
