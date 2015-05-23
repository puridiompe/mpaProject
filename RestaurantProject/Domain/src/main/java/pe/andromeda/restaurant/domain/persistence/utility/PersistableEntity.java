/**
 * 
 */
package pe.andromeda.restaurant.domain.persistence.utility;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * @author Puridiom-PE
 *
 */
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class PersistableEntity<T> implements Serializable {

	public abstract T getId();
}
