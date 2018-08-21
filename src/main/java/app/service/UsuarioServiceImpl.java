package app.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.datasource.UsuarioDatasource;
import app.recipe.Usuario;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioDatasource datasource;
	
	@Override
	public UsuarioResponse getUsuarios() {
		
		UsuarioResponse response = new UsuarioResponse();
		response.setCode(200);
		response.setDescription("ok");
		
		try{
			response.getUsuarios().addAll(datasource.findAll());
		} catch (Exception e) {
			logger.error("Error al obtener las recetas de la base de datos.");
			response.setCode(500);
			response.setDescription("Ha ocurrido un error al consultar las recetas");
		}
		
		return response;
	}
    
	
	@Override
	public UsuarioResponse consultaPorUsuario(Usuario usuario) {
		
		UsuarioResponse response = new UsuarioResponse();
		response.setCode(200);
		response.setDescription("ok");
		
		try{
			response.getUsuarios().addAll(datasource.consultaPorUsuario(usuario));
		} catch (Exception e) {
			logger.error("Error al obtener los usuarios de la base de datos.");
			response.setCode(500);
			response.setDescription("Ha ocurrido un error al consultar Usuario");
		}
		
		return response;
	}
	
	@Override
	public UsuarioResponse consultaPorFecha(Usuario usuario) {
		
		UsuarioResponse response = new UsuarioResponse();
		response.setCode(200);
		response.setDescription("ok");
		
		try{
			response.getUsuarios().addAll(datasource.consultaPorFecha(usuario));
		} catch (Exception e) {
			logger.error("Ha ocurrido un error al consultaPorFecha.");
			response.setCode(500);
			response.setDescription("Ha ocurrido un error al consultaPorFecha");
		}
		
		return response;
	}
	
	
	
	
	@Override
	public UsuarioResponse consultaPorFuncPorUsuario(Usuario usuario) {
		
		UsuarioResponse response = new UsuarioResponse();
		response.setCode(200);
		response.setDescription("ok");
		
		try{
			response.getUsuarios().addAll(datasource.consultaPorFuncPorUsuario(usuario));
		} catch (Exception e) {
			logger.error("Ha ocurrido un error al consultaPorRol");
			response.setCode(500);
			response.setDescription("Ha ocurrido un error al consultaPorRol");
		}
		
		return response;
	}
	
	
	@Override
	public UsuarioResponse consultaPorRol(Usuario usuario) {
		
		UsuarioResponse response = new UsuarioResponse();
		response.setCode(200);
		response.setDescription("ok");
		
		try{
			response.getUsuarios().addAll(datasource.consultaPorRol(usuario));
		} catch (Exception e) {
			logger.error("Ha ocurrido un error al consultaPorRol");
			response.setCode(500);
			response.setDescription("Ha ocurrido un error al consultaPorRol");
		}
		
		return response;
	}
	
	@Override
	public void saveOrUpdate(Usuario usuario){
		try{			
		 this.datasource.saveOrUpdate(usuario);
		}catch(Exception e){
			logger.error("Error al Incluir el usuario en la base de datos.");			
		}
	}
	
	@Override
	public void delete(Usuario usuario){
	
		try{
		 this.datasource.delete(usuario);
		}catch(Exception e){
			logger.error("Error al Eliminar el usuario de la base de datos.");
		}
	}
	


}
