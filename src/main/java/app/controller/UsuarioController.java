package app.controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.recipe.Usuario;
import app.service.AbstractResponse;
import app.service.QueryResult;
import app.service.UsuarioServiceImpl;
import app.service.UsuarioResponse;


@RestController
public class UsuarioController {
	
	@Autowired
	protected UsuarioServiceImpl usuarioService;
	protected ObjectMapper mapper;
	
	@RequestMapping (value ="/saveOrUpdate",method = RequestMethod.POST )
	public AbstractResponse saveUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException{
		
		 
		this.mapper = new ObjectMapper();
		
		Usuario usuario = mapper.readValue(userJson, Usuario.class);
		
		if(!this.validarUsuario(usuario)){
			
			return new AbstractResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los Campos son Requeridos");
			
		}
		this.usuarioService.saveOrUpdate(usuario);
		return new AbstractResponse(0001, "Opercion Exitosa");
	}
	
	@RequestMapping (value ="/getUsuario",method = RequestMethod.GET )
	public UsuarioResponse getUsuarios(){
		return this.usuarioService.getUsuarios();
		
	}
	
	@RequestMapping (value ="/consultaPorUsuario",method = RequestMethod.POST )
	public UsuarioResponse consultaPorUsuario(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
		Usuario usuario = mapper.readValue(userJson, Usuario.class);
		return this.usuarioService.consultaPorUsuario(usuario);
		
	}
	
	@RequestMapping (value ="/consultaPorFecha",method = RequestMethod.POST )
	public UsuarioResponse consultaPorFecha(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
		Usuario usuario = mapper.readValue(userJson, Usuario.class);
		return this.usuarioService.consultaPorFecha(usuario);
		
	}
	
	@RequestMapping (value ="/consultaPorRol",method = RequestMethod.POST )
	public UsuarioResponse consultaPorRol(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
		Usuario usuario = mapper.readValue(userJson, Usuario.class);
		return this.usuarioService.consultaPorRol(usuario);
		
	}
	
	@RequestMapping (value ="/consultaPorFuncPorUsuario",method = RequestMethod.POST )
	public UsuarioResponse consultaPorFuncPorUsuario(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException{
        this.mapper = new ObjectMapper();
		Usuario usuario = mapper.readValue(userJson, Usuario.class);
		return this.usuarioService.consultaPorFuncPorUsuario(usuario);
		
	}
	
	@RequestMapping (value ="/deleteUsuario",method = RequestMethod.POST )
	public AbstractResponse deleteRecipe(@RequestBody String userJson) throws Exception{
		
		 
		this.mapper = new ObjectMapper();
		
		Usuario usuario = mapper.readValue(userJson, Usuario.class);
		
		if (usuario.getId() ==null){
			throw new Exception(" El recipe no Existe");
		}else
		
		this.usuarioService.delete(usuario);
		return new AbstractResponse(0002, "Opercion Exitosa");
	}
	
	
	private boolean validarUsuario(Usuario usuario){
		boolean isValide = true;
		
		if(usuario.getNombres() == null || usuario.getNombres().equalsIgnoreCase("")){
          isValide =false;			
		}
		if(usuario.getApellidos() == null || usuario.getApellidos().equalsIgnoreCase("")){
	          isValide =false;			
		}
		if(usuario.getEmail() == null || usuario.getEmail().equalsIgnoreCase("")){
	          isValide =false;			
		}
		if(usuario.getFechaCreacion() == null || usuario.getFechaCreacion().toString().equalsIgnoreCase("")){
	          isValide =false;			
		}
		if(usuario.getPassword() == null || usuario.getPassword().equalsIgnoreCase("")){
	          isValide =false;			
		}
		if(usuario.getTelefono() == null || usuario.getTelefono().equalsIgnoreCase("")){
	          isValide =false;			
		}
		
		if(usuario.getUsername() == null || usuario.getUsername().equalsIgnoreCase("")){
	          isValide =false;			
		}
		return isValide;
	}

}

