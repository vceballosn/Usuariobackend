package app.recipe;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="rol_funcion")
@Access (AccessType.FIELD)
public class RolFuncion {

	
	@Id
	@Column(name="rol_id")
	private long rolId;
	
	@Column(name="Funcion_id")
	private long funcionId;
	
	public long getRolId() {
		return rolId;
	}

	public void setRolId(long rolId) {
		this.rolId = rolId;
	}

	public long getFuncionId() {
		return funcionId;
	}

	public void setFuncionId(long funcionId) {
		this.funcionId = funcionId;
	}
	
}
