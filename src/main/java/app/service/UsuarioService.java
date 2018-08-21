package app.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import app.recipe.Usuario;

import org.springframework.stereotype.Component;


@Path("usuario")
@Component
@Consumes("application/json")
@Produces("application/json")
public interface UsuarioService {
	
	@GET
	@Path("/getUsuarios")
	public UsuarioResponse getUsuarios();
	
	@POST
	@Path("/consultaPorUsuario")	
	 public UsuarioResponse consultaPorUsuario(Usuario usuario);
	
	@POST
	@Path("/consultaPorFecha")	
	 public UsuarioResponse consultaPorFecha(Usuario usuario);

	@POST
	@Path("/consultaPorRol")	
	 public UsuarioResponse consultaPorRol(Usuario usuario);
	
	@POST
	@Path("/consultaPorFuncPorUsuario")
	public UsuarioResponse consultaPorFuncPorUsuario(Usuario usuario);
	
	@PUT
	@Path("/save")
	public void  saveOrUpdate(Usuario usuario); 
	
	
	@DELETE
	@Path("/delete")
	public void  delete(Usuario usuario); 
	
	
	
	


}
