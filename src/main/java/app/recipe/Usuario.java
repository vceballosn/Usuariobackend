package app.recipe;


import java.io.Serializable;
import java.text.ParseException;
import java.util.List;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;







@Entity
@Table (name ="usuario")
@Access (AccessType.FIELD)
public class Usuario implements Serializable  {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",unique=true,nullable = false )
	private  Long id;
	
	@Column(name="nombres", nullable = false ,length = 150)
	private  String nombres;
	
	@Column(name="apellidos", nullable = false ,length = 150)
	private  String apellidos;
	
	@Column(name="email", nullable = false ,length = 150)
	private  String email;
	
	
	@Column(name="telefono", nullable = false ,length = 100)
	private  String telefono;
	
	@Column(name="username", nullable = false ,length = 45)
	private  String userName;
	
	@Column(name="password", nullable = false ,length = 255)
	private  String password;
	
	@Column(name="fecha_creacion", nullable = false )
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private  java.util.Calendar fechaCreacion;
	
	
	@Column(name="activo", nullable = false )
	private  int activo;
	
	@Column(name="Rol_id")
	private long rolId;
	
	@OneToOne
	@JoinColumn(name="id")
	  private Rol rol;
	
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public  java.util.Calendar getFechaCreacion()  {
		return fechaCreacion;
	}

	public void setFechaCreacion( java.util.Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
		
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	

	
	public long getRolId() {
		return rolId;
	}

	public void setRolId(long rolId) {
		this.rolId = rolId;
	}
	
	
}
