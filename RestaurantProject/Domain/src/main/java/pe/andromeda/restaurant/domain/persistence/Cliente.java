/**
 * 
 */
package pe.andromeda.restaurant.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pe.andromeda.restaurant.domain.persistence.utility.PersistenceAuditableEntity;

/**
 * @author
 *
 */
@Entity
@Table(name = "CLIENTE")
@SuppressWarnings("serial")
public class Cliente extends PersistenceAuditableEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CLIENTE", nullable = false, unique = true)
	private Integer idCliente;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "APELLIDO", nullable = true)
	private String apellido;

	@Column(name = "DNI", nullable = false)
	private Integer dni;

	@Override
	public Integer getId() {
		return idCliente;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the dni
	 */
	public Integer getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(Integer dni) {
		this.dni = dni;
	}

}
