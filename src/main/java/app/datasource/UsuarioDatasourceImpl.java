package app.datasource;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.recipe.Usuario;

@Repository
@Transactional
public class UsuarioDatasourceImpl  implements UsuarioDatasource,Serializable {
    
	@Autowired
	private SessionFactory sessionFactory;

	@Override
    public List<Usuario> findAll() {
		List<Usuario> listaUsuarios =null;
		try{
		
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			listaUsuarios = (List<Usuario>)criteria.list();
		}catch(Exception e){
			System.out.println(" findAll " + e);
		}
		return listaUsuarios;
    }
	
	
	
	@Override
    public List<Usuario> consultaPorUsuario(Usuario usuario) {
		List<Usuario> listaUsuario =null;
		try{
		
		Query query =	sessionFactory.getCurrentSession().createQuery(" select us.id,us.nombres,us.apellidos,us.email,us.telefono,us.userName,us.password,us.fechaCreacion,us.activo,us.rolId from Usuario us where us.userName = :userName ");
		query.setParameter("userName", usuario.getUsername());
		listaUsuario  = query.list();			
		}catch(Exception e){
			System.out.println(" consultaPorUsuario " + e);
		}
		return listaUsuario;
    }
	
	@Override
    public List<Usuario> consultaPorFecha(Usuario usuario) {
		List<Usuario> listaUsuario =null;
		try{
		
		Query query =	sessionFactory.getCurrentSession().createQuery(" select us.id,us.nombres,us.apellidos,us.email,us.telefono,us.userName,us.password,us.fechaCreacion,us.activo,us.rolId from Usuario us where us.fechaCreacion = :fechaCreacion ");
		query.setParameter("fechaCreacion", usuario.getFechaCreacion());
		listaUsuario  = query.list();
		System.out.println("usuario.getFechaCreacion() " +usuario.getFechaCreacion());	
		}catch(Exception e){
			System.out.println(" consultaPorFecha " + e);
		}
		return listaUsuario;
    }
	
	
	@Override
    public List<Usuario> consultaPorRol(Usuario usuario) {
		List<Usuario> listaUsuario =null;
		try{
		
		Query query =	sessionFactory.getCurrentSession().createQuery(" select us.id,us.nombres,us.apellidos,us.email,us.telefono,us.userName,us.password,us.fechaCreacion,us.activo,us.rolId from Usuario us where us.rolId = :rolId ");
		query.setParameter("rolId", usuario.getRolId());
		listaUsuario  = query.list();			
		}catch(Exception e){
			System.out.println(" consultaPorRol " + e);
		}
		return listaUsuario;
    }
	
	@Override
    public List<Usuario> consultaPorFuncPorUsuario(Usuario usuario) {
		List<Usuario> listaUsuario =null;
		try{
		
		Query query =	sessionFactory.getCurrentSession().createQuery(" select f.nombre, f.descripcion from Usuario us , Funcion f, RolFuncion rf  where us.rolId =rf.rolId and rf.funcionId = f.id and us.userName = :userName ");
		query.setParameter("userName", usuario.getUsername());
		listaUsuario  = query.list();			
		}catch(Exception e){
			System.out.println(" consultaPorFuncPorUsuario " + e);
		}
		return listaUsuario;
    }
	
	 
	
	@Override
	public void saveOrUpdate(Usuario usuario){
		try{
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().saveOrUpdate(usuario);
			sessionFactory.getCurrentSession().getTransaction().commit();
			
		}catch(Exception e){
			System.out.println(" Error saveOrUpdate UsuarioDatasourceImpl "+e);
			
		}
		
	}
	
	@Override
    
	public void delete(Usuario usuario){
		
		try{
			
        	Session	session = sessionFactory.getCurrentSession();
			session.load(Usuario.class, usuario.getId());
				session.delete(usuario);
				session.flush();
				
		}
		catch(Exception e){
			System.out.println(" Error Delete UsuarioDatasourceImpl "+ e);
		}finally{
			System.out.println(" usuario ID:"+ usuario.getId());
			
		}
		
		
	}
    	
}
